
package figuras;


public class Triangulo extends Figura {

    private double base;
    private double altura;
    
    public Triangulo(){
        
    }
    public Triangulo(double base, double altura){
        if(base<=0){
            throw new IllegalArgumentException("La base debe ser positiva");
        }
        if(altura<=0){
            throw new IllegalArgumentException("La altura debe ser positiva");
        }
        
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double area() {

        return (this.base*this.altura)/2;
    }

    public final double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        
        if( !(obj instanceof Triangulo)) return false;
        
        Triangulo t = (Triangulo) obj;
        if(this.altura == t.altura && this.base == t.base){
            return true;
        }else 
            return false;
 
    }

    @Override
    public void arrancar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
