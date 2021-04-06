package cn.itcast.jdbc;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class jdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bk201", "root", "123456");
        //定义sql语句
        String sql = "update student set Sage = '22' where Sno = '201215121'";

        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        //setAutoCommit(),当为true时，为自动提交;
        //setAutoCommit(),当为false时，为手动提交，需加上commit();
        con.setAutoCommit(false);
        con.commit();
        System.out.println("更新成功");
        stmt.close();
        con.close();
    }
}
