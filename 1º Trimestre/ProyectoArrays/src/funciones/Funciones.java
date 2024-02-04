package funciones;

public class Funciones {
    
    //Operación de Área del triángulo con validación
    public static double areaTriangulo(double base, double altura){
        if (base<=0){
            throw new IllegalArgumentException("La base no es positiva");
        }
        if (altura<=0){
            throw new IllegalArgumentException("La altura no es positiva");
        }
        
        return (base*altura)/2;
    }

    
    //Operación de Volumen de un cono con validación
    public static double volumenCono(double radio, double altura){
        if (radio<=0){
            throw new IllegalArgumentException("El radio no es positivo");
        }
        if (altura<=0){
            throw new IllegalArgumentException("La altura no es positiva");
        }
        
        return (Math.PI*radio*radio*altura)/3;
    }
    
    
    //Operación de Operación de primer grado con validación
    public static double ecuacionPrimerGrado(double a, double b){
        if (a == 0){
            System.out.println("Vuelva he introduzca un valor mayor a 0");
        }
        
        return -a/b; 
    }
    
    //Operación de calcular el tiempo de caida con validación
    public static double tiempoCaida(double h){
        if (h < 0){
            System.out.println("Introduzca un valor mayor a 0");
        }
        
        return (Math.sqrt(2*h))/9.81;
    }
    
    //Operación de calcular si un año es bisiesto o no con validación
    public static boolean esBisiesto(int año){
        
        boolean bisiesto = (año%400==0) || ((año % 4 == 0)&&(año % 100 != 0));
        
        if (bisiesto){
            System.out.println("El año es bisiesto");
        }else{
            System.out.println("El año no es bisiesto");
        }
        return false;
        
    }
    
    //Operación de calcular el tiempo de caida con validación
    public static double potencia(double x, int n){
        
        double resultado = x;
        
        for ( int contador = 1; contador < n; contador++){
            
            resultado = (resultado*x);
           
        } 
        System.out.println("El resultado de "+ x + "^" + n + " = " + resultado);
        return 0;
           
    }
    
    //Operación saber el numeros de cifras con validación
    public static int numeroCifras(int numero){
    
        int cifras = 0;
        
        do {
            cifras++;
            numero = numero/10;
         } while (numero!=0);
        return cifras;
        
    }
    
    //Operación de calcular si un número es capicua
    public static boolean esCapicua(int numero){
        int inver=0, noinver=numero, proceso;
        
        while (numero>0){
            proceso = numero % 10;
            inver = inver *10 + proceso;
            numero = numero / 10;
        }
        
        if (noinver == inver){
            System.out.println("El numero es capicua");
        } else {
            System.out.println("El numero no es capicua");
        }
        return false;
    }
    
    
//    //Operación de calcular el precio de una llamada
    public static boolean costeLLamadaTelefonica(int segundos){
        int minutos, coste, operacion;
       
        minutos = segundos / 60;
        if (minutos <= 3) {
            coste = minutos * 15;
        } else {
            operacion = minutos - 3;
            coste = 45 + (operacion * 7);
        }
        
        if (coste > 99){
            coste = coste/100;
            System.out.println("Su llamada costo "+coste+" euro/s");
        } else {
            System.out.println("Su llamada costo "+coste+" centimos");
        }
        return false;
    }
        
    

    //Operación para ver si un numero es primo o no
    public static boolean esPrimo(int numero){
        int contador = 0, x;

        for(x = 1; x <= numero; x++)
        {
            if((numero % x) == 0)
            {
                contador++;
            }
        }
        
        if (contador <= 2){
            System.out.println("El número es primo");
        }else{
            System.out.println("El número no es primo");
        }
        return false;
    }
   
    
    //Operación para ver si un numero es perfecto o no.
    public static boolean esPerfecto(int numero){
        int suma=0, divisor=1;
            while (numero != divisor){
                if (numero % divisor == 0){
                    suma = suma+divisor;
                }
                divisor++;
            }
            if (numero  == suma){
                System.out.println("El numero es perfecto");
            }else{
                System.out.println("El numero no es perfecto");
            }
        return false;
    }
    
    
    public static int digitosNumero(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            int n = 0;
            while (numero > 0) {
                numero = numero / 10;
                n++;
            }
            return n;

        }
    }    
        
