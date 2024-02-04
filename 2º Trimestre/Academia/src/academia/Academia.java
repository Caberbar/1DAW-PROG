package academia;

public class Academia {

    public static void main(String[] args) {
        Asignatura a1 = new Asignatura("Lengua",4);
        Asignatura a2 = new Asignatura(a1);
        Asignatura a3 = new Asignatura("Matem�ticas",8);
        
        a3.setNombre("Ciencias");
        a1.setHoras(6);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        
        System.out.println(a1.equals(a2));
        
        //Estudiante e1 = new Estudiante("Manuel","Martin","Acosta");
        //System.out.println(e1);
    }
    
}