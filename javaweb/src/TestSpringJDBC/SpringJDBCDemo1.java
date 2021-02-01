package TestSpringJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import uitl.JDBCDruid;
/*
**
* 此SpringJDBC Spring框架 对 JDBC的一个封装 简化了JDBC的开发难度
* 不需要释放资源  它用完会自动释放 或自动归还给 连接池
 */
public class SpringJDBCDemo1 {
    public static void main(String[] args) {
        //创建一个JdbcTemplate 对象  此构造方法需要传一个连接池DataSource
        JdbcTemplate template= new JdbcTemplate(JDBCDruid.gerDataSource());
        String sql = "delete from zh where id = ?";
        //此方法需要传一个sql语句 后面的参数是 问号（占位符）的值，可以有多个 但是切记要一一对应
        int count = template.update(sql, 6);
        System.out.println(count);
    }
}
