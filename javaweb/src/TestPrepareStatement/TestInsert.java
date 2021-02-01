package TestPrepareStatement;

import uitl.JDBCuilt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) {
        String name="dy123";
        String password="123";
        /*if (!search(name)){
            insert_into(name, "123");
            System.out.println("创建成功！");
        }else {
            System.out.println("创建失败！");
        }*/
        if (search(name,password)){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }

    private  static boolean search(String name,String password){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCuilt.getConnection();
            System.out.println(conn);
            String sql = "select *from sign_in where user_name = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static  boolean search(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCuilt.getConnection();
            String sql = "select *from sign_in where user_name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static int insert_into(String name,String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCuilt.getConnection();
            //定义sql
            String sql = "insert into sign_in values(?,?)";
            //让ps读取sql
            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setString(1, name);
            ps.setString(2, password);
            //执行sql
            return ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCuilt.close(ps, conn);
        }
        return 1;
    }
}
