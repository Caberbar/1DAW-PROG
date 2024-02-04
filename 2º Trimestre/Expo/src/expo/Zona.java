package expo;

public class Zona {

    private int entradasPorVender; //atributos

    public Zona(int n) { //constructor
        entradasPorVender = n;
    }

    public int getEntradasPorVender() { //geter y seter
        return entradasPorVender;
    }
  
    public void vender(int n) { //metodo
        if (this.entradasPorVender == 0) {
            System.out.println("Lo siento, las entradas para esa zona están agotadas.");
        } else if (this.entradasPorVender < n) {
            System.out.println("Sólo me quedan " + this.entradasPorVender
                    + " entradas para esa zona.");
        }
        if (this.entradasPorVender >= n) {
            entradasPorVender -= n;
            System.out.println("Aquí tiene sus " + n + " entradas, gracias.");
        }
    }

}
