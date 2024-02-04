package figurasgeometricas;

import java.util.ArrayList;

public class MainTriangulo {

    public static void main(String[] args) {
        ArrayList<Figura> listaFiguras = new ArrayList<>();
        listaFiguras.add(new Triangulo(4, 6));
        listaFiguras.add(new Circulo(0, 0, 5));
        listaFiguras.add(new Triangulo(5, 5));
//        System.out.println(listaFiguras.get(2)+ "posicion ");

        for (Figura f : listaFiguras) {
            System.out.println("Área de la figura: " + f.area() + " " + f.getClass().getSimpleName());
            if (f instanceof Triangulo) {
                Triangulo t1 = (Triangulo) f;
                System.out.println("\tBase: "+t1.getBase()+"\n\tAltura: " + t1.getAltura());
            } else if(f instanceof Circulo){
                Circulo c1 = (Circulo) f;
                System.out.println("\tRadio: "+c1.getRadio());
            }
        }

    }

}
