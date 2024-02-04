/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollozaidin;

import java.util.ArrayList;

/**
 *
 * @author DAW-B
 */
public class Programador extends Empleado {
    
    private String Lenguaje_programacion;
    private int plus;
    private int numero_proyectos;
    private ArrayList<Programador> programadores;

    /**
     *
     * @param Lenguaje_programacion
     * @param plus
     * @param numero_proyectos
     * @param nombre
     * @param apellidos
     * @param salario_base
     * @param anios
     */
    public Programador(String Lenguaje_programacion, int plus, int numero_proyectos, String nombre, String apellidos, int salario_base, int anios) {
        super(nombre, apellidos, salario_base, anios);
        if(Lenguaje_programacion.isBlank() || Lenguaje_programacion.isEmpty()){
            throw new IllegalArgumentException("Debes instroducir un lenguaje de programación valido. ");
        }
        if(plus<0){
            throw new IllegalArgumentException("Debes instroducir un plus valido. ");
        }
        if(numero_proyectos<0){
            throw new IllegalArgumentException("Debes instroducir un numero de proyectos valido. ");
        }
        this.Lenguaje_programacion = Lenguaje_programacion;
        this.plus = plus;
        this.numero_proyectos = numero_proyectos;
    }

    /**
     *
     * @return
     */
    public String getLenguaje_programacion() {
        return Lenguaje_programacion;
    }

    /**
     *
     * @return
     */
    public int getPlus() {
        return plus;
    }

    /**
     *
     * @return
     */
    public int getNumero_proyectos() {
        return numero_proyectos;
    }

    /**
     *
     * @param Lenguaje_programacion
     */
    public void setLenguaje_programacion(String Lenguaje_programacion) {
        if(!Lenguaje_programacion.isBlank() && !Lenguaje_programacion.isEmpty()){
            this.Lenguaje_programacion = Lenguaje_programacion;
        }
    }

    /**
     *
     * @param plus
     */
    public void setPlus(int plus) {
        if(plus>=0){
            this.plus = plus;
        }
    }

    /**
     *
     * @param numero_proyectos
     */
    public void setNumero_proyectos(int numero_proyectos) {
        if(numero_proyectos>=0){
            this.numero_proyectos = numero_proyectos;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nProgramador: " + this.getNombre() + " " +this.getApellidos() + " - salario:" +this.getSalario_base() + ", años trabajados" +this.getAnios()
                + " Lenguaje_programacion=" + Lenguaje_programacion + ", plus=" + plus + ", numero_proyector=" + numero_proyectos;
    }

    /**
     *
     * @return
     */
    @Override
    public double calcularSalario() {
        double salario = 0; 
        int trienio = this.getAnios() / 3;
        salario += this.getSalario_base();
        salario += this.getPlus();
        salario += (100 * trienio);
        return salario;
    }
    
    
    
}
