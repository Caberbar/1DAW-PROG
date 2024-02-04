package academia;

public class Asignatura {
    private String nombre;
    private int horas;
 
    public Asignatura(String nombre, int horas) {
        if(!validarDato(horas)){
            throw new IllegalArgumentException("Escribe las horas correctas");
        }
        this.nombre = nombre;
        this.horas = horas;
    }

    public Asignatura(Asignatura a) { //no hace falta crear copia por que una asignatura ya existe
        this(a.nombre,a.horas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if(!validarDato(horas)){
            throw new IllegalArgumentException("Escribe las horas correctas");
        }
        this.horas = horas;
    }

    public boolean equals(Asignatura a) {
        return this.horas==a.horas && this.nombre.equals(a.nombre);
    }

     private boolean validarDato(int horas) {
        return horas >= 0;
    }
    
    @Override
    public String toString() {
        return "Asignatura: " + nombre + "   horas: " + horas;
    } 
    
}