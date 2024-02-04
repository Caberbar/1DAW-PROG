package proyectoarrays;

public class Ejercicio04 {
    public static void main(String[] args) {

        System.out.println("Bienvenido al programa de calcular el cuadrado y el cubo de los numeros");
        System.out.println("--------------------------------------------------------");
        
        int [] numero = new int[20];
        int [] cuadrado = new int [20];
        int [] cubo = new int [20];
        int contador;
      
      for (contador = 0; contador < 20; contador++) {
        numero[contador] = (int)(Math.random()*101);
        cuadrado[contador] = numero[contador] * numero[contador];
        cubo[contador] = cuadrado[contador] * numero[contador];
      }
      
      for (contador = 0; contador < 20; contador++) {
        System.out.println(numero[contador]+"\t"+cuadrado[contador]+"\t"+cubo[contador]);
      }
  }
        
}

//Define tres arrays de 20 números enteros cada una, con nombres numero, cuadrado
//y cubo. Carga el array numero con valores aleatorios entre 0 y 100. En el array
//cuadrado se deben almacenar los cuadrados de los valores que hay en el array
//numero. En el array cubo se deben almacenar los cubos de los valores que hay en
//numero. A continuación, muestra el contenido de los tres arrays dispuesto en tres
//columnas.