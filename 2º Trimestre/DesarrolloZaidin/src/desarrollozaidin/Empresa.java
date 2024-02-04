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
public class Empresa {
    
    ArrayList<Empleado> listaEmp;
    private String nombre;

    /**
     *
     * @param nombre
     */
    public Empresa(String nombre) {
        this.listaEmp = new ArrayList<>();
        this.nombre = nombre;
    }
    
    /**
     *
     * @param e
     * @return
     */
    public boolean añadirEmpleado(Empleado e){
        boolean creado = false;
        if(posicionEmpleado(e.getNombre(),e.getApellidos()) != -1){
              System.out.println("Ya existe un empleado llamado asi.");  
        }else{
            this.listaEmp.add(e);
            creado = true;
        }

        return creado;
    }
    
    /**
     *
     * @param listaEmp
     * @return
     */
    public int añadirEmpleados(ArrayList<Empleado> listaEmp){
        
        return 0;
        
    }
    
    /**
     *
     * @param nombre
     * @param apellidos
     * @return
     */
    public boolean eliminarEmpleado(String nombre, String apellidos){
        if(posicionEmpleado(nombre,apellidos) != -1){
            this.listaEmp.remove(posicionEmpleado(nombre,apellidos));
        }else{
           System.out.println("No existe un empleado llamado asi.");
        }
        return false;
    }
    
    /**
     *
     * @param apellidos
     * @return
     */
    public int eliminarEmpleados(String apellidos){ //sumar eliminados
        int eliminados = 0;
        if(posicionEmpleadoApellido(apellidos) != -1){
            for (int i = 0; i < listaEmp.size()-1; i++) {
                this.listaEmp.remove(posicionEmpleadoApellido(apellidos));
                eliminados++;
            }
        }else{
           System.out.println("No existen empleados llamado asi.");
        }
        return eliminados;
        
    }
    
    /**
     *
     * @return
     */
    public double calcularCosteProgramadores(){
        int total = 0;
        for (Empleado media : listaEmp) {
            if (media instanceof Programador) {
                total += media.calcularSalario();
            }
        }
        
        return total;
        
    }
    
    /**
     *
     * @param n
     * @return
     */
    public ArrayList<Comercial>mejoresComerciales(int n){
        
        return null;
        
    }
    
    /**
     *
     * @return
     */
    public double calcularCosteEmpleados(){
        int total = 0;
        for (Empleado media : listaEmp) {
            total += media.calcularSalario();
        }
        return total;
    }
    
    /**
     *
     * @param nombre
     * @param apellidos
     * @return
     */
    public int posicionEmpleado(String nombre,String apellidos){
        int encontrado = -1;
        for (int i = 0; i < listaEmp.size(); i++) {
            if (listaEmp.get(i).getNombre().equals(nombre) && listaEmp.get(i).getApellidos().equals(apellidos)) {
                encontrado = i;
            }
            
        }
        return encontrado;
    }
    
    /**
     *
     * @param apellidos
     * @return
     */
    public int posicionEmpleadoApellido(String apellidos){
        int encontrado = -1;
        for (int i = 0; i < listaEmp.size(); i++) {
            if (listaEmp.get(i).getApellidos().equals(apellidos)) {
                encontrado = i;
            }
            
        }
        return encontrado;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Empresa: \n\tNombre- " + nombre + " \n\tLista de empleados: " + listaEmp;
    }
    
    
}
