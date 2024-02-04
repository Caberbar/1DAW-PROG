package figurasgeometricas;

public class Triangulo extends Figura {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        if(base<=0){
            throw new IllegalArgumentException("La base debe ser positiva");
        }
        if(altura<=0){
            throw new IllegalArgumentException("La base debe ser positiva");
        }
        this.base = base;
        this.altura = altura;
    }

    public Triangulo() {
        this(0, 0);
    }

    @Override
    public double area() {
        return (this.base * this.altura)/2;
    }

    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }
}
