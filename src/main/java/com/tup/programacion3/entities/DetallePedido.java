package com.tup.programacion3.entities;

import java.util.Objects;

public class DetallePedido extends Base {
    private int cantidad;
    private Double subtotal;
    
    // Asociación Unidireccional: Detalle conoce a Producto
    private Producto producto;

    public DetallePedido() {
        super();
    }

    // El constructor es invocado internamente por Pedido garantizando la Composición
    public DetallePedido(int cantidad, Producto producto) {
        super();
        this.cantidad = cantidad;
        this.producto = producto;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        if (this.producto != null) {
            this.subtotal = this.cantidad * this.producto.getPrecio();
        } else {
            this.subtotal = 0.0;
        }
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad; 
        calcularSubtotal();
    }
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { 
        this.producto = producto; 
        calcularSubtotal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePedido que = (DetallePedido) o;
        return cantidad == que.cantidad && Objects.equals(producto, que.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, producto);
    }

    @Override
    public String toString() {
        // Evita recursión infinita mostrando solo campos descriptivos nativos
        return "DetallePedido[Producto='" + (producto != null ? producto.getNombre() : "N/A") + "', Cantidad=" + cantidad + ", Subtotal=$" + subtotal + "]";
    }
}