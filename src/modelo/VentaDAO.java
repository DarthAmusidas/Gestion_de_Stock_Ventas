/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Mariano Cuevas
 * 
 */
public class VentaDAO {
    public boolean RegistrarVenta(Venta v) {
        Connection con = null;
        PreparedStatement ps = null;
        conexion cn = new conexion();
        String sql = "INSERT INTO ventas ( cliente, total) VALUES (?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setDouble(2, v.getTotal());
            ps.execute();
            return true;  // Retornar true si la venta se registró correctamente
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false; 
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   public int RegistrarDetalle(Detalle dv) {
    String sql = "INSERT INTO detalles (codigo, cantidad, precio) VALUES (?, ?, ?)";
    Connection con = null;
    PreparedStatement ps = null;
    conexion cn = new conexion();
    int r = 0; 
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dv.getCodigo());
            ps.setInt(2, dv.getCantidad());
            ps.setDouble(3, dv.getPrecio());
            r = ps.executeUpdate(); 
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return r;  
}
}
