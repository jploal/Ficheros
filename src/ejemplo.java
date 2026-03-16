//"C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\prueba.txt"

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejemplo {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\prueba.txt");
        String cadena;
        Scanner entrada;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                cadena = entrada.nextLine();
                System.out.println(cadena);
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}