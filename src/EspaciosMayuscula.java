import java.io.*;

public class EspaciosMayuscula {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\texto.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                linea = linea.replace(" ", "");
                linea = linea.toUpperCase();
                System.out.println(linea);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}