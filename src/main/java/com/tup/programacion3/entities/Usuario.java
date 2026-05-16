package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Rol;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;
    
    // Multiplicidad 1..m implementada estrictamente mediante Set
    private Set<Pedido> pedidos = new HashSet<>();

    public Usuario() {
        super();
    }

    public Usuario(Long id, String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) {
        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    // Lógica de sincronización bidireccional limpia para la colección
    public void agregarPedido(Pedido pedido) {
        if (pedido != null) {
            this.pedidos.add(pedido);
        }
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
    public Set<Pedido> getPedidos() { return pedidos; }
    public void setPedidos(Set<Pedido> pedidos) { this.pedidos = pedidos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario[ID=" + id + ", Nombre='" + nombre + " " + apellido + "', Email='" + mail + "', Rol=" + rol + ", CantidadPedidos=" + pedidos.size() + "]";
    }
}