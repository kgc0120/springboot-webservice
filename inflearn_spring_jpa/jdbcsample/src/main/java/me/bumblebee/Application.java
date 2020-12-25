package me.bumblebee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    // psvm -> main 메소드 자동 완성
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "gyucheol";
        String password = "pass";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created : " + connection);
            String sql = "INSERT INTO ACCOUNT VALUES(1, 'gyucheol', 'pass');";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                System.out.println("git ssh test commit21");
                statement.execute();
            }

        }
    }
}
