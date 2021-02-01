package DATARousce;

/**
 * 初始化5个
 *    <property name="initialPoolSize">5</property>
 *    最大10个超过十个报错
 *     <property name="maxPoolSize">10</property>
 *     等待时间为3秒  超过此时间 报错
 *     <property name="checkoutTimeout">3000</property>
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestC3P0 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        //多态使用  创建连接池对象  自动载入 src下 c3p0-config.xml 文件
        DataSource ds= new ComboPooledDataSource();

        Connection conn = null;
        try {
            //获取链接对象
            conn = ds.getConnection();
            //归还到链接池
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取最大容量
        for (int i = 1; i <=10 ; i++) {
            Connection connection = null;
            try {
                connection = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(i+"  "+connection);
        }


    }

    private static void test2() {

    }
}
