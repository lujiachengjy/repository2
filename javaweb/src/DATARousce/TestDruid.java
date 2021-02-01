package DATARousce;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import uitl.JDBCDruid;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TestDruid {
    public static void main(String[] args)  {
//        Properties ps = new Properties();
//
//        ClassLoader cl = TestDruid.class.getClassLoader();
//
//        InputStream is = cl.getResourceAsStream("druid.properties");
//
//        ps.load(is);
//
//        DataSource ds = DruidDataSourceFactory.createDataSource(ps);
        //获取对象
        Connection conn = null;
        PreparedStatement ps =null;
        try {
            conn = JDBCDruid.getConnection();
            String sql = "insert into zh values(null,?)";
            //把sql语句给preparedstatement
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setInt(1,6000);

            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCDruid.close(conn,ps);
        }






//        for (int i = 1; i <=10 ; i++) {
//            Connection connection = ds.getConnection();
//            System.out.println(""+i+connection);
//
//
//        }




    }
}
