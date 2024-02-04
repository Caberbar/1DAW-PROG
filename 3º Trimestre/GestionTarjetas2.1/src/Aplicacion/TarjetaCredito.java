package Aplicacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Esta clase crea una tarjeta dentro del array TarjetaCredito.
 * Es una versi�n inicial que he creado sobre el trabajo de Tarjetas de Cr�dito.
 * @author Carlos Bernal Barrionuevo.
 */
public class TarjetaCredito implements Comparator<Movimiento>, Serializable{

    private String nombre;
    private String nif;
    private String pin;
    private int limite;
    private int mes;
    private int a�o;
    private String numero;
    private int[] cvv;
    private ArrayList <Movimiento> movimientos;

    /**
     * Construye el objeto Tarjeta a trav�s de los par�metros nombre, nif, pin, l�mite y n�mero.
     * Se construir� un objeto con el nombre del titular, el NIF, el pin de la 
     * tarjeta, el l�mite de la tarjeta y su n�mero y se asignar� por defecto 
     * la fecha de caducidad del sistema aunque al a�o se le suma 5 a�os m�s y el
     * CVV se crear� autom�tico.
     * Todos los par�metros son validados, en caso de no ser corrector se 
     * lanzar� un IllegalArgumentException.
     * 
     * @param nombre Valor que tendr� el nombre del titular de la tarjeta. Validado por tama�o y caracteres.
     * @param nif Valor que tendr� el NIF del titular de la tarjeta. Validado por tama�o y letra.
     * @param pin Valor que tendr� el pin titular de la tarjeta. Debe ser de 4 cifras.
     * @param limite Valor que tendr� el l�mite de la tarjeta. Validado por cantidad entre 500 y 5000.
     * @param numero Valor que tendr� el n�mero de la tarjeta. Validado por tama�o y d�gito de control.
     */
    public TarjetaCredito(String nombre, String nif, String pin, int limite, String numero) {
        if (!Validar.validarNombre(nombre)) {
            throw new IllegalArgumentException("Debes introducir un nombre v�lido");
        }
        if (!Validar.validarNIE(nif)) {
            throw new IllegalArgumentException("Debes introducir un NIF/NIE/CIF valido");
        }
        if (!Validar.validarPin(pin)) {
            throw new IllegalArgumentException("Debes introducir un PIN v�lido de 4 cirfras");
        }
        if (Validar.validarLimite(limite)) {
            throw new IllegalArgumentException("Debes introducir un limite entre 500 y 5000");
        }
        if (!comprobarNumeroTarjeta(numero)){
            throw new IllegalArgumentException("Debes introducir una tarjeta valida");  
        }
        this.nombre = nombre;
        this.nif = nif;
        this.pin = pin;
        this.limite = limite;
        this.mes = LocalDateTime.now().getMonthValue();
        this.a�o = LocalDateTime.now().getYear() + 5;
        this.numero = numero;
        this.cvv = new int[4];
        for (int num = 0; num < 3; num++) {
            this.cvv[num] = (int) (Math.random() * 10);
        }
        this.movimientos = new ArrayList<>();
    }

    /**
     * Construye una copia TarjetaCredito a trav�s de un �nico par�metro.
     * Se construir� un objeto con un valor(tarjeta), copiando los par�metros 
     * de otro objeto.
     * 
     * @param tarjeta El valor de la tarjeta que se usar� para crearlo.
     */
    public TarjetaCredito(TarjetaCredito tarjeta) {
        this.nombre = tarjeta.nombre;
        this.nif = tarjeta.nif;
        this.pin = tarjeta.pin;
        this.limite = tarjeta.limite;
        this.mes = tarjeta.mes;
        this.a�o = tarjeta.a�o;
        this.numero = tarjeta.numero;
        this.cvv = new int[3];
        for(int num = 0; num < 3; num++) {
            this.cvv[num] = tarjeta.cvv[num];
        }
        this.movimientos=  new ArrayList<>(tarjeta.movimientos);
    }

    /**
     * Extrae el nombre de la tarjeta.
     * @return Devuelve el nombre de la tarjeta pasado por par�metro.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Extrae el NIE/NIF/CIF de la tarjeta.
     * @return Devuelve el NIE/NIF/CIF de la tarjeta pasado por p�rametro.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Extrae el pin de la tarjeta.
     * @return Devuelve el p�n de la tarjeta pasado por par�metro.
     */
    public String getPin() {
        return pin;
    }

