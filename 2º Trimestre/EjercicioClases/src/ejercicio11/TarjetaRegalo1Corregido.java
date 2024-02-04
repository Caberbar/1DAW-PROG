package ejercicio11;  //el mio está bien.

import java.text.DecimalFormat;

public class TarjetaRegalo1Corregido {
    private double saldo;
    private int codigo;

    public TarjetaRegalo1Corregido(double saldo) {
        if(!validarDinero(saldo)){
            throw new IllegalArgumentException("El saldo debe ser positivo");
        }
        this.saldo = saldo;
        this.codigo = generarCodigo();
    }

    public double gasta(double gasto){
        if(!validarDinero(gasto)){
            System.err.println("No tiene suficiente saldo para gastar "+gasto); //escribe la salida de error
        }else if (gasto > saldo){
            System.err.println("No puedes gastar mas de lo que tienes");
        }else{
            this.saldo = saldo - gasto;
        }
        return 0;
        
    }
    
    public TarjetaRegalo1Corregido fusionaCon(TarjetaRegalo1Corregido numero){ //metodo no static porque tiene que acceder a datos no static
        TarjetaRegalo1Corregido nueva = new TarjetaRegalo1Corregido(this.saldo+numero.saldo); //no es necesario realizar get/set ya que el objeto que creo nuevo esta en la misma clase
        this.saldo = numero.saldo = 0; //las asignaciones son sociativas de derecha a izquierda, el cero pasa a numero.saldo y despues a this.saldo
        return nueva;
    }
    
    private boolean validarDinero(double dinero) {
        return (dinero>=0);
    }
    
    DecimalFormat df = new DecimalFormat("#.00"); // Es una subclase concreta de que formatea números decimales.con #.00 podemos limitar los decimales que queremos
    
    @Override //cuando se sobreescribe un metodo que viene de objetc, como toString
    public String toString() {
        return "Tarjeta nº" + codigo + " - Saldo " + df.format(saldo) + "$"; //con df.format, llamamos al metodo y ahi metemos el objeto que queremos editar
    }

    private int generarCodigo() {
        return 0;
    }

}

//13,17,18
