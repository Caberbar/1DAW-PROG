package ejercicio6tiempo;

public class Ejercicio6Tiempo1Corregido {

    public static void main(String[] args) {
        TiempoCorregido t1 = new TiempoCorregido(0, 30, 50);
        t1.suma(0, 35, 40);
        TiempoCorregido t2 = new TiempoCorregido(0, 35, 20);
        t2.resta(0,30,0);

        
        
        System.out.println("Tiempo: "+t1);
        System.out.println("Tiempo: "+t2);
    }
    
}
