import java.io.*;

public class NumNaturales {
    public static void main(String[] args) {
        try {
        FileWriter fW = new FileWriter("C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\numNaturales.txt");
        BufferedWriter bW = new BufferedWriter(fW);
       for (int i =0;i<=100;i++){
           bW.write(i+"\n");
            }
            bW.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }

