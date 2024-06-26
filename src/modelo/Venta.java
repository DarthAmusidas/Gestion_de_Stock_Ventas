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
    
    
    //constructor vacio

    public Venta() {
    }
    //constructores

    public Venta(int id, String cliente, double total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
    }
    //getters y setters
    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    public String getCliente() {
        return cliente;}
    public void setCliente(String cliente) {
        this.cliente = cliente;}
    public double getTotal() {
        return total;}
    public void setTotal(double total) {
        this.total = total;}
    
}
