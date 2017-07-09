package cn.wust.util;

import cn.wust.dao.DeviceDao;
import cn.wust.entity.Device;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by root on 17-5-8.
 */
public class JsonAnal {



    public static final String [] MONTH = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public static final String [] WEEK = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

    public JsonAnal() {
    }

    /*public static ArrayList<String> getHiveCol(String rawJson) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(rawJson);
        InfoReport info = (InfoReport)gson.fromJson(el, InfoReport.class);
        ArrayList<String> hive_cols = new ArrayList();
        String [] dateString;

        //格式 Tue May  2  22:44:46 2017
        //分别对应数组下标0 1 3 4 5
        int w,m,d,y;//对应的星期几和月份和日和年
        int h;//对应的小时
        int identify,position;
        if (info.getData().size()>=1){
            dateString = info.getTime().split(" ");
            w = parseWeek(dateString[0]);
            m = parseMonth(dateString[1]);
            d = Integer.parseInt(dateString[3]);
            h = parseHour(dateString[4]);
            y = Integer.parseInt(dateString[5]);
            System.out.println("年:"+y+" 月:"+m+
            " 日:"+d+" 时:"+h + " 星期"+w);

            Device device =

        }
        for(int i = 0; i < info.getData().size(); ++i) {
            InfoReport.OneCol oneCol = info.getData().get(i);
            StringBuilder s = new StringBuilder();
            s.append(w).append('\t')
                    .append(m).append('\t')
                    .append(d).append('\t')
                    .append(h).append('\t')
                    .append(y).append('\t')
                    .append(oneCol.getMac()).append('\t')
                    .append(oneCol.getRssi()).append('\t')
                    .append()
        }

        return hive_cols;
    }

    private static int parseHour(String s) {
        String [] timeString = s.split(":");
        int hour = Integer.parseInt(timeString[0]);
        return hour;
    }

    private static int parseMonth(String s) {
        for (int i = 0 ;i<month.length;i++){
            if (s.equals(month[i])){
                return i+ 1;
            }
        }
        return -1;
    }

    private static int parseWeek(String s) {
        for (int i = 0;i<week.length;i++){
            if (s.equals(week[i]))
                return i+1;
        }
        return -1;
    }*/
}