    /**
     * Extrae el l�mite de la tarjeta.
     * @return Devuelve el l�mite de la tarjeta pasado por p�rametro.
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Extrae el mes de caducidad de la tarjeta.
     * @return Devuelve el m�s de caducidad de la tarjeta pasado por par�metro.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Extrae el a�o de caducidad de la tarjeta.
     * @return Devuelve el a�o de caducidad de la tarjeta pasado por par�metro.
     */
    public int getA�o() {
        return a�o;
    }

    /**
     * Extrae el n�mero de la tarjeta.
     * @return Devuelve el n�mero de la tarjeta pasado por par�metro.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Extrae el CVV de la tarjeta.
     * @return Devuelve el CVV de la tarjeta pasado por par�metro.
     */
    public String getCvv() {
        return ""+this.cvv[0]+this.cvv[1]+this.cvv[2];
    }

    /**
     * Establece el pin de la tarjeta.
     * Establecer� un nuevo pin a al objeto tarjeta, pasado por par�metro.
     * Ser� validado antes de establecerlo, deber� ser de 4 cifras.
     * @param pin Valor que tendr� el pin titular de la tarjeta. Debe ser de 4 cifras.
     */
    public void setPin(String pin) {
        if(!Validar.validarPin(pin)){
             throw new IllegalArgumentException("Debes introducir un PIN valido de 4 cifras");
        }
        this.pin = pin;
    }

    /**
     * Establece el l�mite de la tarjeta.
     * Establecer� un nuevo l�mite a al objeto tarjeta, pasado por par�metro.
     * Ser� validado antes de establecerlo, deber� estar entre 500 y 5000.
     * @param limite Valor que tendr� el l�mite de la tarjeta. Validado por cantidad entre 500 y 5000.
     */
    public void setLimite(int limite) { //cambiar
        if(Validar.validarLimite(limite)){
             throw new IllegalArgumentException("Debes introducir un limite entre 500 y 5000");
        }
        this.limite = limite;
    }

    /**
     * Realizar un pago con la tarjeta.
     * Se realizar� un pago en la tarjeta llamando a la clase "Movimientos", 
     * pero antes de eso se validar� la cantidad, que no supere el gasto total 
     * ni el l�mite se pago, adem�s de validar un concepto v�lido entre 5 y 50 
     * caracteres.
     * @param cantidad Valor que tomar� el objeto movimiento.
     * @param concepto Valor que tomar� el objeto movimiento.
     * @return Devolver� true si se ha podido realizar el pago, false si no.
     */
    public boolean pagar(double cantidad, String concepto) {
        if (Validar.validarPagar(cantidad)) {
            throw new IllegalArgumentException("Debes introducir una cantidad positiva");
        }
        if (cantidad + this.gastado() > this.limite) {
            throw new IllegalArgumentException("Has superado el limite de gasto");
        }
        if (Validar.validarConcepto(concepto,51)) {
            throw new IllegalArgumentException("Debes introducir un concepto valido (5-50 caracteres): ");
        }
        this.movimientos.add(new Movimiento(cantidad,concepto));
        //this.movimientos[this.numeroMovimientos()] = new Movimiento(cantidad,concepto);
        if(gastado() > this.limite) {
            throw new IllegalArgumentException("Has superado el limite de la tarjeta");
        }
        return true;
    }

    /**
     * Extrae el gasto total de la tarjeta.
     * Recorre todos los movimientos de la tarjeta sumando los gastos de cada 
     * uno de los movimientos.
     * @return Devuelve el gasto total de la tarjeta pasado por par�metro.
     */
    public double gastado() {
        double gastado = 0;
        for (int i = 0; i < this.numeroMovimientos(); i++) {
            gastado = gastado + this.movimientos.get(i).getCantidad();
        }
        return gastado;
    }

