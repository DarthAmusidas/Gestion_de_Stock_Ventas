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
public class ProductosDAO {
    conexion cn = new conexion(); 
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarProducto(Productos pro) {
        String sql = "INSERT INTO stock (nombre, stock, `precio de compra`, `precio de venta`, codigo) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
             ps.setString(1, pro.getNombre());
             ps.setInt(2, pro.getStock());
             ps.setDouble(3, pro.getPrecompra());
             ps.setDouble(4, pro.getPreventa());
             ps.setString(5, pro.getCodigo());
             ps.execute();
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
            }
        }
    }
    public List<Productos> listarProductos() {
        List<Productos> listaPro = new ArrayList<>(); 
        String sql = "SELECT * FROM stock";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecompra(rs.getDouble("precio de compra"));
                pro.setPreventa(rs.getDouble("precio de venta"));
                pro.setCodigo(rs.getString("codigo"));
                listaPro.add(pro);
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
        return listaPro;
    }
    public boolean eliminarProducto(int id) {
    // Defino la consulta SQL para eliminar un producto según su ID.
    String sql = "DELETE FROM stock WHERE id=?";
    try {
        // conecto a la base de datos.
        con = cn.getConnection();
        // Preparo consulta SQL con el parámetro ID.
        ps = con.prepareStatement(sql);
        // Establesco valor del parámetro ID en la consulta preparada.
        ps.setInt(1, id);
        // Ejecuta la consulta SQL.
        ps.execute();
        // Si la ejecución es exitosa, retorna true.
        return true;
    } catch (SQLException e) {
        // Si ocurre una excepción SQL, imprime el error y retorna false.
        e.printStackTrace();
        return false;
    } finally {
        try {
            // Cierra el PreparedStatement si no es nulo.
            if (ps != null) ps.close();
            // Cierra la conexión si no es nula.
            if (con != null) con.close();
        } catch (SQLException ex) {
            // Si ocurre una excepción al cerrar recursos, imprime el error.
            ex.printStackTrace();
        }
    }
}
    public boolean modificarProducto(Productos producto) {
    String sql = "UPDATE stock SET nombre=?, stock=?, `precio de compra`=?, `precio de venta`=?, codigo=? WHERE id=?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, producto.getNombre());
        ps.setInt(2, producto.getStock());
        ps.setDouble(3, producto.getPrecompra());
        ps.setDouble(4, producto.getPreventa());
        ps.setString(5, producto.getCodigo());
        ps.setInt(6, producto.getId());
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
    public Productos BuscarPro(String cod) {
    Productos producto = null; // Inicio como null para manejar correctamente cuando no se encuentra el producto
    String sql = "SELECT * FROM stock WHERE codigo = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, cod);
        rs = ps.executeQuery();
        if (rs.next()) {
            producto = new Productos(); // Inicializar el producto cuando se encuentra un registro
            producto.setNombre(rs.getString("nombre"));
            producto.setStock(rs.getInt("stock"));
            producto.setPreventa(rs.getDouble("precio de venta")); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return producto;
}
}

