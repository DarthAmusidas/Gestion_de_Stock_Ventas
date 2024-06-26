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
public class ClienteDAO {

    conexion cn = new conexion(); 
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    //metodos
    public boolean registrarCliente(cliente c1) { // Recibe un objeto Cliente como parámetro
        String sql = "INSERT INTO clientes(dni, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, c1.getDni()); 
            ps.setString(2, c1.getNombre());
            ps.setString(3, c1.getTelefono()); 
            ps.setString(4, c1.getDireccion());
            ps.execute();
            return true; // Retorna true si la operación es exitosa
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime la pila de excepciones para ayudar en la depuración
            return false; // Retorna false si hay una excepción
        }
    }
    public List<cliente> listarClientes() {
        List<cliente> listaCl = new ArrayList<>(); 
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente cl = new cliente();
                cl.setId(rs.getInt("id"));
                cl.setDni(rs.getInt("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                listaCl.add(cl);
            }
        } catch (SQLException e){
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
        return listaCl;
}
    public boolean EliminarCliente(int id){
  // Define la consulta SQL para eliminar un cliente según su ID.
    String sql = "DELETE FROM clientes WHERE id=?";
    try {
        // asi obtengo conexión a la base de datos.
        con = cn.getConnection();
        // preparo consulta a SQL con el parámetro.
        ps = con.prepareStatement(sql);
        // Establece el valor del parámetro ID en la consulta preparada.
        ps.setInt(1, id);
        // Ejecuta la consulta SQL.
        ps.execute();
        // Si la ejecución es exitosa, retorna true.
        return true;
    } catch (SQLException e) {
        // Si ocurre una excepción SQL, imprime el error y retorna false.
        System.out.println(e.toString());
        return false;
    } finally {
        try {
            // Cierra el PreparedStatement si no es nulo.
            if (ps != null) ps.close();
            // Cierra la conexión si no es nula.
            if (con != null) con.close();
        } catch (SQLException ex) {
            // Si ocurre una excepción al cerrar recursos, imprime el error.
            System.out.println(ex.toString());
        }
    }
}
    public boolean ModificarCliente(cliente cl) {
   String sql = "UPDATE clientes SET dni=?, nombre=?, telefono=?, direccion=? WHERE id=?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, cl.getDni());
        ps.setString(2, cl.getNombre());
        ps.setString(3, cl.getTelefono());
        ps.setString(4, cl.getDireccion());
        ps.setInt(5, cl.getId());
        ps.execute();   
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
    public cliente BuscarCliente(int dni) {
    cliente cl = null;  // Inicializa como null para poder verificar más adelante
    String sql = "SELECT * FROM clientes WHERE dni = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, dni);  // Configura el parámetro en la consulta
        rs = ps.executeQuery();
        if (rs.next()) {
            cl = new cliente();
            cl.setDni(rs.getInt("dni"));
            cl.setNombre(rs.getString("nombre"));
            cl.setTelefono(rs.getString("telefono"));
            cl.setDireccion(rs.getString("direccion"));
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
    return cl;
}

    }

  
