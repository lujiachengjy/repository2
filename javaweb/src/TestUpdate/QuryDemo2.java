package TestUpdate;

import uitl.JDBCuilt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuryDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        try {
/*            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1", "root", "root");*/
            conn = JDBCuilt.getConnection();
            stat = conn.createStatement();
            String sql = "select *from zh";
            rs = stat.executeQuery(sql);
            rs.next();
            int id = rs.getInt(1);
            int balance=rs.getInt(2);
            System.out.println(id+"         "+balance);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCuilt.close(stat,conn);
        }
    }
}
