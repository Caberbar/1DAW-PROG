/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author deifont
 */
public class ModeloListaCanciones extends AbstractTableModel{

    private ArrayList<Cancion> listaCanciones;
    private final String [] nombresColumnas = {"Titulo", "Autor", "Duración"};
    
    public ModeloListaCanciones(){
        this.listaCanciones = new ArrayList<>();
    }
    
    public void añadirCancion(Cancion c){
        this.listaCanciones.add(c);
    }
    
    @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaCanciones.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Cancion c = listaCanciones.get(row);
        Object value = null;
        switch(column){
            case 0:
                value = c.getNombre();
                break;
            case 1: 
                value = c.getAutor();
                break;
            case 2:
                value = c.getDuracion();
                break;
        }
        return value;
    }
    
}
