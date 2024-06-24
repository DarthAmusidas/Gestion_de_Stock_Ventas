
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Mariano Cuevas
 */
public class conexion {
    private Connection con;

    public Connection getConnection() {
        try {
            String myBD = "jdbc:mysql://localhost:3306/gestionventas?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");  // Asegúrate de que la contraseña es correcta
        } catch (SQLException e) {
            System.out.println(e.toString());
            con = null;
        }
        return con;
    }
}
