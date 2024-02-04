/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollozaidin;

/**
 *
 * @author DAW-B
 */
public class Comercial extends Empleado {

    private Zona_Ventas zona;
    private int numero_ventas;

    /**
     *
     * @param zona
     * @param numero_ventas
     * @param nombre
     * @param apellidos
     * @param salario_base
     * @param anios
     */
    public Comercial(Zona_Ventas zona, int numero_ventas, String nombre, String apellidos, int salario_base, int anios) {
        super(nombre, apellidos, salario_base, anios);
        if (numero_ventas < 0) {
            throw new IllegalArgumentException("Debes instroducir un numero de ventas valido. ");
        }
        this.zona = zona;
        this.numero_ventas = numero_ventas;
    }

    /**
     *
     * @return
     */
    public Zona_Ventas getZona() {
        return zona;
    }

    /**
     *
     * @return
     */
    public int getNumero_ventas() {
        return numero_ventas;
    }

    /**
     *
     * @param zona
     */
    public void setZona(Zona_Ventas zona) {
        this.zona = zona;
    }

    /**
     *
     * @param numero_ventas
     */
    public void setNumero_ventas(int numero_ventas) {
        if (numero_ventas >= 0) {
            this.numero_ventas = numero_ventas;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nComercial: " + this.getNombre() + " " + this.getApellidos() + " - salario:" + this.getSalario_base() + ", años trabajados: " + this.getAnios()
                + " zona - " + zona + ", numero de ventas - " + numero_ventas;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Empleado o) {
        return Integer.compare((int)this.calcularSalario(), (int)o.calcularSalario());
    }

    /**
     *
     * @return
     */
    @Override
    public double calcularSalario() {
        double salario = 0;
        salario += this.getSalario_base();
        if(this.getNumero_ventas() > 5 && this.getNumero_ventas() < 10){
            salario += salario*0.10;
        }else if(this.getNumero_ventas() > 10){
            salario += salario*0.15;
        }
        return salario;
    }

}
