package proyectopizza;

public class Pizza {
    private static int totalPedidas;
    private static int totalServidas;
    
    private String tipo;
    private String tamaño;
    private String estado;

    static{
        totalPedidas=0;
        totalServidas=0;
    }
    
    public Pizza(String tipo, String tamaño) {
        if (!validarTipo(tipo)) {
            throw new IllegalArgumentException("No existe ese tipo de pizza");
        }
        if (!validarTamaño(tamaño)) {
            throw new IllegalArgumentException("No existe ese tamaño");
        }
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.estado = "pedida";
        
        Pizza.totalPedidas++;
    }
    
    public void sirve(){
        if(!this.estado.equals("servida")){
            this.estado = "servida";
            Pizza.totalServidas++;
        }else{
            System.out.println("La pizza ya se ha servido");
        }
    }

    @Override
    public String toString() {
        return "Pizza " + tipo +" "+ tamaño + ", " + estado;
    }

    
    
    public static int getTotalPedidas(){
        return Pizza.totalPedidas;
    }
    
    public static int getTotalServidas(){
        return Pizza.totalServidas;
    }
    
    
    private boolean validarTipo(String tipo) {
        return (tipo.equals("margarita") || tipo.equals("cuatro quesos") || tipo.equals("funghi"));
    }

    private boolean validarTamaño(String tamaño) {
        return (tamaño.equals("mediana") || tamaño.equals("familiar"));
    }

}
