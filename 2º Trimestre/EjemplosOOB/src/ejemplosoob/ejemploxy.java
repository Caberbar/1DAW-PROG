package ejemplosoob;

public class ejemploxy {
   
    public static void main(String[] args) {
        xy p1 =new xy(2,-5);
        xy p2 =new xy(2);
        xy p3 =new xy();
        xy p4 =new xy(p2);
        
        System.out.println(p2.getX());
        System.out.println(p1.getY());
    }
    
}
