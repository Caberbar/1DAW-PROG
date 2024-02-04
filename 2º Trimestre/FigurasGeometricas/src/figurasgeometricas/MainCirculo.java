package figurasgeometricas;

public class MainCirculo {

    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(6,3);
        Punto p3 = new Punto(p2);
        Punto p4 = new Punto(2,4);
        
        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo(p2,4);
        Circulo c3 = new Circulo(c1);
        Circulo c4 = new Circulo(6,3,4);       
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(" ");
        System.out.println("Área: "+c2.area());
        System.out.println("Circunferencia: "+c2.getCircunferencia());
        System.out.println(c4.equals(c2));
    }
    
}
