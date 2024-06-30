/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author Mariano Cuevas
 */
public class Detalle {
   int id;	
   String codigo;
   int cantidad;
   String producto;
   double precio;	
   String getProducto;
   int id_venta;
   
 //constructor vacio
public Detalle() {
    }
   //constructores
    public Detalle(int id, String codigo, int cantidad, String producto, double precio, int id_venta) {
        this.id = id;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.producto = producto;
        this.precio = precio;
        this.id_venta= id_venta;
    }
//Getters y Setters
    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    public String getCodigo() {
        return codigo;}
    public void setCodigo(String codigo) {
        this.codigo = codigo;}
    public int getCantidad() {
        return cantidad;    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;}
    public double getPrecio() {
        return precio;}
    public void setPrecio(double precio) {
        this.precio = precio;}
    public String getProducto() {
        return producto;}
    public void setProducto(String producto) {
        this.producto = producto;}
    public String getGetProducto() {
        return getProducto;
    }
    public void setGetProducto(String getProducto) {
        this.getProducto = getProducto;
    }
    public int getId_venta() {
        return id_venta;
    }
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
}

