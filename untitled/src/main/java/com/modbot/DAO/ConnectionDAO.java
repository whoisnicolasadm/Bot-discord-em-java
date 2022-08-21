package com.modbot.DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    public Connection connectDB(){
        Connection connect = null;

        try {
            final String url = "jdbc:mysql://localhost:3306/modbotmod?verifyServerCertificate=false&useSSL=true";
            final String user = "root";
            final String password = "NicolasDias123!";
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão DB efetuada com sucesso!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ConnectionDAO " + e.getMessage());
        }
        return connect;
    }
}
