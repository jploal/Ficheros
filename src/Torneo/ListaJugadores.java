package Torneo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListaJugadores {

    private Map<Integer, Jugador> jugadores; // clave = rank

    public ListaJugadores() {
        jugadores = new HashMap<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.put(jugador.getRank(), jugador);
    }

    public void mostrarJugadores() {
        for (Integer clave : jugadores.keySet()) {
            Jugador j = jugadores.get(clave);
            System.out.println("Rank: " + j.getRank() + ", Nombre: " + j.getNombre() + ", Info: " + j.getInfo());
        }
    }

    public void cargarDesdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int lineasSaltadas = 0;

            while ((linea = br.readLine()) != null) {
                // saltar las dos primeras líneas de encabezado
                if (lineasSaltadas < 2) {
                    lineasSaltadas++;
                    continue;
                }

                String[] partes = linea.split(";");
                if (partes.length < 8) continue; // línea incompleta

                try {
                    int rank = Integer.parseInt(partes[0].trim());
                    String nombre = partes[2].trim();
                    String info = partes[7].trim();

                    Jugador j = new Jugador(rank, nombre, info);
                    agregarJugador(j);
                } catch (NumberFormatException e) {
                    // si rank no es un número, saltar
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void jugadoresAlojados() {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                    new FileWriter("src/Torneo/alojados.txt")));

            pw.println("-------------ALOJADOS MELIÁ----------------");
            pw.println("RANKING\t--\tNOMBRE\n");

            System.out.println("-------------ALOJADOS MELIÁ----------------");
            System.out.println("RANKING\t--\tNOMBRE\n");

            for (Jugador j : jugadores.values()) {
                if (j.isAlojado()) {
                    String linea = j.getRank() + "\t--\t" + j.getNombre();
                    pw.println(linea);
                    System.out.println(linea);
                }
            }

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void jugadoresValencianos() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Torneo/jugadoresCV.txt"));
            PrintWriter pw = new PrintWriter(bw);

            pw.println("-------------JUGADORES C.VALENCIANA----------------");
            pw.println("RANKING\t--\tNOMBRE\n");

            System.out.println("-------------JUGADORES C.VALENCIANA----------------");
            System.out.println("RANKING\t--\tNOMBRE\n");

            for (Jugador j : jugadores.values()) {
                if (j.isCv()) {
                    String linea = j.getRank() + "\t--\t" + j.getNombre();
                    pw.println(linea);
                    System.out.println(linea);
                }
            }

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
