/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollozaidin;

import java.util.Objects;

/**
 *
 * @author DAW-B
 */
public abstract class Empleado implements Comparable<Empleado>{
    private String nombre;
    private String apellidos;
    private int salario_base;
    private int anios;

    /**
     *
     * @param nombre
     * @param apellidos
     * @param salario_base
     * @param anios
     */
    public Empleado(String nombre, String apellidos, int salario_base, int anios) {
        if(nombre.isBlank() || nombre.isEmpty()){
            throw new IllegalArgumentException("Debes instroducir un nombre valido. ");
        }
        if(apellidos.isBlank() || apellidos.isEmpty()){
            throw new IllegalArgumentException("Debes instroducir unos apellidos validos. ");
        }
        if(salario_base<1){
            throw new IllegalArgumentException("Debes instroducir un salario valido. ");
        }
        if(anios<0){
            throw new IllegalArgumentException("Debes instroducir un nuemro de años valido. ");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario_base = salario_base;
        this.anios = anios;
    }
    
    private Empleado(Empleado e){
        this(e.nombre,e.apellidos,e.salario_base,e.anios);
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @return
     */
    public int getSalario_base() {
        return salario_base;
    }

    /**
     *
     * @return
     */
    public int getAnios() {
        return anios;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        if(!nombre.isBlank() && !nombre.isEmpty()){
            this.nombre = nombre;
        }
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        if(!apellidos.isBlank() && !apellidos.isEmpty()){
            this.apellidos = apellidos;
        }
    }

    /**
     *
     * @param salario_base
     */
    public void setSalario_base(int salario_base) {
        if(salario_base>0){
            this.salario_base = salario_base;
        }
    }

    /**
     *
     * @param anios
     */
    public void setAnios(int anios) {
        if(anios>=0){
            this.anios = anios;
        }
    }
    
    /**
     *
     * @param nombre
     * @param apellidos
     * @return
     */
    public int numeroTrienios(String nombre, String apellidos){
        int contador = 0;        
        for (int i = 0; i < this.getAnios(); i++) {
            if(i%3==0){
                contador++;
            }
        }
        
        return contador;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n\tEmpleado: Nombre=" + nombre + ", apellidos=" + apellidos + ", salario base=" + salario_base + ", años=" + anios;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellidos, other.apellidos);
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
    public abstract double calcularSalario();
    
}
