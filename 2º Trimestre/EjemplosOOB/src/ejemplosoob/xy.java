package ejemplosoob;

public class xy {
    private int x,y;
    public xy(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public xy(int v){
        this(v,v);
    }
    
    public xy(){ //contrusctor por defecto
        this(0,0);
    }
    
    public xy(xy p){ //contructor copia
        this.x = p.x;
        this.y = p.y;
      //this(p.x,p.y);
    }

    
    //en principio no habra que validar los set por que los ùntos x e y pueden ser valores negativos.
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
