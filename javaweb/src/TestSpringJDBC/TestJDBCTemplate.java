package TestSpringJDBC;

//import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import uitl.JDBCDruid;

import java.util.List;
import java.util.Map;

public class TestJDBCTemplate {
    private JdbcTemplate template = new JdbcTemplate(JDBCDruid.gerDataSource());
    //@Test
    public void text1(){
        String sql = "select * from emp where id=?";
        Map<String, Object> temMap = template.queryForMap(sql, 1);
        System.out.println(temMap);
    }
   // @Test
    public void text2(){
        String sql = "select * from emp ";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map:maps) {
            System.out.println(maps);
        }
    }
    //@Test
    public void text3(){
        String sql = "select * from emp ";
        List<Emp> query = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp e:query ) {
            System.out.println(e);
        }
    }
    //@Test
    public void text4(){
        String sql = "select count(id) from emp id!=?";
        Long aLong = template.queryForObject(sql,Long.class,1);
        System.out.println(aLong);
    }
}
