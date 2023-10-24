package Proiect_ISI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
/**
 *
 * @author Ana
 */
public class CommandLog
{

    public static void main(String[] args)
    {
        new CommandLog().commandlog();
    }

    public static void commandlog()
    {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/magazin_incaltaminte";
        String username = "root";
        String password = "oracle";
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password))
        {
            String sql = "SELECT * FROM incaltaminte";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            statement.close();
        }
        catch (SQLException e)
        {
            System.out.println("Datababse error:");
            e.printStackTrace();
        }
    }
}
