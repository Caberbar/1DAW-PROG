package ejercicio13;

public class CuentaCorriente {
    private double saldo;
    private int codigo;

    public CuentaCorriente(double saldo) {
        if(!validarCantidad(saldo)){
            System.err.println("El saldo debe ser positivo");
        }
        this.saldo = saldo;
        this.codigo = generarCodigo();
    }

    public CuentaCorriente() {
        this.saldo = 0;
        this.codigo = generarCodigo();
    }
    
    public double ingreso(double cantidad){
        if(!validarCantidad(cantidad)){
            throw new IllegalArgumentException("Introduzca una cantidad positiva");
        }
        return this.saldo += cantidad;
    }
    
    public double cargo(double cantidad){
    if(!validarCantidad(cantidad)){
            throw new IllegalArgumentException("Introduzca una cantidad positiva");
        }
        return this.saldo -= cantidad;
    }
    
    public void transferencia (CuentaCorriente cuenta, double cantidad){ //la cuenta 3 recibe
        cuenta.saldo = cuenta.saldo + cantidad;
        this.saldo -= cantidad;

    }
    

    private boolean validarCantidad(double numero) {
        return numero >= 0;
    }

    private int generarCodigo() {
        for (int i = 0; i < 10; i++) {
            this.codigo += (int) (Math.random()*999999999);
        }
        return this.codigo;
    }

    @Override
    public String toString() {
        return "Número de cta: " + codigo + " Saldo: " + saldo +" $";
    }
    
    
}
