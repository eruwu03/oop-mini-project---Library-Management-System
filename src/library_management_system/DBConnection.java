/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management_system;
import java.sql.*;
/**
 *
 * @author nrnjm
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library_management_system";
    private static final String USER = "najmi";
    private static final String PASSWORD = "Katakunci#25";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
