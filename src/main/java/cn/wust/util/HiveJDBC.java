package cn.wust.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by coder on 17-4-26.
 */
public class HiveJDBC {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://localhost:10000/default";
    private static String username = "hive";
    private static String password = "hive";
    private static String hdfsUri = "hdfs://localhost:9000";

    public Connection getConnectionFromHive() {

        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //创建连接并返回
        return con;
    }

    public boolean closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean insertToHive(String hiveData){
        Connection con = null;

        boolean result;
        //注册Hive的JDBC
        try {
            Class.forName(driverName);
            //创建连接
            con = DriverManager.getConnection(url,username,password);
            //Statement用来执行SQL语句
            Statement stat = con.createStatement();
            //判断今天的分区是否存在
            java.util.Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            StringBuilder partitionStringSQL = new StringBuilder();
            partitionStringSQL.append("alter table wifi_data add if not exists partition (dt=");
            String partition = sdf.format(date);
            partitionStringSQL.append("\'"+partition+"\')");
//            System.out.println("sql"+partitionStringSQL.toString());
            //如果不存在,则创建分区(存在则自动忽略)
            stat.execute(partitionStringSQL.toString());
            //存储刚刚得到的数据
            String newFile = hdfsUri +"/tmp/data/"+ date.getTime();
//            String newFile = hdfsUri+"/tmp/data/1494750452941";
            Configuration config = new Configuration();

            FileSystem hdfs = FileSystem.get(URI.create(newFile),config);
            FSDataOutputStream os = hdfs.create(new Path(newFile));

           /* FSDataInputStream is = hdfs.open(new Path(newFile));
            byte [] bytes = new byte[4096];
            is.read(bytes);
            //测试通过结果为
            System.out.println(new String(bytes,"UTF-8"));*/

            /*System.out.println("路径为:"+new Path(newFile).toString());
            System.out.println("分区为:"+partition);*/
            //存入数据库
            String sql = "load data inpath \'"+newFile+"' " +
                    " into table wifi_data " +
                    " partition (dt=\'"+partition+"\') ";
            stat.execute(sql);
            os.write(hiveData.getBytes("UTF-8"));
            os.close();
            //删除文件
            hdfs.delete(new Path(newFile),true);
            hdfs.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                return false;
            }
        }

        return true;
    }

}



