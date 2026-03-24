package Supermercado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Supermercado {

    private Map<String, Producto> catalogo;
    private Set<Producto> ticket;

    public Supermercado() {
        catalogo = new HashMap<>();
        ticket = new LinkedHashSet<>();
        try {
            BufferedReader br=new BufferedReader(new FileReader("src/supermercado/Catalogo.txt"));
            String linea = null;
            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(";");
                if (partes.length < 3) continue;

                try {
                    String nombre = partes[1].trim();
                    Double precio = Double.valueOf(partes[2]);
                    catalogo.put(nombre, new Producto(nombre, precio));
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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