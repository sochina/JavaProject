package cn.itcast.jdbc;
import java.sql.*;
public class jdbcDemo3 {
    public static void main(String[] args){
        Statement stmt = null;
        Connection con = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bk201", "root", "123456");
            //定义sql语句
            String sql = ("insert into student values('201215133','天上殿','男','35','CF')");
            stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0){
                System.out.println("添加成功");
            }
            else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
               if(stmt != null){
                   try{
                       stmt.close();
                   }
                   catch(SQLException e){
                       e.printStackTrace();
                   }
               }

            if(con != null){
                try{
                    con.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
