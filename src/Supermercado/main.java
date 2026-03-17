package Supermercado;

import java.io.*;
import java.util.*;

public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Supermercado sm = new Supermercado();

        sm.mostrarCatalogo();

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("src/Supermercado/ticket.txt");

            String nomProd = "";
            int cantidad;
            System.out.println("\nCARRITO DE LA COMPRA");
            while (!(nomProd.equalsIgnoreCase("FIN"))) {
                System.out.print("Producto (FIN para terminar): ");
                nomProd = sc.nextLine();

                if (!(nomProd.equalsIgnoreCase("FIN"))) {
                    System.out.print("Cantidad: ");
                    cantidad = sc.nextInt();
                    sc.nextLine();

                    sm.agregarProducto(nomProd, cantidad);
                }
            }

            double total = 0;

            System.out.println("Introduzca código descuento (INTRO si se desconoce):");
            String Descuento = sc.nextLine();

            fileWriter.write("Producto Precio Cantidad Subtotal\n");
            fileWriter.write("---------------------------------------------\n");

            for (Producto p : sm.getTicket()) {
                double subtotal = p.getPrecio() * p.getCantidad();
                total += subtotal;

                fileWriter.write(
                        p.getNombre() + "\t\t"
                                + String.format("%.2f", p.getPrecio()) + "\t"
                                + p.getCantidad() + "\t"
                                + String.format("%.2f", subtotal) + "€\n"
                );
            }

            if (Descuento.equalsIgnoreCase("PROMOECO")) {
                double descuento = (total / 10);
                total -= descuento;

                fileWriter.write("---------------------------------------------\n");
                fileWriter.write("DESCUENTO: " + String.format("%.2f", descuento) + "€\n");
            }

            fileWriter.write("----------------------------------------------\n");
            fileWriter.write("TOTAL: " + String.format("%.2f", total) + "€");

            fileWriter.close();

            BufferedReader br = new BufferedReader(new FileReader("src/Supermercado/ticket.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}