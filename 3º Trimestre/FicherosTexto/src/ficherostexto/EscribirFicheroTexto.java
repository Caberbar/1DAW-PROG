package ficherostexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscribirFicheroTexto {

    public static void main(String[] args) {

        File file = new File("datos" + File.separator + "info.txt");

        System.out.println("Se escribirán los datos en el fichero " + file.getAbsolutePath());

        BufferedWriter buffer = null;
        PrintWriter salida = null;
        Scanner teclado = new Scanner(System.in);
        String linea;
        try {
            buffer = new BufferedWriter(new FileWriter(file, true));
            salida = new PrintWriter(buffer);

            System.out.println("Introduzca los datos que desea escribir en el fichero. Escriba [exit] para salir");
            while (teclado.hasNext() && !(linea = teclado.nextLine()).equalsIgnoreCase("[exit]")) {
                salida.println(linea);
            }

        } catch (IOException ex) {
            Logger.getLogger(EscribirFicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (salida != null) {
                salida.flush();
                salida.close();
                System.out.println("Fichero guardado correctamente");
            }
        }

    }

}
