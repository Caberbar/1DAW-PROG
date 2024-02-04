public class Rectángulo {
    
   private int alto, ancho;
   
   public void setAlto (int alto){
       if(alto>0){
           this.alto=alto;
       }
   }
   public int getAlto(){
       return this.alto;
   }
   
   public void setAncho (int ancho){
       if(ancho>0){
           this.ancho=ancho;
       }
   }
   public int getAncho(){
       return this.ancho;
   }
}
