package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;
import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== SIMULACIÓN CON REGLAS UML Y SETS ======\n");

        // 1. INSTANCIAR CATEGORÍAS (3.c)
        Categoria catPizzas = new Categoria(1L, "Pizzas", "Pizzas artesanales con masa fresca");
        Categoria catHamburguesas = new Categoria(2L, "Hamburguesas", "Hamburguesas gourmet con ingredientes frescos");
        Categoria catBebidas = new Categoria(3L, "Bebidas", "Gaseosas, jugos y bebidas frías");
        Categoria catPostres = new Categoria(4L, "Postres", "Tortas, helados y dulces artesanales");
        Categoria catEmpanadas = new Categoria(5L, "Empanadas", "Empanadas horneadas y fritas de distintos sabores");
        Categoria catEnsaladas = new Categoria(6L, "Ensaladas", "Ensaladas frescas y saludables");

        // 2. INSTANCIAR 20 PRODUCTOS
        Producto p1 = new Producto(1L, "Pizza Muzzarella", 4500.0, "Pizza clásica con salsa de tomate y muzzarella derretida", 20, "pizza.jpg", true);
        Producto p2 = new Producto(2L, "Pizza Napolitana", 5200.0, "Pizza con rodajas de tomate fresco, ajo y albahaca", 15, "pizza.jpg", true);
        Producto p3 = new Producto(3L, "Pizza Especial 4 Quesos", 6800.0, "Muzzarella, provolone, roquefort y parmesano", 10, "pizza.jpg", true);
        Producto p4 = new Producto(4L, "Hamburguesa Clásica", 3800.0, "Medallón de carne, lechuga, tomate, cebolla y mayo", 30, "pizza.jpg", true);
        Producto p5 = new Producto(5L, "Hamburguesa BBQ Bacon", 5100.0, "Doble medallón, bacon crocante y salsa barbacoa ahumada", 25, "pizza.jpg", true);
        Producto p6 = new Producto(6L, "Hamburguesa Veggie", 4200.0, "Medallón de lentejas y garbanzo, cheddar vegano y rúcula", 0, "pizza.jpg", false);
        Producto p7 = new Producto(7L, "Coca-Cola 500ml", 1200.0, "Gaseosa Coca-Cola fría, botella personal", 100, "pizza.jpg", true);
        Producto p8 = new Producto(8L, "Jugo de Naranja Natural", 1800.0, "Jugo exprimido en el momento, vaso 400ml", 40, "pizza.jpg", true);
        Producto p9 = new Producto(9L, "Agua Mineral 500ml", 800.0, "Agua mineral sin gas, botella personal", 150, "pizza.jpg", true);
        Producto p10 = new Producto(10L, "Torta Rogel", 3500.0, "Torta rogel tradicional con dulce de leche y merengue", 12, "pizza.jpg", true);
        Producto p11 = new Producto(11L, "Helado Artesanal 2 gustos", 2800.0, "Pote de 250g, elegí 2 gustos entre 12 opciones", 30, "pizza.jpg", true);
        Producto p12 = new Producto(12L, "Brownie con Helado", 2200.0, "Brownie de chocolate tibio con bocha de vainilla", 0, "pizza.jpg", false);
        Producto p13 = new Producto(13L, "Empanadas de Carne x6", 3000.0, "Empanadas criollas de carne cortada a cuchillo, horneadas", 50, "pizza.jpg", true);
        Producto p14 = new Producto(14L, "Empanadas de Pollo x6", 2800.0, "Empanadas de pollo con morrón y verdeo, horneadas", 45, "pizza.jpg", true);
        Producto p15 = new Producto(15L, "Empanadas de Jamón y Queso x6", 2500.0, "Empanadas fritas con jamón cocido y queso fundido", 60, "pizza.jpg", true);
        Producto p16 = new Producto(16L, "Ensalada César", 3200.0, "Lechuga romana, crutones, parmesano y aderezo césar", 20, "pizza.jpg", true);
        Producto p17 = new Producto(17L, "Ensalada Caprese", 2900.0, "Tomate, muzzarella fresca, albahaca y aceite de oliva", 18, "pizza.jpg", true);
        Producto p18 = new Producto(18L, "Pizza Fugazzeta", 5500.0, "Pizza rellena de muzzarella con cebolla caramelizada", 10, "pizza.jpg", true);
        Producto p19 = new Producto(19L, "Hamburguesa Crispy Chicken", 4600.0, "Pollo apanado crocante, coleslaw y salsa honey mustard", 0, "pizza.jpg", false);
        Producto p20 = new Producto(20L, "Ensalada Mixta", 2400.0, "Lechuga, tomate, zanahoria rallada y aceitunas", 25, "pizza.jpg", true);

        // Agregación (◊→): Vinculamos los productos a sus categorías correspondientes
        catPizzas.agregarProducto(p1);
        catPizzas.agregarProducto(p2);
        catPizzas.agregarProducto(p3);
        catHamburguesas.agregarProducto(p4);
        catHamburguesas.agregarProducto(p5);
        catBebidas.agregarProducto(p7);
        catBebidas.agregarProducto(p8);
        catBebidas.agregarProducto(p9);
        catPostres.agregarProducto(p10);
        catPostres.agregarProducto(p11);
        catEmpanadas.agregarProducto(p13);
        catEmpanadas.agregarProducto(p14);
        catEmpanadas.agregarProducto(p15);
        catEnsaladas.agregarProducto(p16);
        catEnsaladas.agregarProducto(p17);
        catPizzas.agregarProducto(p18);
        catEnsaladas.agregarProducto(p20);

        // 3. INSTANCIAR 2 USUARIOS (Requisito 3.a)
        Usuario user1 = new Usuario(1L, "Aldo", "Manfredi", "aldo@mail.com", "11223344", "pass123", Rol.USUARIO);
        Usuario user2 = new Usuario(2L, "María", "Gómez", "maria@mail.com", "55667788", "admin456", Rol.ADMIN);

        // 4. INSTANCIAR 3 PEDIDOS Y SUS DETALLES INTERNOS (Requisito 3.b - Composición Estricta ♦→)
        Pedido ped1 = new Pedido(501L, LocalDate.now(), Estado.PENDIENTE, FormaPago.TARJETA);
        ped1.addDetallePedido(1, p1); 
        ped1.addDetallePedido(2, p3);

        @SuppressWarnings("unused")
        Pedido ped2 = new Pedido(502L, LocalDate.now(), Estado.CONFIRMADO, FormaPago.TRANSFERENCIA);
        ped1.addDetallePedido(1, p2);
        ped1.addDetallePedido(3, p7);

        Pedido ped3 = new Pedido(503L, LocalDate.now(), Estado.TERMINADO, FormaPago.EFECTIVO);
        ped3.addDetallePedido(1, p4);
        ped3.addDetallePedido(1, p10);

        // Sincronización Bidireccional de Asociaciones
        user1.agregarPedido(ped1);
        user1.agregarPedido(ped1);
        user2.agregarPedido(ped3);

        // ================= PRESENTACIÓN DE RESULTADOS POR CONSOLA =================
        System.out.println("[A] VERIFICACIÓN DE UN PRODUCTO INDIVIDUAL (toString):");
        System.out.println("   " + p1 + "\n");

        System.out.println("[B] LISTADO COMPLETO DE PRODUCTOS POR CATEGORÍA:");
        Set<Categoria> conjuntoCategorias = Set.of(catPizzas, catHamburguesas, catBebidas, catPostres, catEmpanadas, catEnsaladas);
        for (Categoria cat : conjuntoCategorias) {
            System.out.println("   *** " + cat);
            for (Producto prod : cat.getProductos()) {
                System.out.println("      -> " + prod);
            }
        }
        System.out.println();

        System.out.println("[C] HISTORIAL COMPLETO DEL USUARIO MAS ACTIVO:");
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

        System.out.println("[D] PRUEBA DE IDENTIDAD DE OBJETOS Y UNICIDAD EN SETS:");
        // Creamos una pizza clon con el mismo ID que p1 (1L) para probar el Set
        Producto clonP1 = new Producto(1L, "Pizza Muzzarella clonada", 4500.0);
        System.out.println("   ¿p1.equals(clonP1) basado en ID?: " + p1.equals(clonP1));
        
        int tamañoAntes = catPizzas.getProductos().size();
        catPizzas.agregarProducto(clonP1); // Intento de inyección de duplicado gastronómico
        int tamañoDespues = catPizzas.getProductos().size();
        
        System.out.println("   Elementos en Set iniciales (Pizzas): " + tamañoAntes + " | Elementos tras intentar duplicar: " + tamañoDespues);
        System.out.println("   El Set bloqueó el clon utilizando el contrato equals/hashCode.");
    }
}