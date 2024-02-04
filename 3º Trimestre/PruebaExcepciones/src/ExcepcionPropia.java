
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author DAW-B
 */
public class ExcepcionPropia {

    public static void main(String[] args) {

        try {
            prueba(4,4);
            prueba(3,0);
        } catch (MiExcepcion ex) {
            System.err.println("Ha ocurrido un error, el programa abortará");
            return;
        }catch(OtraExcepcion ex2){
            System.err.println("Una excepción no marcada capturada");
        }finally{
            System.out.println("Esto se ejecuta siempre.");
        }
        System.out.println("El programa finaliza correctamente.");
        
    }
    
    public static void prueba(int a, int b) throws MiExcepcion{
        
        if (b==0) {
            throw new MiExcepcion();
        }
        if (a==0){
            throw new OtraExcepcion();
        }
    }
    
}
