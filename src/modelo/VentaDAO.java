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

/**
 *
 * @author Mariano Cuevas
 */
public class VentaDAO {
  conexion cn = new conexion(); 
  Connection con;
  PreparedStatement ps;
  ResultSet rs; 
//metodos:  
  public int IdVenta() {
    int id = 0;
    String sql = "SELECT MAX(id) FROM ventas";
    
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();  
        }
    }
    
    return id;
}
  public boolean RegistrarVenta(Venta v) {
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
    String sql = "INSERT INTO detalles (codigo, cantidad, producto, precio, id_venta) VALUES (?, ?, ?, ?,?)";
    int r = 0; 
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dv.getCodigo());
            ps.setInt(2, dv.getCantidad());
            ps.setString(3, dv.getProducto());
            ps.setDouble(4, dv.getPrecio());
            ps.setInt(5, dv.getId());
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
  public boolean ActualizarStock(int cant, String cod) {
    String sql = "UPDATE stock SET stock = ? WHERE codigo = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, cant);
        ps.setString(2, cod);
        ps.executeUpdate(); 
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
} 
  public List<Venta> listarVenta() {
        List<Venta> listaVen = new ArrayList<>(); 
        String sql = "SELECT * FROM ventas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta ven = new Venta();
                ven.setId(rs.getInt("id"));
                ven.setCliente(rs.getString("cliente"));
                ven.setTotal(rs.getDouble("Total"));
                listaVen.add(ven);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaVen;
    }  
}
