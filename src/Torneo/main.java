package Torneo;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void menu() {
        System.out.println("""
                =================================
                TORNEO
                =================================
                1 - Lista total de Jugadores
                2 - Jugadores alojados Meliá
                3 - Jugadores de la C.Valenciana
                4 - Salir del programa
                ---------------------------------
                """);
    }
    public static void main(String[] args) {
        ListaJugadores lista = new ListaJugadores();
        lista.cargarDesdeArchivo("src/Torneo/jugadores.txt");
        boolean salir=false;
        Scanner sc = new Scanner(System.in);
        while (!salir) {
            menu();
            System.out.println("Elige una opción:");
            try {
                int eleccion = sc.nextInt();
                sc.nextLine();

                if (eleccion < 1 || eleccion > 4) {
                    System.out.println("Opción no válida");
                    continue;
                }

                switch (eleccion) {
                    case 1 ->lista.mostrarJugadores();
                    case 2 ->lista.jugadoresAlojados();
                    case 3 -> lista.jugadoresValencianos();
                    case 4 ->salir = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce los números que haya en el menú");
                sc.nextLine();
            }
        }
        System.out.println("Saliendo...");
    }
}
/*FORMA FACIL DE CREAR LOS ARCHIVOS
public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Torneo/jugadores.txt"));
            String linea ,ranking, nombre;
            int index;
            FileWriter fw1 = new FileWriter("src/Torneo/alojados.txt");
            fw1.write("-------------ALOJADOS MELIÁ----------------");
            fw1.write("\n RANKING" +"\t--\t" +"NOMBRE\n");

            FileWriter fw2 = new FileWriter("src/Torneo/jugadoresCV.txt");
            fw2.write("-------------JUGADORES C.VALENCIANA----------------");
            fw2.write("\n RANKING" +"\t--\t" +"NOMBRE\n");

            while ((linea= br.readLine()) !=null){
                    index = linea.indexOf(";");
                    if (linea.endsWith("H") ||linea.endsWith("PH")||linea.endsWith("PHCV")){
                        ranking=linea.split(";")[0];
                        nombre=linea.split(";")[2];
                        fw1.write(ranking + "\t--\t\t" + nombre +"\n");
                    }
                    if (linea.endsWith("CV")){
                        ranking=linea.split(";")[0];
                        nombre=linea.split(";")[2];
                        fw2.write(ranking + "\t--\t\t" + nombre +"\n");
                    }
            }
            fw1.close();
            fw2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } */