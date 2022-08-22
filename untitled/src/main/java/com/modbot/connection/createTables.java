package com.modbot.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTables {
    public static void main(String[] args) throws SQLException {
        Connection connection = connectionFactory.getConnect();
        String sql = "CREATE TABLE IF NOT EXISTS player (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "discid VARCHAR(100)," +
                "username VARCHAR(50)," +
                "money INT," +
                "lvl INT," +
                "exp INT" +
                ")";

        Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Tabelas criada com sucesso");
    }
}
