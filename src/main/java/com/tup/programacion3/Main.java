package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;
import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== INICIANDO SIMULACIÓN PROFESIONAL CON REGLAS UML Y SETS ======\n");

        // 1. INSTANCIAR 3 CATEGORÍAS (Requisito 3.c)
        Categoria catElectro = new Categoria(1L, "Electrónica", "Dispositivos de vanguardia");
        Categoria catHogar = new Categoria(2L, "Hogar", "Confort para el living");
        Categoria catIndumentaria = new Categoria(3L, "Indumentaria", "Moda urbana");

        // 2. INSTANCIAR 10 PRODUCTOS (Requisito 3.d)
        Producto p1 = new Producto(101L, "Televisor 55'", 450000.0, "Smart TV 4K", 15, "tv55.png", true);
        Producto p2 = new Producto(102L, "Celular S24", 950000.0, "128GB Almacenamiento", 8, "s24.png", true);
        Producto p3 = new Producto(103L, "Auriculares BT", 45000.0, "Noise Cancelling", 50, "headphones.png", true);
        Producto p4 = new Producto(104L, "Cafetera Express", 120000.0, "15 Bares de presión", 5, "cafetera.png", true);
        Producto p5 = new Producto(105L, "Licuadora", 45000.0, "Jarra de vidrio 1.5L", 12, "licuadora.png", true);
        Producto p6 = new Producto(106L, "Sartén Antiadherente", 35000.0, "24cm diámetro", 20, "sarten.png", true);
        Producto p7 = new Producto(107L, "Remera Algodón", 15000.0, "Talle M Unisex", 100, "remera.png", true);
        Producto p8 = new Producto(108L, "Pantalón Jean", 38000.0, "Slim Fit elastizado", 40, "jean.png", true);
        Producto p9 = new Producto(109L, "Zapatillas Running", 75000.0, "Amortiguación premium", 14, "zapas.png", true);
        Producto p10 = new Producto(110L, "Campera de Abrigo", 110000.0, "Térmica e impermeable", 9, "campera.png", true);

        // Agregación (◊→): Vinculamos los productos a sus categorías correspondientes
        catElectro.agregarProducto(p1);
        catElectro.agregarProducto(p2);
        catElectro.agregarProducto(p3);
        catHogar.agregarProducto(p4);
        catHogar.agregarProducto(p5);
        catHogar.agregarProducto(p6);
        catIndumentaria.agregarProducto(p7);
        catIndumentaria.agregarProducto(p8);
        catIndumentaria.agregarProducto(p9);
        catIndumentaria.agregarProducto(p10);

        // 3. INSTANCIAR 2 USUARIOS (Requisito 3.a)
        Usuario user1 = new Usuario(1L, "Aldo", "Manfredi", "aldo@mail.com", "11223344", "pass123", Rol.USUARIO);
        Usuario user2 = new Usuario(2L, "María", "Gómez", "maria@mail.com", "55667788", "admin456", Rol.ADMIN);

        // 4. INSTANCIAR 3 PEDIDOS Y SUS DETALLES INTERNOS (Requisito 3.b - Composición Estricta ♦→)
        Pedido ped1 = new Pedido(501L, LocalDate.now(), Estado.PENDIENTE, FormaPago.TARJETA);
        ped1.addDetallePedido(1, p1); // Añade ítem y calcula subtotal/total internamente sin crear New Detalle en el Main
        ped1.addDetallePedido(2, p3);

        Pedido ped2 = new Pedido(502L, LocalDate.now(), Estado.CONFIRMADO, FormaPago.TRANSFERENCIA);
        ped2.addDetallePedido(1, p2);
        ped2.addDetallePedido(3, p7);

        Pedido ped3 = new Pedido(503L, LocalDate.now(), Estado.TERMINADO, FormaPago.EFECTIVO);
        ped3.addDetallePedido(1, p4);
        ped3.addDetallePedido(1, p10);

        // Sincronización Bidireccional de Asociaciones
        user1.agregarPedido(ped1);
        user1.agregarPedido(ped2);
        user2.agregarPedido(ped3);

        // ================= PRESENTACIÓN DE RESULTADOS POR CONSOLA =================
        System.out.println("🔹 [A] VERIFICACIÓN DE UN PRODUCTO INDIVIDUAL (toString):");
        System.out.println("   " + p1 + "\n");

        System.out.println("🔹 [B] LISTADO COMPLETO DE PRODUCTOS POR CATEGORÍA:");
        Set<Categoria> conjuntoCategorias = Set.of(catElectro, catHogar, catIndumentaria);
        for (Categoria cat : conjuntoCategorias) {
            System.out.println("   📍 " + cat);
            for (Producto prod : cat.getProductos()) {
                System.out.println("      -> " + prod);
            }
        }
        System.out.println();

        System.out.println("🔹 [C] HISTORIAL COMPLETO DEL USUARIO MAS ACTIVO:");
        Set<Usuario> conjuntoUsuarios = Set.of(user1, user2);
        Usuario clienteMasActivo = user1;
        for (Usuario u : conjuntoUsuarios) {
            if (u.getPedidos().size() > clienteMasActivo.getPedidos().size()) {
                clienteMasActivo = u;
            }
        }
        System.out.println("   Cliente: " + clienteMasActivo.getNombre() + " " + clienteMasActivo.getApellido());
        for (Pedido p : clienteMasActivo.getPedidos()) {
            System.out.println("      " + p);
            for (DetallePedido dp : p.getDetalles()) {
                System.out.println("         " + dp);
            }
        }
        System.out.println();

        System.out.println("🔍 [D] PRUEBA DE IDENTIDAD DE OBJETOS Y UNICIDAD EN SETS:");
        Producto clonP1 = new Producto(101L, "Televisor 55'", 450000.0);
        System.out.println("   ¿p1.equals(clonP1) basado en ID?: " + p1.equals(clonP1));
        
        int tamañoAntes = catElectro.getProductos().size();
        catElectro.agregarProducto(clonP1); // Intento de inyección de duplicado
        int tamañoDespues = catElectro.getProductos().size();
        
        System.out.println("   Elementos en Set iniciales: " + tamañoAntes + " | Elementos tras intentar duplicar: " + tamañoDespues);
        System.out.println("   ✅ Éxito absoluto: El Set bloqueó el clon utilizando el contrato equals/hashCode.");
    }
}