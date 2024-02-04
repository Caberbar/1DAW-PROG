package ejercicio6tiempo;

public class Ejercicio6Tiempo {

    public static void main(String[] args) {
        Tiempo t1 = new Tiempo(0, 30, 50);
        t1.suma(0, 35, 40);
        //Tiempo t2 = new Tiempo(0, 35, 20);
        //t2.resta();

        
        System.out.println("Horas:"+ t1.getHoras() + " minutos:" + t1.getMinutos() + " segundos:" + t1.getSegundos());
        //System.out.println("Horas:"+ t2.getHoras() + " minutos:" + t2.getMinutos() + " segundos:" + t2.getSegundos());
    }
    
}
