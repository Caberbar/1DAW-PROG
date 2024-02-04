package cafetera;

public class MainCafetera {

    
    public static void main(String[] args) {
    
        Cafetera c1 = new Cafetera();
        Cafetera c2 = new Cafetera(120,10);
        Cafetera c3 = new Cafetera(200,130);
        Cafetera c4 = new Cafetera(1000,500);
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        c2.setCantidadActual(1000);
        System.out.println(c2);
        
        System.out.println("");
        
        c3.llenarCafetera();
        System.out.println(c3);
        c2.vaciarCafetera();
        System.out.println(c2);
        c4.agregarCafe(200);
        System.out.println(c4);
   } 
}
