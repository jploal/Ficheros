import java.io.*;

public class SumaArchivo {

    public static int obtenerSumaNumerosArchivo(String archivo) {

        int suma = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                int numero = Integer.parseInt(linea);
                suma += numero;
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return suma;
    }

    public static void main(String[] args) {

        int resultado = obtenerSumaNumerosArchivo("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\numNaturales.txt");
        System.out.println("La suma es: " + resultado);

    }
}