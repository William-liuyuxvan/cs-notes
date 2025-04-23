package com.william;

import com.william.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @ClassName JdbcTest
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/23 18:00
 */
public class JdbcTest {

    @Test
    public void testJdbc() throws Exception {
        // 1. 注册驱动 -> 导入驱动包
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 连接数据库
        String url = "jdbc:mysql://localhost:3306/web01";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3. 获取sql操作对象
        Statement statement = connection.createStatement();

        // 4. 操作sql
        int i = statement.executeUpdate("update user set age = 25 where id = 1");// DML
        System.out.println("影响数据数量：" + i);

        // 5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() {
        // 数据库连接信息
        String URL = "jdbc:mysql://localhost:3306/web01";
        String USER = "root";
        String PASSWORD = "1234";
        // 查询语句
        String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?";
        // 创建 User 对象的列表
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
                ) {
            // 设置查询参数
            preparedStatement.setString(1, "daqiao");
            preparedStatement.setString(2, "123456");

            // 执行查询
            ResultSet resultSet = preparedStatement.executeQuery();

            // 遍历结果集
            while (resultSet.next()) {
                // 封装到 User 对象
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")
                );
                // 输出 User 对象
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
