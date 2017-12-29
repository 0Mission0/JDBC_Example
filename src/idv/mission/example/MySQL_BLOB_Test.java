package idv.mission.example;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQL_BLOB_Test {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?unicode=true&characterEncoding=utf-8";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String fileName = "myPic.jpg";
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);

            String sql = "INSERT INTO file (name, content) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fileName);
            preparedStatement.setBinaryStream(2, fileInputStream, (int) file.length());

            preparedStatement.executeUpdate();

            connection.close();
            fileInputStream.close();
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
