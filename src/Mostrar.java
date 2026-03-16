import java.io.*;

public class Mostrar {

    public static void mostrarArchivoPantalla(String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public static void main(String[] args) {
        mostrarArchivoPantalla("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\texto.txt");
    }
}