
package figuras;


public abstract class Figura implements Comparable<Figura>{
    
    public Figura(){
        
    }
    
    public abstract void arrancar();
    
    public double area(){
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    @Override
    public int compareTo(Figura o) {
        return (int) (this.area() - o.area());
    }


//public static void ordenarArray(Comparable[] array) {
//        int n = array.length;
//        boolean intercambiado;
//        
//        do {
//            intercambiado = false;
//            
//            for (int i = 0; i < n - 1; i++) {
//                if (array[i].compareTo(array[i + 1]) > 0) {
//                    Comparable temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                    intercambiado = true;
//                }
//            }
//            
//            n--;
//        } while (intercambiado);
//    }
    
    
}
