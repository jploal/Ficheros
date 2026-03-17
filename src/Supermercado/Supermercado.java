package Supermercado;

import java.util.*;

public class Supermercado {

    private Map<String, Producto> catalogo;
    private Set<Producto> ticket;

    public Supermercado() {
        catalogo = new HashMap<>();
        ticket = new LinkedHashSet<>();

        catalogo.put("avena", new Producto("avena", 2.21));
        catalogo.put("garbanzos", new Producto("garbanzos", 2.39));
        catalogo.put("tomate", new Producto("tomate", 1.59));
        catalogo.put("jengibre", new Producto("jengibre", 3.13));
        catalogo.put("quinoa", new Producto("quinoa", 4.50));
        catalogo.put("guisantes", new Producto("guisantes", 1.60));
    }

    public Map<String, Producto> getCatalogo() {
        return catalogo;
    }

    public Set<Producto> getTicket() {
        return ticket;
    }

    public void mostrarCatalogo() {
        for (Producto p : catalogo.values()) {
            System.out.println(p.getNombre() + " -> " + p.getPrecio() + "€");
        }
    }

    public void agregarProducto(String nombre, int cantidad) {
        Producto p = catalogo.get(nombre);

        if (p == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        boolean encontrado = false;

        for (Producto prod : ticket) {
            if (prod.getNombre().equalsIgnoreCase(nombre)) {
                prod.setCantidad(prod.getCantidad() + cantidad);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            Producto compra = new Producto(p.getNombre(), p.getPrecio(), cantidad);
            ticket.add(compra);
        }
    }
}