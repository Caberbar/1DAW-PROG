package conversorlistacanciones;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ConversorListaCanciones {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<ArrayList<String>> canciones = new ArrayList<ArrayList<String>>();
        System.out.println("Introduce el nombre del fichero: ");
        String nombre = teclado.nextLine();

        try {
            File archivo = new File(nombre);
            Scanner lector = new Scanner(archivo);

            if (nombre.endsWith(".txt")) {
                int numCanciones = Integer.parseInt(lector.nextLine());
                for (int i = 0; i < numCanciones; i++) {
                    ArrayList<String> cancion = new ArrayList<String>();
                    cancion.add(lector.nextLine());
                    cancion.add(lector.nextLine());
                    cancion.add(lector.nextLine());
                    canciones.add(cancion);
                }
            } // Si el fichero es moderno
            else if (nombre.endsWith(".dat")) {
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombre));
                canciones = (ArrayList<ArrayList<String>>) entrada.readObject();
                entrada.close();
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        
        
        // Muestra las canciones ordenadas por duracion
        Collections.sort(canciones, new Comparator<ArrayList<String>>() {
            public int compare(ArrayList<String> cancion1, ArrayList<String> cancion2) {
                return Integer.parseInt(cancion1.get(2)) - Integer.parseInt(cancion2.get(2));
            }
        });
        System.out.println("Canciones ordenadas por duracion:");
        for (ArrayList<String> cancion : canciones) {
            System.out.println(cancion.get(0) + " - " + cancion.get(1) + " - " + cancion.get(2));
        }

        // Muestra las canciones ordenadas por titulo
        Collections.sort(canciones, new Comparator<ArrayList<String>>() {
            public int compare(ArrayList<String> cancion1, ArrayList<String> cancion2) {
                return cancion1.get(0).compareTo(cancion2.get(0));
            }
        });
        System.out.println("Canciones ordenadas por titulo:");
        for (ArrayList<String> cancion : canciones) {
            System.out.println(cancion.get(0) + " - " + cancion.get(1) + " - " + cancion.get(2));
        }

        // Pide el nombre del fichero para guardar las canciones serializadas
        System.out.print("Introduce el nombre del fichero para guardar las canciones serializadas: ");
        String nombreFicheroNuevo = teclado.nextLine();

        // Guarda las canciones serializadas
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreFicheroNuevo));
            salida.writeObject(canciones);
            salida.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Canciones guardadas en el archivo " + nombreFicheroNuevo);
    }
}
