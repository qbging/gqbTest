package mybatis;

import java.sql.*;

/**
 * @author guoqb
 * @date : 2019/10/12 11:36
 */
public class JDBCTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "123");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from test");
            System.out.println(resultSet);
            while(resultSet.next()){
                // 通过字段检索
                int id  = resultSet.getInt("id");
                String num = resultSet.getString("num");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 成绩: " + num);
                System.out.print(", 姓名 " + name);
                System.out.print(", 课程: " + course);
                System.out.print("\n");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
