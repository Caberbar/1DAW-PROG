package DiscoDuroDeRoer;

//Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos. Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.

public class EjerciciosBásicos_2 {

    public static void main(String[] args) {
        int x = 9;
        int y = 9;

        if (x >= y) {
            if(x == y){
                System.out.println("Los número son iguales");
            }else{
                System.out.println(x+" es mayor que "+y);
            }
        }else{
            System.out.println(y+" es mayor que "+x);
        }
    }

}
