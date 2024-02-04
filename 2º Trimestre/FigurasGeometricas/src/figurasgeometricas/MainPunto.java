package figurasgeometricas;

import prueba.PuntoColo;

public class MainPunto {

    public static void main(String[] args) {
//        Punto p1 = new Punto();
//        Punto p2 = new Punto(6,7);
//        Punto p3 = new Punto(p2);
//        Punto p4 = new Punto(1,2);
//        System.out.println(p1);
//        System.out.println(p1.getX());
//        System.out.println(p1.getY());
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        p2.setY(6);
//        System.out.println(p2);
//        p2.equals(p4);
        PuntoColor p1 = new PuntoColor(6, 7, "Rojo");
        p1.setX(5);
        System.out.println(p1);

        PuntoColor p2 = new PuntoColor(4, "Verde");
        System.out.println(p2);
        
        PuntoColor p3 = new PuntoColor();
        System.out.println(p3);

        PuntoColo p4 = new PuntoColo(7, 1, "Azul");
        System.out.println(p4);

        PuntoColo p5 = new PuntoColo(9, "Naranja");
        System.out.println(p5);
    }

}
