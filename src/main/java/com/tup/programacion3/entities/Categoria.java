package com.tup.programacion3.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;
    
    // AGREGACIÓN (◊→): Multiplicidad 1..m controlada mediante Set de Productos independientes
    private Set<Producto> productos = new HashSet<>();

    public Categoria() {
        super();
    }

    public Categoria(Long id, String nombre, String descripcion) {
        super(id);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            this.productos.add(producto);
        }
    }

    public boolean eliminarProducto(Producto producto) {
        return this.productos.remove(producto);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Set<Producto> getProductos() { return productos; }
    public void setProductos(Set<Producto> productos) { this.productos = productos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Categoria[ID=" + id + ", Nombre='" + nombre + "', TotalProductos=" + productos.size() + "]";
    }
}