//    public static int posicionNumero(int numero) {
//        int digitos = numero, contador =0, proceso=0;
//        int id = Operaciones.digitosNumero(int numero);
//        
//        if (numero == 0) {
//
//        } else {
//            while (digitos > 0) {
//                digitos = digitos / 10;
//                contador++;
//            }
//        return contador;
//        }
//        
//        while (numero > 0){
//
//            proceso = numero % (10*contador);
//            numero = numero / 10;
//            contador--;
//            System.out.println(proceso);
//        }
//        
//        return 0;
//    }
//    
    //Operación para pasar de decimal a palotes
//    public static String conversorDigitoPalotes(int digito){
//        
//        String resultado = "";
//        
//        for (int contador = 0; contador < digitos(digito); contador++) {
//            for (int a = 0; a < posicionNumero(digito); a++) {
//                resultado += "|";
//            }
//            if (contador < digitos(digito)) {
//                resultado += "-";
//            }
//        }
//        return resultado;
//        
//    }
    
    
    
    
//  ARRAYS
    
    //Función de sumar arrays introducidos por teclado
    public static int sumarArray(int[] sumar) {
        int total = 0;
        for (int i = 0; i < sumar.length; i++) {
            total += sumar[i];
        }
        return total;
    }
    
    
    //Función de número máximo introducido por teclado
    public static int numeroMaximo(int[] mayor) {
        int total = 0;
        for (int i = 1; i < mayor.length; i++) {
            if (mayor[i] > total) {
		total = mayor[i];
            }
        }
        return total;
    }
    
    //Funció que pide x numeros y los devuelve al revés
    public static int inverso(int[] numeros) {
        int cantidad = 10;
        
        for (cantidad = 0; cantidad < 10; cantidad++) {
            numeros[cantidad] = LeerDatosTeclado.leerInt("Introduce 10 numeros: ");
        }
    
        for (cantidad = 9; cantidad >= 0; cantidad--) {
          System.out.println(numeros[cantidad]);
        }
        return 0;
    }
    
    //Suma de filas en un Array
    //public static int sumaFilas(int [] fila,int numeros,int columna) {
    //    int sumaFila;
    //    for(fila = 0; fila < 4; fila++) {
    //     sumaFila = 0;
    //      for(columna = 0; columna < 5; columna++) {
    //       System.out.printf("%7d   ", numeros[fila][columna]);
    //        sumaFila += numeros[fila][columna];
    //      }
    //      System.out.printf("|%7d\n", sumaFila);
    //    }
    //}

    //Pedir al ususario x filas y x columnas
    public static String pedirFilasColumnas(int fila, int columna, int [][] numeros){
        String valor ="";
        System.out.println("Introduce los números");
        for(fila = 0; fila < 4; fila++) {
            for(columna = 0; columna < 5; columna++) {
            System.out.print("Fila " + fila + ", columna " + columna + ": ");
            numeros[fila][columna] = LeerDatosTeclado.leerInt("Introduce un número: ");
            }
        }   
        return valor;
    }
    
    public static String sumarFilas(int fila, int columna, int [][] numeros){
        String valor =" ";
        int sumaFila;
        for(fila = 0; fila < 4; fila++) {
          sumaFila = 0;
          for(columna = 0; columna < 5; columna++) {
            System.out.printf("%7d   ", numeros[fila][columna]); //Mostramos por pantalla los numeros
            sumaFila += numeros[fila][columna];
          }
            System.out.printf("|%7d\n", sumaFila);//Mostramos por pantalla la suma de la filas
        }
        return valor;
    }
    
    public static String sumarColumnas(int fila, int columna, int[][] numeros) {
        String valor = "";
        int sumaColumna;
        int sumaTotal = 0;
        for (columna = 0; columna < 5; columna++) {
            sumaColumna = 0;
            for (fila = 0; fila < 4; fila++) {
                sumaColumna += numeros[fila][columna];
            }

            sumaTotal += sumaColumna;
            System.out.printf("%7d   ", sumaColumna);//Mostramos por pantalla la suma de loa columnas
        }
        System.out.printf("|%7d   ", sumaTotal);//Mostramos por pantalla la suma ed las filas con las columnas
        System.out.println("\n");
        return valor ;
    }
    
    //Generar una Array
    public static String generarArray(int[][] numeros){
        String valor = "";
        int cont;
        int cont2 = 0;
        for(cont = 0; cont < 10; cont++) {
          for(cont2 = 0; cont2 < 10; cont2++) {
            numeros[cont][cont2] = (int)(Math.random()*101) + 200;
            System.out.printf("%5d", numeros[cont][cont2]);
            }
          System.out.println();
        }
        return valor;
    }
}



