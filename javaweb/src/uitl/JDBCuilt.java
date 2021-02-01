package uitl;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCuilt {
    private static String url;
    private static String user;
    private static String password;
    private static String dirver;


    static{

        try {
            Properties pro = new Properties();

            ClassLoader classLoader = JDBCuilt.class.getClassLoader();

            URL resource = classLoader.getResource("pro.properties");

            String path = resource.getPath();
            System.out.println(path);
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            dirver = pro.getProperty("driver");

            Class.forName(dirver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url,user,password);
    }

    public static void  close(Statement stat,Connection conn){
        if(stat==null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn==null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public  static void close(Statement stat, Connection conn, ResultSet rs){
        if(rs==null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat==null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn==null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
