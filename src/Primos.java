import java.io.*;

public class Primos {
    public static boolean esPrimo(int num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        try {
            FileWriter fW = new FileWriter("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\primos.dat");
            BufferedWriter bW = new BufferedWriter(fW);
            for (int i = 1; i <= 500; i++) {
                if (esPrimo(i)) {
                    bW.write(i + "\n");
                }
            }
            bW.close();
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\primos.dat"));
            String linea;
            System.out.println("Números primos del 1 al 500");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
