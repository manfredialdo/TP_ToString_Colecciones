package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    
    // COMPOSICIÓN (♦→): El Pedido instancia e incorpora sus detalles internamente
    private Set<DetallePedido> detalles = new HashSet<>();

    public Pedido() {
        super();
        this.total = 0.0;
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
    }

    public Pedido(Long id, LocalDate fecha, Estado estado, FormaPago formaPago) {
        super(id);
        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;
        this.total = 0.0;
    }

    @Override
    public void calcularTotal() {
        double acumulado = 0.0;
        for (DetallePedido dp : detalles) {
            acumulado += dp.getSubtotal();
        }
        this.total = acumulado;
    }

    // Regla de Oro de la Composición: El objeto se fabrica acá adentro
    public void addDetallePedido(int cantidad, Producto producto) {
        if (producto != null && cantidad > 0) {
            DetallePedido nuevoDetalle = new DetallePedido(cantidad, producto);
            this.detalles.add(nuevoDetalle);
            calcularTotal();
        }
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido dp : detalles) {
            if (Objects.equals(dp.getProducto(), producto)) {
                return dp;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido objetivo = findDetallePedidoByProducto(producto);
        if (objetivo != null) {
            this.detalles.remove(objetivo);
            calcularTotal();
        }
    }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public Set<DetallePedido> getDetalles() { return detalles; }
    public FormaPago getFormaPago() { return formaPago; }
    public void setFormaPago(FormaPago formaPago) { this.formaPago = formaPago; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedido[ID=" + id + ", Fecha=" + fecha + ", Estado=" + estado + ", FormaPago=" + formaPago + ", Total=$" + total + ", CantidadItems=" + detalles.size() + "]";
    }
}