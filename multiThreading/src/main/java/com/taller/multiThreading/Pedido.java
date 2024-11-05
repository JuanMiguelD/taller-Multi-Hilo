package com.taller.multiThreading;

public class Pedido {
    private int id;
    private String producto;
    private double precio;
    private String estado;

    public Pedido(int id, String producto, double precio) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.estado = "NUEVO";
    }

    public int getId() { return id; }
    public String getProducto() { return producto; }
    public double getPrecio() { return precio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return String.format("Pedido{id=%d, producto='%s', precio=%.2f, estado='%s'}", 
                           id, producto, precio, estado);
    }
}