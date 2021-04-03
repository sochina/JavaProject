package cn.itcast.jdbc;
import java.sql.*;
//向student表插入内容
public class jdbcDemo2 {
    public static void main(String[] args) throws Exception {
    //注册驱动
    Class.forName("com.mysql.cj.jdbc.Driver");
    //获取数据库连接对象
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bk201", "root", "123456");
    //定义sql语句
    String sql = ("insert into student values('201215129','湖中厅','男','56','CS')");
    Statement stmt = con.createStatement();
    stmt.executeUpdate(sql);
    con.setAutoCommit(true);
    System.out.println("插入成功");
    //释放资源
    stmt.close();
    con.close();
    }
}
