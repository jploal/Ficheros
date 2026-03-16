import java.io.*;
import java.util.*;

public class Alfabetico {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\texto.txt"));
            ArrayList<String> palabras = new ArrayList<>();

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                for (String p : partes) {
                    palabras.add(p);
                }
            }

            br.close();

            Collections.sort(palabras);

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\alfabetico.txt"));

            for (String p : palabras) {
                bw.write(p);
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}