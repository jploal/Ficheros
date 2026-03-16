import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\prueba.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("Introduce texto. Para acabar introduce la cadena-> FIN:");
            String cadena;
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                bufferedWriter.write(cadena);
                bufferedWriter.newLine();
                cadena = sc.nextLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
    }

}