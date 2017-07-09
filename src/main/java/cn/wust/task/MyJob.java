package cn.wust.task;

import cn.wust.util.HiveJDBC;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 17-5-16.
 */
@Component
public class MyJob {

    private String pyPath = "\'/home/coder/workspace/";

    public MyJob() {
        System.out.println("MyJob创建成功");
    }

    //@Scheduled(cron = "0/1 * * * * ? ")//每隔1秒执行一次
    /*public void run(){
        System.out.println("Hello MyJob"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }*/

    //@Scheduled(cron = "0/60 * * * * ? ")  //每分钟执行一次
    public void testPython(){
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("python /home/coder/workspace/javaPython.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
            in.close();
            process.waitFor();
            System.out.println("执行脚本结束");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * 客流量统计，每小时进行计算
     */
    //@Scheduled(cron = "0/40 * * * * ? ")
    public void flowCount(){
        HiveJDBC hiveJDBC = new HiveJDBC();
        Connection con = hiveJDBC.getConnectionFromHive();
        StringBuilder fileName = new StringBuilder("passenger_flow_count.py\'");
        StringBuilder sql = new StringBuilder();
        sql.append("FROM wifi_data\n" +
                "SELECT TRANSFORM(pmac)\n" +
                "USING ")
                .append(pyPath)
                .append(fileName)
                .append("WHERE shopno=00001 and dt='2017-05-14' and hour=19");
        try {
            Statement statement = con.createStatement();
            statement.execute(sql.toString());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
