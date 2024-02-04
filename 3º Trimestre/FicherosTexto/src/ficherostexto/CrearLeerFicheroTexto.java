package ficherostexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearLeerFicheroTexto {

    public static void main(String[] args) {

        //Creamos el directorio datos y guardamos ahí el fichero info.txt
        File directorio = new File("datos");
        directorio.mkdir();
        File fichero = new File(directorio, "info.txt");
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(CrearLeerFicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Leemos el contenido del fichero info.txt (previamente hemos escrito algo con un editor de textos
        if (fichero.exists()) {
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(fichero));
                String linea;
                while ((linea = bf.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CrearLeerFicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CrearLeerFicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (bf != null) {
                    try {
                        bf.close();
                    } catch (IOException ex) {
                        Logger.getLogger(CrearLeerFicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            System.err.println("Este fichero no existe. No se puede leer.");
        }
    }

}
