package ejercicio6tiempo;

public class Tiempo {
    private int segundos;
    private int minutos;
    private int horas;
    private int total;

    public Tiempo(int horas, int minutos, int segundos) {
        if(!validarTiempo(segundos)){
            throw new IllegalArgumentException("Dato incorrecto");
        }
        if(!validarTiempo(minutos)){
            throw new IllegalArgumentException("Dato incorrecto");
        }
        
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    public Tiempo(Tiempo t) {
        this(t.horas,t.minutos,t.segundos);
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    
    public void suma(int horas, int minutos, int segundos){
        if(segundos >= 60){
            this.segundos = segundos - this.segundos;
            this.minutos = this.minutos + 1;
        }else{
            if(this.segundos + segundos >= 60 && this.segundos >= segundos){
                this.segundos = this.segundos - segundos;
                this.minutos = this.minutos + 1;
            }else{
                this.segundos = segundos - this.segundos;
                this.minutos = this.minutos + 1;
            }
        }
            
        if (minutos >= 60){
            this.minutos = minutos - this.minutos;
            this.horas = this.horas + 1;
        }else{
            this.minutos = minutos + this.minutos;
        }
        this.horas = horas + this.horas;
    }
    
    public void resta(int horas, int minutos, int segundos){
        if (segundos < 60) {
            this.segundos = segundos - this.segundos;
            this.minutos = this.minutos + 1;
        }else{
            this.segundos = segundos + this.segundos;
        }
        if (minutos >60){
            this.minutos = minutos - this.minutos;
            this.horas = this.horas + 1;
        }else{
            this.minutos = minutos + this.minutos;
        }
        this.horas = horas + this.horas;
    }
    
    @Override
    public String toString() {
        return "Tiempo" + "horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos;
    }

    private boolean validarTiempo(int numero) {
        return (numero>=0 || numero<60);
    }
}
