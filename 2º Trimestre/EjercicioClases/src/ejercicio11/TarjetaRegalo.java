package ejercicio11;

import java.text.DecimalFormat;

public class TarjetaRegalo {
    private double saldo;
    private int codigo;

    public TarjetaRegalo(double saldo) {
        if(!validarSaldo(saldo)){
            throw new IllegalArgumentException("El saldo debe ser positivo: ");
        }
        this.saldo = saldo;
        for (int i = 0; i < 5; i++) {
            this.codigo += (int) (Math.random()*10000);
        }
    }

    public double gasta(double gasto){
        if(!ValidarGasto(gasto)){
            throw new IllegalArgumentException("El gasto debe ser positivo");
        }
        if (gasto > saldo){
            throw new IllegalArgumentException("No puedes gastar mas de lo que tienes");
        }else{
            this.saldo = saldo - gasto;
        }
        return 0;
        
    }
    
    TarjetaRegalo fusionaCon(TarjetaRegalo numero){
        double nSaldo = this.saldo + numero.getSaldo();
        this.saldo = 0;
        numero.setSaldo(0);
        return new TarjetaRegalo(nSaldo);  
    }
    
    private boolean validarSaldo(double saldo) {
        return (saldo>=0);
    }

    private boolean ValidarGasto(double gasto) {
        return (gasto>=0);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    DecimalFormat df = new DecimalFormat("#.00"); // Es una subclase concreta de que formatea números decimales.con #.00 podemos limitar los decimales que queremos
    
    @Override //cuando se sobreescribe un metodo que viene de objetc, como toString
    public String toString() {
        return "Tarjeta nº" + codigo + " - Saldo " + df.format(saldo) + "$"; //con df.format, llamamos al metodo y ahi metemos el objeto que queremos editar
    }
    
}
