package com.modbot.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createDb {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:mysql://localhost:3306/?verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "NicolasDias123!";

        Connection connect = DriverManager.getConnection(url, user, password);
        Statement stmt = connect.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS modbot_database");

        System.out.println("Db criado com sucesso");

    }
}
