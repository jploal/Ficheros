import java.io.*;

public class Contar {
    public static void main(String[] args) {

        int vocales = 0;
        int consonantes = 0;
        int numeros = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\texto.txt"));
            int c;

            while ((c = br.read()) != -1) {
                char caracter = Character.toLowerCase((char) c);

                if ("aeiou".indexOf(caracter) != -1) {
                    vocales++;
                } else if (Character.isLetter(caracter)) {
                    consonantes++;
                } else if (Character.isDigit(caracter)) {
                    numeros++;
                }
            }

            br.close();

            System.out.println("Vocales: " + vocales);
            System.out.println("Consonantes: " + consonantes);
            System.out.println("Números: " + numeros);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}