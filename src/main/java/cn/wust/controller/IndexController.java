package cn.wust.controller;

import cn.wust.dao.ShopDao;
import cn.wust.entity.Shop;
import cn.wust.util.HiveJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by coder on 17-4-15.
 */

@Controller
public class IndexController {

    /*//日志类
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);*/

    @Autowired
    private ShopDao shopDao;

    /**
     * 展示主页
     * @return
     */
    @RequestMapping(value = "/")
    public String main(){
        List<Shop> list = shopDao.findAll();
        for (Shop l: list){
            /*logger.info("信息为:" + l.getId() + " " +
                l.getName() + " " + l.getAddress() + " " + l.getTelephone());*/
        }
        return "index";
    }




    @RequestMapping(value = "/show")
    @ResponseBody
    public String showDatabase() throws SQLException {
        return "ok";
    }

    /**
     * 展示客流量页面
     * @return
     */
    @RequestMapping(value = "/flowVolume.html")
    public String showFlowVoulumePage(){
        return "flowVolume";
    }

    /**
     * 展示入店量页面
     * @return
     */
    @RequestMapping(value = "storeVolume.html")
    public String showStoreVolumePage(){
        return "storeVolume";
    }

    /**
     * 展示入店率
     * @return
     */
    @RequestMapping(value = "shopRate.html")
    public String showShopRate(){
        return "shopRate";
    }


    /**
     * 展示住店时长
     * @return
     */
    @RequestMapping(value = "residentLength")
    public String showResidentLengthPage(){
        return "residentLength";
    }

    /**
     * 展示探针操作页面
     * @return
     */
    @RequestMapping(value = "probe.html")
    public String showProbePage(){
        return "probe";
    }
}
