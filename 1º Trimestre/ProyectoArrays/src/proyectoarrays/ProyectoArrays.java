package proyectoarrays;

public class ProyectoArrays {

    public static void main(String[] args) {
        
        int elementos = 11;
        int [] arrayEnteros;
        int [] arrayImpares = {1,3,5,7,9};
        
        arrayEnteros = new int[elementos];
        
        for(int i=0; i<arrayEnteros.length; i++){
            arrayEnteros [i]= i*2;
        }
        
        for (int valor:arrayEnteros){
            System.out.println(valor);
        }
        
        System.out.println("Valor en la posición 0: "+arrayImpares[0]);
        
    }
    
}
