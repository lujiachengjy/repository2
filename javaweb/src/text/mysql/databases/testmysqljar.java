package text.mysql.databases;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;


public class testmysqljar {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        Statement state = conn.createStatement();
        String sql = "update zh set balance =2000";
        state.executeUpdate(sql);
        state.close();
        conn.close();


    }
}
