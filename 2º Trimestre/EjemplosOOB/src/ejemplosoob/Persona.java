package ejemplosoob;

public class Persona {
    private String nombre; //los tipos string son inmutables, da igual que copiemos la referencia que creara una copia
    private byte edad;
    private double estatura;
   
    public Persona(String nombre, byte edad, double estatura) {
        
        if(!validarNombre(nombre)){
            throw new IllegalArgumentException("El nombre debe contener algún caracter");
        }
        if(!validarPositivo(edad)){
            throw new IllegalArgumentException("La edad debe ser mayor que 0");
        }
        if(!validarPositivo(estatura)){
            throw new IllegalArgumentException("La estatu ra debe ser mayor que 0");
        }
        
        this.nombre = nombre;       
        this.edad = edad;        
        this.estatura = estatura;
    }
    
    public Persona(Persona p){
        this(p.nombre,p.edad,p.estatura);
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
         if(validarNombre(nombre)){
            this.nombre = nombre;
        }
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        if(validarPositivo(edad)){
            this.edad = edad;
        }
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        if(validarPositivo(estatura)){
            this.estatura = estatura;
        }
    }
    
    
    // para evitar codigo duplicado crearemos estas dos funciones
    private boolean validarNombre(String nombre){
       return !nombre.isEmpty() //Si no se ha inicio o esta vacia 
              && !nombre.isBlank(); //
    }
    
    private boolean validarPositivo(double numero){
       return numero > 0;
    }
    
    
}
