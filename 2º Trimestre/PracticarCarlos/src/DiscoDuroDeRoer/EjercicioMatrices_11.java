package DiscoDuroDeRoer;

//Queremos realizar una encuesta a 10 personas, en esta encuesta indicaremos el sexo (1=masculino, 2=femenino), si trabaja (1=si trabaja, 2= no trabaja) y su sueldo (si tiene un trabajo, sino sera un cero) estará entre 600 y 2000 (valor entero). Los valores pueden ser generados aleatoriamente. Calcula y muestra lo siguiente:
//
//Porcentaje de hombres (tengan o no trabajo).
//Porcentaje de mujeres (tengan o no trabajo).
//Porcentaje de hombres que trabajan.
//Porcentaje de mujeres que trabajan.
//El sueldo promedio de las hombres que trabajan.
//EL sueldo promedio de las mujeres que trabajan.
//Usa todos los métodos que veas necesarios, piensa que es aquello que se repite o que puede ser mejor tenerlo por separado.

public class EjercicioMatrices_11 {

    public static void main(String[] args) {
 
        final int ENCUESTADOS=10;
 
        //Creamos la tabla de la Encuesta, no importa si es de 3x20 o 20x3
        int lista[][]=new int [3][ENCUESTADOS];
 
        //Rellenamos la tabla
        rellenoSexo(lista);
        rellenoTrabajo(lista);
        rellenoSueldo(lista);
 
        //Mostramos la tabla, es opcional mostrarla
        imprimirArray(lista);
 
        //Mostramos los datos
        System.out.println("Hay un "+porcHombresMujeres(lista, 1)+" % de hombres");
        System.out.println("Hay un "+porcHombresMujeres(lista, 2)+" % de mujeres");
 
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 1, 1)+" % de hombres que trabajan");
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 2, 1)+" % de mujeres que trabajan");
 
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 1, 2)+" % de hombres que no tiene trabajo");
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 2, 2)+" % de mujeres que no tiene trabajo");
 
        System.out.println("El sueldo medio es de "+promedioSueldo(lista, 1, 1));
        System.out.println("El sueldo medio es de "+promedioSueldo(lista, 2, 1));
 
    }
    
    public static void rellenoSexo (int lista[][]){
        for (int i=0;i<lista[0].length;i++){
            int numero=(int)Math.floor(Math.random()*2+1);
            lista[0][i]=numero;
        }
    }
    
    public static void rellenoTrabajo (int lista[][]){
        for (int i=0;i<lista[1].length;i++){
            int numero=(int)Math.floor(Math.random()*2+1);
            lista[1][i]=numero;
        }
    }
    public static void rellenoSueldo (int lista[][]){
        for (int i=0;i<lista[1].length;i++){
            for (int j=0;j<lista[2].length;j++){
                if (lista[1][j]==2){
                    lista[2][j]=0;
                }else{
                    int numero=(int)Math.floor(Math.random()*1000+500);
                    lista[2][j]=numero;
                }
            }
 
        }
    }
 
    public static void imprimirArray (int lista[][]){
        //Esto solo es cuestion de estetica
        String datoEncuesta[]={"Sexo", "Trabajo", "Sueldo"};
        for (int i=0;i<lista.length;i++){
            System.out.println(datoEncuesta[i]);
            for (int j=0;j<lista[i].length;j++){
                System.out.println("En la fila " +i+" y columna " +j+ " tiene " +lista[i][j]);
            }
 
        }
    }
    public static double porcHombresMujeres (int lista[][], int sexo){
        int contador=0;
        for(int i=0;i<lista[0].length;i++){
            if (lista[0][i]==sexo){
                contador+=1;
            }
        }
        double porcentaje=(contador*100)/lista[0].length;
        return porcentaje;
    }
    public static double porcHombresMujeresTrabajo (int lista[][], int sexo, int trabajo){
        int contador=0;
        double porcentaje_sexo=0;
        double porcentaje=0;
        for(int i=0;i<lista[0].length;i++){
                if (lista[0][i]==sexo & lista[1][i]==trabajo){
                    contador+=1;
                }
        }
        if(sexo==1){
            porcentaje_sexo=porcHombresMujeres(lista, 1);
            porcentaje=(contador*100)/(porcentaje_sexo/10);
        }else{
            porcentaje_sexo=porcHombresMujeres(lista, 2);
            porcentaje=(contador*100)/(porcentaje_sexo/10);
        }
 
        return porcentaje;
    }
    public static double promedioSueldo(int lista[][], int sexo, int trabajo){
        int contador=0;
        double suma=0;
        double promedio=0;
        for(int i=0;i<lista[0].length;i++){
                if (lista[0][i]==sexo & lista[1][i]==trabajo & lista[2][i]!=0){
                    suma+=lista[2][i];
                    contador+=1;
                }
        }
        promedio=suma/contador;
        return promedio;
    }
}
