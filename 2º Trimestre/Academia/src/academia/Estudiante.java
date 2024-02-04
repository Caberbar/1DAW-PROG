package academia;

public class Estudiante {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Asignatura[] listaAsignaturas;

    public Estudiante(String nombre, String apellido1, String apellido2) {
        if(!validarDato(nombre)){ //por teminar
            throw new IllegalArgumentException("Escribe una cadena de caracateres valida");
        }
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Estudiante(Estudiante e) {
        this(e.nombre,e.apellido1,e.apellido2);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    boolean añadeAsignatura(Asignatura a){       
        return false;  
    }
    
    int getNumeroAsignaturasMatriculadas(){        
        return 0;       
    }
    
    int getNumeroHorasMatriculadas(){
        return 0;
    }
    
    Asignatura getAsignatura(int posicion){      
        return null;
    }

    public boolean equals(Estudiante e) {
        return false;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1 + " " + apellido2 + " estudia " + listaAsignaturas;
    }

    private boolean validarDato(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}


