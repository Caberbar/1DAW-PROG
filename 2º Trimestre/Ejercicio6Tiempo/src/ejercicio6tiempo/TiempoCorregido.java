package ejercicio6tiempo;

public class TiempoCorregido {
    private int segundos;
    private int minutos;
    private int horas;
    private int total;

    public TiempoCorregido(int horas, int minutos, int segundos) {
        validarParametros(horas, minutos, segundos);
        
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    public TiempoCorregido(TiempoCorregido t) {
        this(t.horas,t.minutos,t.segundos);
    }
    
    public void suma(TiempoCorregido t){
        suma(t.horas,t.minutos,t.segundos);
    }
    
    public void suma(int horas, int minutos, int segundos){
        validarParametros(horas, minutos, segundos);
        int segundosTotales = segundosTotales(this.horas,this.minutos,this.segundos);
        segundosTotales += segundosTotales(horas,minutos,segundos);
        
        int [] desglose = desglosarSegundos(segundosTotales);
        this.horas = desglose[0];
        this.minutos = desglose[1];
        this.segundos = desglose[2];
        
    }
    
    public void resta(TiempoCorregido t){
        resta(t.horas,t.minutos,t.segundos);
    }
    
    public void resta(int horas, int minutos, int segundos){
        validarParametros(horas, minutos, segundos);
        int segundosTotales = segundosTotales(this.horas,this.minutos,this.segundos);
        segundosTotales -= segundosTotales(horas,minutos,segundos);
        
        if(segundosTotales>0){
        int [] desglose = desglosarSegundos(segundosTotales);
        this.horas = desglose[0];
        this.minutos = desglose[1];
        this.segundos = desglose[2];
        }else{
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
        }
        
    }

    private void validarParametros(int horas1, int minutos1, int segundos1) throws IllegalArgumentException {
        if (!validarHoras(horas1)) {
            throw new IllegalArgumentException("Las horas deben ser positivas");
        }
        if (!validarMinutosSegundos(minutos1)) {
            throw new IllegalArgumentException("Los minutos deben estar entre 0 y 59");
        }
        if (!validarMinutosSegundos(segundos1)) {
            throw new IllegalArgumentException("Los segundos deben estar entre 0 y 59");
        }
    }
    
    private boolean validarHoras(int horas) {
        return horas >= 0;
    }

    private boolean validarMinutosSegundos(int numero) {
        return (numero>=0 && numero<60);
    }
    
    @Override
    public String toString() {
        return  horas + "h " + minutos + "m " + segundos + "s";
    }

    private int segundosTotales(int horas, int minutos, int segundos) {
        return horas*3600 + minutos*60 + segundos;
    }
    
    private int [] desglosarSegundos(int segundos){
        int [] tiempoDesglosado = new int[3];
        
        tiempoDesglosado[0] = segundos /3600;
        segundos = segundos % 3600;
        tiempoDesglosado[1] = segundos /60;
        tiempoDesglosado[2] = segundos % 60;
        
        return tiempoDesglosado;
    }
    
}
