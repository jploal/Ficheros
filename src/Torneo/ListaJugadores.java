package Torneo;

import java.io.*;
import java.util.*;

public class ListaJugadores {

    private Map<Integer, Jugador> jugadores; // clave = rank

    public ListaJugadores() {
        jugadores = new HashMap<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.put(jugador.getRank(), jugador);
    }

    public void mostrarJugadores() {
        String formato= "%-10s %-35s %-15s %-15s%n";
        String encabezado= String.format(formato,"RANK","NOMBRE","INFO","FIDE");
        String separador ="-".repeat(75);
        System.out.println(separador);
        System.out.println("            Lista de jugadores          ");
        System.out.println(separador);
        System.out.println(encabezado);
        for (Integer clave : jugadores.keySet()) {
            Jugador j = jugadores.get(clave);
            /*printf es imprime con formato prinntf((formato))..... el "%n% marca el salto de linea al final*/
            System.out.printf((formato),j.getRank(),j.getNombre(),j.getInfo(),j.getEloFide());
        }
        System.out.println(separador);
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
                if (partes.length < 8) continue;

                try {
                    int rank = Integer.parseInt(partes[0].trim());
                    String nombre = partes[2].trim();
                    String info = partes[7].trim();
                    int eloFide = Integer.parseInt(partes[4].trim());

                    Jugador j = new Jugador(rank, nombre, info, eloFide);
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
    public void cargarPosicion(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int lineasSaltadas = 0;

            while ((linea = br.readLine()) != null) {
                // saltar las dos primeras líneas de encabezado
                if (lineasSaltadas < 5) {
                    lineasSaltadas++;
                    continue;
                }

                String[] partes = linea.split(";");
                if (partes.length < 10) continue;

                try {
                    int posicion = Integer.parseInt(partes[0].trim());
                    int rank = Integer.parseInt(partes[1].trim());
                    double puntos = Double.parseDouble(partes[3].trim().replace(",", "."));

                    Jugador jugador = jugadores.get(rank);
                    if (jugador == null) continue;

                    jugador.setPosicion(posicion);
                    jugador.setPuntos(puntos);
                } catch (NumberFormatException e) {
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
            /*FORMATO PARA REPRESENTACION VISUAL*/
            String formato= "%-10s %-40s%n";
            String encabezado=String.format(formato,"RANKING","NOMBRE");
            String separador= "-".repeat(50);

            pw.println(separador);
            pw.println("            ALOJADOS MELIÁ"         );
            pw.println(separador);
            pw.println(encabezado);
            pw.println(separador);

            System.out.println(separador);
            System.out.println("            ALOJADOS MELIÁ          ");
            System.out.println(separador);
            System.out.println(encabezado);
            System.out.println(separador);

            for (Jugador j : jugadores.values()) {
                if (j.isAlojado()) {
                    String linea =String.format(formato,j.getRank(),j.getNombre());
                    pw.println(linea);
                    System.out.println(linea);
                }
            }
            System.out.println(separador);
            pw.println(separador);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void jugadoresValencianos() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Torneo/jugadoresCV.txt"));
            PrintWriter pw = new PrintWriter(bw);
            /*FORMATO PARA REPRESENTACION VISUAL*/
            String formato= "%-10s %-40s%n";
            String encabezado=String.format(formato,"RANKING","NOMBRE");
            String separador= "-".repeat(50);

            pw.println(separador);
            pw.println("            JUGADORES C.VALENCIANA          ");
            pw.println(separador);
            pw.println(encabezado);
            pw.println(separador);

            System.out.println(separador);
            System.out.println("            JUGADORES C.VALENCIANA          ");
            System.out.println(separador);
            System.out.println(String.format(formato,"RANKING","NOMBRE"));
            System.out.println(separador);

            for (Jugador j : jugadores.values()) {
                if (j.isCv()) {
                    String linea =String.format(formato,j.getRank(),j.getNombre()) ;
                    pw.println(linea);
                    System.out.println(linea);
                }
            }
            System.out.println(separador);
            pw.println(separador);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clasificacion() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Torneo/clasificacion.txt"));
            PrintWriter pw = new PrintWriter(bw);
            /*FORMATO PARA REPRESENTACION VISUAL*/
            String formato= "%-10s %-35s %-10s %-10s%n";
            String encabezado=String.format(formato,"POSICION","NOMBRE","ELOFIDE","PUNTOS");
            String separador= "-".repeat(70);

            pw.println(separador);
            pw.println("            Clasificacion           ");
            pw.println(separador);
            pw.println(encabezado);
            pw.println(separador);


            System.out.println(separador);
            System.out.println("            Clasificacion           ");
            System.out.println(separador);
            System.out.println(encabezado);
            System.out.println(separador);
            List<Jugador> listaOrdenada = new ArrayList<>(jugadores.values());
            listaOrdenada.sort(Comparator.comparingInt(Jugador::getPosicion));


            for (Jugador j : listaOrdenada) {
                String linea = String.format(formato,
                        j.getPosicion(),
                        j.getNombre(),
                        j.getEloFide(),
                        j.getPuntos()
                );
                   pw.println(linea);
                    System.out.println(linea);
            }
            System.out.println(separador);
            pw.println(separador);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
