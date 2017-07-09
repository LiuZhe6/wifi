package cn.wust.util;

import java.sql.*;

/**
 * Created by root on 17-5-14.
 */
public class Hive {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://localhost:10000/default";
    private static String username = "hive";
    private static String password = "hive";
    private static String hdfsUri = "hdfs://localhost:9000";

    public static String selectFromHive() {
        Connection con = null;
        String s = "";
        //注册Hive的JDBC
        try {
            Class.forName(driverName);
            //创建连接
            con = DriverManager.getConnection(url,username,password);
            //Statement用来执行SQL语句
            Statement stat = con.createStatement();
            //展示分区
            String sql = "show partitions wifi_data";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                System.out.println();
                s +=rs.getString(1)+'\n';//hive的索引从1开始
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return s;

    }


}
