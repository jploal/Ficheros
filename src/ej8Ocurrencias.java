import java.io.*;
import java.util.Scanner;

/*C:\\Users\\Usuario\\Desktop\\DAW\\Programacion\\prueba\\trabalenguas.txt
Texto:
Paco pica poca papa porque poca papa pica Paco.
Si Paco pica papa, ¿quién pica la poca papa que Paco no pica?
La casa de Paco tiene poca papa y poca sal, pero Paco pasa por la casa y pisa la papa.
En la casa pasa Paco, pasa la papa, pasa la sal y pasa la casa.
Paco pasa por la casa y dice: casa casa casa, papa papa papa.
paco,pasa,dice,sal,pica
*/
public class ej8Ocurrencias {
    public static void main(String[] args) {
        String opcion = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo: ");
        String archivo = sc.nextLine();
        do {
            System.out.print("Introduce la palabra a buscar: ");
            String palabra = sc.nextLine();
            int contador = 0;

            try {

                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;

                while ((linea = br.readLine()) != null) {

                    String[] palabras = linea.split(" ");

                    for (String p : palabras) {
                        //Deberia haber una manera de ignorar los simbolos, en este caso la palabra "pasa" no es igual que "pasa,"
                        // por eso tengo que agregar esta parte
                        //habra una manera de hacer que siempre que haya un simbolo se añada un espacio para que asi el string sea "papa "+","
                        if (p.equalsIgnoreCase(palabra) || p.equalsIgnoreCase(palabra+",") ||p.equalsIgnoreCase(palabra+".") || p.equalsIgnoreCase(palabra+"?")|| p.equalsIgnoreCase(palabra+"¿") ||p.equalsIgnoreCase(palabra+":") ) {
                            contador++;
                        }
                    }
                }
                System.out.println("La palabra aparece " + contador + " veces");

                System.out.print("¿Quieres buscar otra palabra? (s/n): ");
                opcion = sc.nextLine();
                br.close();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo");
            }
        } while (opcion.equalsIgnoreCase("s"));

        sc.close();
    }
}