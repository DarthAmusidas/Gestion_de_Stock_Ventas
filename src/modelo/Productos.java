/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mariano Cuevas
 */
public class Productos {
    
    private int id;
    private String nombre;
    private int stock;
    private double precompra;
    private double preventa;
    private String codigo;
//constructor vacio
    public Productos() {
    }
//contructores
    public Productos(int id, String nombre, int stock, double precompra, double preventa, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precompra = precompra;
        this.preventa = preventa;
        this.codigo = codigo;
    }
//getter y setters    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrecompra() {
        return precompra;
    }
    public void setPrecompra(double precompra) {
        this.precompra = precompra;
    }
    public double getPreventa() {
        return preventa;
    }
    public void setPreventa(double preventa) {
        this.preventa = preventa;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
