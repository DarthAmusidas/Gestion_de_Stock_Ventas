/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mariano Cuevas
 */
public class Venta {
    private int id;
    private String cliente;
    private double total;
    private String codigo;
    private int cantidad;
 //constructor vacio

    public Venta() {
    }
 //constructores

    public Venta(int id, String cliente, double total, String codigo, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    //Getters and Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }    
    
}
