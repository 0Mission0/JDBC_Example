package idv.mission.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?unicode=true&characterEncoding=utf-8";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Part.1 Use statement to fetch data
            // Statement statement = connection.createStatement();
            // String sql = "SELECT * FROM person";
            // ResultSet result = statement.executeQuery(sql);
            // while (result.next()) {
            // int id = result.getInt("id");
            // String name = result.getString("name");
            // System.out.println("id:" + id + ", name: " + name);
            // }
            // result.close();

            // Part.2 Use PreStatement to fetch data
            // String sql = "SELECT * FROM person WHERE id = ?";
            // PreparedStatement preparedStatement =
            // connection.prepareStatement(sql);
            // preparedStatement.setInt(1, 1);
            // ResultSet result = preparedStatement.executeQuery();
            // while (result.next()) {
            // int id = result.getInt("id");
            // String name = result.getString("name");
            // System.out.println("id:" + id + ", name: " + name);
            // }
            // result.close();

            // Part.3 Use PreStatement to fetch limit data
            String sql = "SELECT * FROM person LIMIT ?, ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 5);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                System.out.println("id:" + id + ", name: " + name);
            }
            result.close();

        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
