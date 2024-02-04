package ejercicio11;

public class ElCorteIslandes1Corregido {

    public static void main(String[] args) {
        TarjetaRegalo1Corregido t1 = new TarjetaRegalo1Corregido(100);
        TarjetaRegalo1Corregido t2 = new TarjetaRegalo1Corregido(120);
        System.out.println(t1);
        System.out.println(t2);
        t1.gasta(45.90);
        t2.gasta(5);
        t2.gasta(200);
        t1.gasta(3.55);
        System.out.println(t1);
        System.out.println(t2);
       TarjetaRegalo1Corregido t3 = t1.fusionaCon(t2);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

    }
    
}
