
package primerprograma;

/**
 * Mi primer programa en Java
 * @author Carlos Bernal Barrionuevo
 */
public class PrimerPrograma {

    
    public static void main(String[] args) {
        
        int edad, a=5, c=0;
        double b;
        String nombre = "Carlos";
        final double NUMERO_PI = 3.141592;
        
        boolean esCierto=true;
        char corazon = '\u2665';
        char letra = '\101';
        float area = 2.18f;
        float otro = area + 2.20f;
        
        edad=33;    
        b=edad + c++;       
        System.out.println("Edad vale: " +b+ " y c vale: "+c);
        
        b = 33;
        c = 14;
        double division = (double)b / c;
        
        System.out.println("La division es: "+division);
        
        System.out.println("Hola, este es \n\"mi primer programa\"");
        System.out.println("Tu nombre es "+nombre+" y tu edad es "+edad);
        System.out.println("Un Corazon" +corazon);
        System.out.println("La letra 65: "+letra);

        
       
        byte valor1=127;
        short valor2=233;
        
        valor1 = (byte)valor2;
        
        System.out.println("El valor 1 es: "+valor1);
        
        
        String s = "33";
        int ConversionCadena = Integer.parseInt(s);
        System.out.println("El numero es: "+ConversionCadena);
                
    }
    
}
