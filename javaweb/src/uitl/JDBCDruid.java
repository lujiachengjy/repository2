package uitl;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDruid {
    static private DataSource ds;

    static{
        //创建properties对象
        Properties pro = new Properties();
        //用类名导入class字节码文件，用字节码文或去类加载器用类加载器获取pro文件地址
        InputStream is =JDBCDruid.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            //载入pro文件
            pro.load(is);
            //获取DataSource(连接池)接口对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取连接池DataSource
    public  static DataSource gerDataSource(){
        return  ds;
    }
    //获取Connection对象
    public static Connection getConnection() throws SQLException {
            return ds.getConnection();
    }
    //释放资源
    public  static void close(Connection conn, ResultSet rs , Statement stat){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //释放资源
    public  static void close(Connection conn,Statement stat){
        close(conn,null,stat);
    }
}
