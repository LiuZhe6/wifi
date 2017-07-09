package cn.wust.controller;


import cn.wust.dao.DeviceDao;
import cn.wust.entity.Device;
import cn.wust.util.HiveJDBC;
import cn.wust.util.InfoReport;
import cn.wust.util.JsonAnal;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by coder on 17-4-15.
 */

@Controller
public class DataController {

    @Autowired
    private DeviceDao deviceDao;

    @PostMapping(value = "/data")
    @ResponseBody
    public String data(HttpServletRequest request) throws SQLException, UnsupportedEncodingException {
        String d = request.getParameter("data");
        System.out.println(d);
        String data = getHiveCol(d);
//        System.out.println(data);
//        System.out.println("***********************************");
        HiveJDBC.insertToHive(data);
        return "ok";
    }

    /**
     *
     * @param rawJson   原始Json字符串
     * @return          解析过的Json,可以直接存入数据库
     */
    public String getHiveCol(String rawJson) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(rawJson);
        InfoReport info = (InfoReport)gson.fromJson(el, InfoReport.class);
        String [] dateString;

        //格式 Tue May  2  22:44:46 2017
        //分别对应数组下标0 1 3 4 5
        int w = 0,m = 0,d = 0,y = 0;//对应的星期几和月份和日和年
        int[] t = new int[3];//对应的小时
        int shopId = 0;
        String position = null;
        if (info.getData().size()>=1){
            System.out.println(info.getTime());
            dateString = info.getTime().split(" ");
            w = parseWeek(dateString[0]);
            m = parseMonth(dateString[1]);
            d = Integer.parseInt(dateString[2]);
            t = parseTime(dateString[3]);
            y = Integer.parseInt(dateString[4]);
            /*System.out.println("年:"+y+" 月:"+m+
                    " 日:"+d+" 时:"+h + " 星期"+w);*/

            Device device = deviceDao.findByIdentify(info.getId());
            shopId = device.getShopId();
            position = device.getPosition();
            device.setLatestTime(new Date(info.getTime()));
            //更新设备传递的时间
            deviceDao.save(device);
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < info.getData().size(); ++i) {
            InfoReport.OneCol oneCol = info.getData().get(i);

            s.append(w).append('\t')
                    .append(m).append('\t')
                    .append(d).append('\t')
                    .append(t[0]).append('\t')
                    .append(t[1]).append('\t')
                    .append(t[2]).append('\t')
                    .append(y).append('\t')
                    .append(oneCol.getMac()).append('\t')
                    .append(oneCol.getRssi()).append('\t')
                    .append(shopId).append('\t')
                    .append(position).append('\n');
        }

        return s.toString();
    }

    private static int[] parseTime(String s) {
        String [] timeString = s.split(":");
        int [] time = new int[3];
        time[0] = Integer.parseInt(timeString[0]);
        time[1] = Integer.parseInt(timeString[1]);
        time[2] = Integer.parseInt(timeString[2]);
        return time;
    }

    private  int parseMonth(String s) {
        for (int i = 0 ;i<JsonAnal.MONTH.length;i++){
            if (s.equals(JsonAnal.MONTH[i])){
                return i+ 1;
            }
        }
        return -1;
    }

    private static int parseWeek(String s) {
        for (int i = 0;i<JsonAnal.WEEK.length;i++){
            if (s.equals(JsonAnal.WEEK[i]))
                return i+1;
        }
        return -1;
    }
}