    /**
     * Mostrar movimientos por pantalla.
     * Escribir� por pantalla el n�mero de movimientos que el usuario quiera, 
     * escribi�ndolo por teclado, en caso de ser una cantidad superior a la de 
     * movimientos que tiene la tarjeta se lanzar� un  IllegalArgumentException.
     * @param numero Valor que tomara el n�mero de movimientos que desea ver.
     * @return
     */
    public ArrayList movimientos(int numero) {
        ArrayList<Movimiento> movimientos = new ArrayList<>(numero);
        int cont = this.numeroMovimientos();
        if(numero>cont){
            throw new IllegalArgumentException("No hay movimientos suficientes");
        }
        cont -= 1;
        for (int i = this.movimientos.size(); i > cont-numero; i--) {
           movimientos.add(this.movimientos.get(i));
        }
        return movimientos;
    }

    
    
    /**
     * Ver el n�mero de movimientos de la tarjeta.
     * Comprobar� que al menos haya un movimiento en la tarjeta.
     * @return Devuelve true si el n�mero de movimientos que lleva echa la 
     * tarjeta es m�s de 0 y false si no.
     */
    public int numeroMovimientos() {
        int numeroMovimientos = this.movimientos.size();
        return numeroMovimientos;
    }

    /**
     * Validar n�mero de tarjeta de cr�dito/d�bito.
     * Comprueba que el n�mero escrito por teclado sea un n�mero v�lido, para
     * ello primero miramos que solo ha introducido n�mero y que tenga una 
     * longitud de 16 n�meros, si no devolver� false y saldr�, cogeremos la 
     * �ltima cifra escrita por teclado y compararemos que esa cifra y la 
     * obtenida por la funci�n "obtenerDigitoControl" es la misma, si es la 
     * misma quiere decir que la tarjeta es v�lida y devolver� true, si no lo es,
     * devolver� false.
     */
    public static boolean comprobarNumeroTarjeta(String numero) {
        boolean esValido = false;
        String control = numero.substring(numero.length() - 1);
        if(control.equals(obtenerDigitoControl(numero))){
            esValido = true;
        }
    return esValido;
    }

    
    
    /**
     * Extraer el d�gito de control de una tarjeta de cr�dito.
     * Extrae el d�gito de control de una tarjeta de cr�dito, primero quita el 
     * �ltimo digito de la tarjeta y se queda con los dem�s 15, despu�s se 
     * calcular� el �ltimo d�gito de la tarjeta con el algoritmo de Luhn.
     * Se multiplicar� por  2 los numero en las posiciones pares empezando por
     * el final, los que  est�n en las posiciones impares se sumaran con los 
     * d�gitos obtenidos de las multiplicaciones anteriores, si el resto de 
     * dividir el total entre 10 es igual a cero.
     * @param n�mero Valor que tomara el n�mero de la tarjeta.
     * @return Devolver� el �ltimo d�gito de la tarjeta mediante el 
     * algoritmo de luhn
     */
    public static String obtenerDigitoControl(String numero) {
        int suma = 0;
        boolean seleccion = true;
        numero = numero.substring(0, numero.length()-1);
        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Integer.parseInt(numero.substring(i, i + 1)); //Con Integer.parseInt convertimos una cadena de texto a un entero, y con substring vamos seleccionando cada digito, caracter de la cadena
            if (seleccion) {
                digito *= 2;
                if (digito == 18) {
                    digito = 9;
                }
                if (digito > 9) {
                    digito = (digito % 9);
                }
            }
            suma += digito;
            seleccion = !seleccion;
        }
        suma = (suma % 10);
        if(suma!=0){
            suma = 10 - suma;  
        }
        return "" + suma;
    }

    /**
     * Compara si dos objetos son iguales.
     * @param t El valor de la tarjeta que se usar� para compararlo con el objeto actual.
     * @return Devolver� true si hay una tarjeta igual, si no devolver� false.
     */
    public boolean equals(TarjetaCredito t) {
        return (this.numero.equals(t.numero));
    }

    /**
     *  Mostrar objeto por pantalla.
     * @return Mensaje por pantalla con informaci�n detallada del objeto tarjeta.
     */
    @Override
    public String toString() {
        return "TarjetaCredito: \n\nNombre: " + nombre + "\nNIF: " + nif + "\nFecha de caducidad: " + mes + "/" + a�o + "\nNumero: " + numero + "\nLimite: " + limite + "\nDinero Gastado: "+ this.gastado()+"\n";
    }

    @Override
    public int compare(Movimiento o1, Movimiento o2) {
        return (int)(o1.getCantidad() - o2.getCantidad());
    }
    
}
