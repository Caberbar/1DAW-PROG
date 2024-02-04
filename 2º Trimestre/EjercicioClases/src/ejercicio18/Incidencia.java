package ejercicio18;

public class Incidencia {
    private static int numero;
    private static int pendientes;
    
    private int codigo;
    private String estado;
    private String fallo;
    private String solucion;
    private int puesto;
    
    static{
        numero = 1;
    }

    public Incidencia(int puesto, String fallo) {
        this.fallo = fallo;
        this.puesto = puesto;
        this.estado = "Pendiente";
        Incidencia.pendientes++;
        this.codigo = Incidencia.numero++;
    }

    public String resuelve(String solucion) {
        this.estado = "Resuelta";
        Incidencia.pendientes -= 1;
        return this.solucion = solucion;
    }

    public static int getPendientes() {
        return Incidencia.pendientes;
    }

    @Override
    public String toString() {
        if (this.estado.equals("Resuelta")){
            return "Incidencia " + codigo +" - Puesto: "+ puesto + " - "+ fallo +" - "+ estado + " - " + solucion;
        }else{
            return "Incidencia " + codigo +" - Puesto: "+ puesto + " - "+ fallo +" - "+ estado;
        }
    }
    
    
}
