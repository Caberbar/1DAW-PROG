/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

public class Usuario {

    private String nombre;
    private String contraseña;

    public Usuario(String nombre, String contraseña) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Introduce un nombre correcto. ");
        }
        if (contraseña.isBlank()) {
            throw new IllegalArgumentException("Introduce una contraseña correcta. ");
        }
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.isBlank()) {
            this.nombre = nombre;
        }

    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        if (!contraseña.isBlank()) {
            this.contraseña = contraseña;
        }

    }

}
