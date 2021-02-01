package TestSpringJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emp {
    private int id;
    private String name;
    private String gender;
    private double salary;
    private Date join_data;
    private int dept_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJoin_data(Date join_data) {
        this.join_data = join_data;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public Date getJoin_data() {
        return join_data;
    }

    public int getDept_id() {
        return dept_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Double.compare(emp.salary, salary) == 0;
    }



    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", join_data=" + join_data +
                ", dept_id=" + dept_id +
                '}';
    }

    public static List<Emp> searchAll() {
        List<Emp> arrayList = new ArrayList<Emp>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //链接数据库(获取connection对象)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databljc", "root", "root");
            //获取执行sql语句对象
            stat = conn.createStatement();
            String sql = "select *from emp";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                Emp en = new Emp();
                en.id=rs.getInt(1);
                en.name=rs.getString(2);
                en.gender=rs.getString(3);
                en.salary=rs.getDouble(4);
                en.join_data=rs.getDate(5);
                en.dept_id=rs.getInt(6);
                arrayList.add(en);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
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


        return arrayList;
    }

}
