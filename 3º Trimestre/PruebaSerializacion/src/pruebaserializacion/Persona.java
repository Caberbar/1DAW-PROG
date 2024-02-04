/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaserializacion;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Persona implements Serializable{
    String nombre;
    String calle;
    String numero;

    public Persona(String nombre, String calle, String numero) {
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", calle=" + calle + ", numero=" + numero + '}';
    }
    
    
}
