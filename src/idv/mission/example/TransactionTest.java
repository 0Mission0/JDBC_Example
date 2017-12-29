package idv.mission.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionTest {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?unicode=true&characterEncoding=utf-8";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            // Part.1 Use statement to fetch data
            Statement statement = connection.createStatement();

            int addResult = insert(statement);
            System.out.println("addResult = " + addResult);

            // int deleteResult = delete(statement);
            // System.out.println("deleteResult = " + deleteResult);

            connection.rollback();

            connection.close();

        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static int insert(Statement statement) throws Exception {
        String sql = "INSERT INTO person ( name, english_name, age, sex, birthday, description ) VALUES ( '比爾蓋茨', 'Bill Gates', '60', '男', '1955-10-28', 'Microsoft' )";
        int result = statement.executeUpdate(sql);
        return result;
    }

    public static int delete(Statement statement) throws Exception {
        String sql = "DELETE FROM test.person where english_name = 'Bill Gates'";
        int result = statement.executeUpdate(sql);
        return result;
    }

}
