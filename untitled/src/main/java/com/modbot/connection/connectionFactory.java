package com.modbot.connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
    public static Connection getConnect() {
        try{
            final String url = "jdbc:mysql://localhost:3306/modbot_db?verifyServerCertificate=false&useSSL=true";
            final String user = "root";
            final String password = "NicolasDias123!";

            return DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
