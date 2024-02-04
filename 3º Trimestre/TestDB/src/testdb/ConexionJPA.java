/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdb;

import controlador.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author Usuario
 */
public class ConexionJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Empleado empleado = new Empleado();
            EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

            empleado = empleadoJpa.findEmpleado(1);
            System.out.println(empleado.getNombre());
//            if (empleado.getCodigoEmpleado() == 1) {
//                System.out.println(empleado.getNombre());
//            }
            //clienteJpa.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ConexionJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
