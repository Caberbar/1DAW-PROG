
package proyectopizza;


public class ProyectoPizza {


    public static void main(String[] args) {
        Pizza p1 = new Pizza("margarita", Tamaño.MEDIANA);
        Pizza p2 = new Pizza("funghi", Tamaño.FAMILIAR);
        p2.sirve();
        Pizza p3 = new Pizza("cuatro quesos", Tamaño.MEDIANA);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        p2.sirve();
        System.out.println("pedidas: " + Pizza.getTotalPedidas());
        System.out.println("servidas: " + Pizza.getTotalServidas());
    }

}
