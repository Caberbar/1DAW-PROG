package pruebaficheros;

import java.io.*;
import java.util.Scanner;

public class PruebaFicheros {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File fichero = CrearFichero();
        System.out.println("Eliga una opción:\n\t1. LeerFichero.\n\t2. Escriir en el fichero.");
        System.out.print("Opción: ");
        int opcion = teclado.nextInt();
        if (opcion == 1) {
            LeerFichero(fichero);
        } else if (opcion == 2) {
            SobrescribirFichero(fichero);
        }
    }

    public static File CrearFichero() {
        //File f = new File("datos");
        //f.mkdir();
        File fichero = new File("info.txt");
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.err.println("Ha ocurrido una excepción");
        }

        return fichero;
    }

    public static void LeerFichero(File f) {
        if (f.exists()) {
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(f));
                String cad;
                try {
                    while ((cad = bf.readLine()) != null) {
                        System.out.println(cad);
                    }
                } catch (IOException ex) {
                    System.err.println("Ha ocurrido una excepción");
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Ha ocurrido una excepción");
            } finally {
                try {
                    bf.close();
                } catch (IOException ex) {
                    System.err.println("Ha ocurrido una excepción");
                }
            }
        } else {
            System.out.println("El fichero no existe (cuidao con la extensión)");
        }
    }

    public static void SobrescribirFichero(File f) {
        if (f.exists()) {
            String[] nombre = {"Carlos", "joaquín", "pepe", "ines"};
            PrintWriter salida = null;
            try {
                BufferedWriter bf = new BufferedWriter(new FileWriter("info.txt", true));
                salida = new PrintWriter(bf);

            } catch (IOException ex) {
                System.err.println("Ha ocurrido una excepción");
            }

            for (String s : nombre) {
                salida.println(s);
            }
            salida.flush();
            salida.close();
        } else {
            System.out.println("El fichero no existe (cuidao con la extensión)");
        }

    }

}
