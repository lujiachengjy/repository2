package TestUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update01 {
    public static void main(String[] args){
        //提高作用域
        Connection conn=null;
        Statement stat=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1", "root", "root");
            stat = conn.createStatement();
            String sql1 = "update zh set balance=balance+ 100 where id=1";
            String sql2 = "insert into zh values(null,3000)";
            int count1 = stat.executeUpdate(sql1);
            int count2 = stat.executeUpdate(sql2);
            System.out.println(count1 +"  "+count2);
            if(count1>0){
                System.out.println("修改成功！");
            }
            if(count2>0){
                System.out.println("添加成功！");
            }
            stat.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(conn!=null){
                try {
                    conn.close();
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
    }
}
