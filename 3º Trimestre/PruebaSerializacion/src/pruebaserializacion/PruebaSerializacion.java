/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaserializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW-B
 */
public class PruebaSerializacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ArrayList<Persona> personas = new ArrayList<>();
//        personas.add(new Persona("Pedro", "C/ hola", "EA"));
//        personas.add(new Persona("Juan", "C/ adios", "AE"));
//        personas.add(new Persona("Maria", "C/ perro", "66"));
        
        Persona[] personas = new Persona[3];
        personas[0] = new Persona("Pedro", "C/ hola", "EA");
        personas[1] = new Persona("Juan", "C/ adios", "AE");
        personas[2] = new Persona("Maria", "C/ perro", "66");
        
        Serializar(personas);
        Deserializar();
    }
    
    public static void Serializar(Persona[] personas) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        

        // Guardar valores de uno en uno -- DataOutputStream es una clase especializada para escribir datos primitivos en un archivo -- Esta forma no se puede deserializr ya que no se esta guardando el estado completo del array.
//        try {
//            FileOutputStream archivo = new FileOutputStream("numeros.dat");
//            DataOutputStream salida = new DataOutputStream(archivo);
//
//            for (int i = 0; i < numeros.length; i++) {
//                salida.writeInt(numeros[i]);
//            }
//
//            salida.close();
//            archivo.close();
//
//            System.out.println("Se han guardado los valores uno por uno.");
//
//        } catch (IOException e) {
//            System.out.println("Error al escribir en el archivo.");
//        }
        // Guardar array completo -- ObjectOutputStream es una clase para escribir objetos serializados.
        try {
            FileOutputStream archivo = new FileOutputStream("numeros.dat");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            
            salida.writeObject(personas);
            
            salida.close();
            archivo.close();
            
            System.out.println("Se ha guardado el array completo con la segunda forma.");
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
    
    public static void Deserializar() {

        // Deserializar el archivo
        try {
            FileInputStream archivo = new FileInputStream("numeros.dat");
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            
            //int[][] matriz = (int[][]) entrada.readObject();
            //ArrayList<Persona> personas = (ArrayList<Persona>) entrada.readObject();
            Persona[] personas = (Persona[]) entrada.readObject();
            //int[] numeros = (int[]) entrada.readObject();

            entrada.close();
            archivo.close();
            
            System.out.println("Se ha deserializado el array desde el archivo:");
            for (int i = 0; i < personas.length; i++) {
                System.out.println(personas[i]);
            }
//            for (int i = 0; i < numeros.length; i++) {
//                System.out.print(numeros[i] + " ");
//            }
//            System.out.println("");
//            for (int i = 0; i < matriz.length; i++) {
//                for (int j = 0; j < matriz[i].length; j++) {
//                    System.out.print(matriz[i][j] + " ");
//                }
//                System.out.println();
//            }
//            for (int i = 0; i < personas.size(); i++) {
//                System.out.println(personas.get(i));
//            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al deserializar el objeto.");
        }
    }
    
    public static File CrearFichero(String n) {
        //File f = new File("datos");
        //f.mkdir();
        File fichero = new File(n);
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.err.println("Ha ocurrido una excepción");
        }
        
        return fichero;
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
    
}
