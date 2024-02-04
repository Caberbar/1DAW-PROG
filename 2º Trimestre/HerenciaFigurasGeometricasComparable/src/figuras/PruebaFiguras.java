package figuras;

import java.util.ArrayList;
import java.util.Collections;

public class PruebaFiguras {

    public static void main(String[] args) {

        ArrayList<Figura> listaFiguras = new ArrayList<>();
//        
//        Figura f1 = new Triangulo(10, 10);
//        Figura f2 = new Circulo (0,0,5);
//        Figura f3 = new Triangulo(10,10);
//        
//        System.out.println(f1.equals(f3));
        
        listaFiguras.add(new Triangulo(10, 10));
        listaFiguras.add(new Circulo(0, 0, 5));
        listaFiguras.add(new Circulo(-1, 0, 3.5));
        listaFiguras.add(new Triangulo(3.5, 4.4));

        //Collections.sort(listaFiguras);
        Collections.sort(listaFiguras, new OrdenarFigurasMayorArea());
        
        for (Figura f : listaFiguras) {
            System.out.println("Área de la figura: " + f.area() + " " + f.getClass().getSimpleName());
            if (f instanceof Triangulo) {
                Triangulo t1 = (Triangulo) f;
                System.out.println("\tBase: "+ t1.getBase()+ "\n\tAltura: "+t1.getAltura());
            } else if(f instanceof Circulo){
                Circulo c1 = (Circulo) f;
                System.out.println("\tEl radio es: "+ c1.getRadio());
            }
        }

    }

}
