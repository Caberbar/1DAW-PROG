package funciones;

public class Operaciones {
    
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
    
    
    //Cuenta el número de dígitos de un número entero.
    public static int digitos(long numero) {
        if (numero < 0) {
            numero = -numero;
        }
        if (numero == 0) {
            return 1;
        } else {
            int n = 0;
            while (numero > 0) {
                numero = numero / 10; // se le quita un dígito a x
                n++; // incrementa la cuenta de dígitos
            }
            return n;
        }
    }

    
    //Le da la vuelta a un número. (Long permite mas digitos que if)
    public static long voltea(long numero) {
        if (numero < 0) {
            return -voltea(-numero);
        }
        long volteado = 0;
        while (numero > 0) {
            volteado = (volteado * 10) + (numero % 10);
            numero = numero / 10;
        }
        return volteado;
    }

    
    
    //Devuelve el dígito que está en la posición <code>n</code> de un númeroentero. Se empieza contando por el 0 y de izquierda a derecha.
    public static int digitoN(long x, int n) {
        x = voltea(x);
        while (n-- > 0) {
            x = x / 10;
        }
        return (int) x % 10;
    }

        
    //Da la posición de la primera ocurrencia de un dígito dentro de un número entero. Si no se encuentra, devuelve -1.
    public static int posicionDeDigito(long x, int d) {
        int i;
        for (i = 0; (i < digitos(x)) && (digitoN(x, i) != d); i++) {
        };
        if (i == digitos(x)) {
            return -1;
        } else {
            return i;
        }
    }
    
    
    //Le quita a un número de dígitos por detrás (por la derecha).
    public static long quitaPorDetras(long x, int n) {
        return x / (long) potencia(10, n);
    }
    
    
    //Le quita a un número de dígitos por delante (por la izquierda).
    public static long quitaPorDelante(long x, int n) {
        x = pegaPorDetras(x, 1); // "cierra" el número por si acaso termina en 0
        x = voltea(quitaPorDetras(voltea(x), n));
        x = quitaPorDetras(x, 1);
        return x;
    }
    
    
    //Añade un dígito a un número por detrás (por la derecha).
    public static long pegaPorDetras(long numero, int digito) {
        return juntaNumeros(numero, digito);
    }

    //Añade un dígito a un número por delante (por la izquierda).
    public static long pegaPorDelante(long numero, int digito) {
        return juntaNumeros(digito, numero);
    }

    //Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el trozo correspondiente.
    public static long trozoDeNumero(long numero, int inicio, int fin) {
        int longitud = digitos(numero);
        numero = quitaPorDelante(numero, inicio);
        numero = quitaPorDetras(numero, longitud - fin - 1);
        return numero;
    }
    
    
    //Pega dos números para formar uno solo.
    public static long juntaNumeros(long n1, long n2) {
        return (long) (n1 * potencia(10, digitos(n2))) + n2;
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
    public static String conversorDigitoPalotes(int digito){
        
        String resultado = "";
        for (int i = 0; i < digitos(digito); i++) {
            for (int j = 0; j < digitoN(digito, i); j++) {
                resultado += "|";
            }
            if (i < digitos(digito) - 1) {
                resultado += "-";
            }
        }
        return resultado;

    }
    
    }

