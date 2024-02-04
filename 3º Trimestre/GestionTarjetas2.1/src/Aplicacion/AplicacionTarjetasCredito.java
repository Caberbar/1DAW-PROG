package Aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Esta clase se encargara de la manipulaci�n de los objetos de las demas clases.
 * Es una versi�n inicial de un proyecto para Programaci�n Orientada a Objetos.
 * 
 * El programa principal se encarga de gestionar la solicitud de datos al
 * usuario y la creaci�n de los objetos en un array de objetos "TarjetaCredito".
 * Se comprueba en todo momento que no se supera el l�mite de creaci�n de
 * tarjetas de cr�dito y se avisa al usuario en caso de que dese� crear una
 * nueva tarjeta de cr�dito y que no haya m�s espacio.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class AplicacionTarjetasCredito {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<TarjetaCredito> tarjetas;
    /**
     * Inicia el programa. 
     * El main se encarga de crear inicialmente un array de 10 elementos de 
     * capacidad vacio. Tambi�n se encarga de iniciar un contador que llevar� 
     * la cuenta de las tarjetas que est�n creadas. Adem�s de llamar a la 
     * funci�n "menu" donde se encuentra el resto de la aplicaci�n.
     *
     * @param args
     */
    public static void main(String[] args) {
        //TarjetaCredito[] tarjetas = new TarjetaCredito[10]; //crea array de tarjetas
        int numTarjetas = 1;// contador de tarjetas
        TarjetaCredito tarjeta = new TarjetaCredito("Carlos Bernal Barrionuevo","77969117Z","1458",3000,"4013554964220399");
        //tarjetas.add(tarjeta);
        //tarjetas[9] = new TarjetaCredito("Carlos Bernal Barrionuevo","77969117Z","1458",3000,"4013554964220399");
//        tarjetas.get(1).pagar(500, "Primer pago");
//        tarjetas.get(1).pagar(200, "Segundo pago");
//        tarjetas.get(1).pagar(1000, "Tercer pago");
//        tarjetas.get(1).pagar(100, "Cuarto pago");
        //System.out.println(tarjetas[9].movimientos(2));
        for (int i = 0; i < 1; i++) {
            System.out.println(tarjeta);
            //System.out.println(tarjetas.get(i));
        }
        //menuPrincipal(tarjetas, numTarjetas); //llamada al men� principal
    }
    
    /**
     * Muestra un menu por pantalla. 
     * Explicaci�n de las distintas opciones. 
     * 1.- Crear una tarjeta de cr�dito. Comprueba que haya espacio en el array
     * antes de poder crear nada. En caso de haber espacio llamar� a la funci�n
     * "crearTarjeta" que recibir� por par�metro el array de tarjetas y el
     * contador de tarjetas, adem�s de un contador que suma cuando de sea una
     * tarjeta. 
     * 2.- Eliminar tarjeta de cr�dito. Comprueba que haya al menos una
     * tarjeta antes de borrar una tarjeta. En caso de haber tarjetas se llamar�
     * a la funci�n "eliminarTarjeta" que recibir� por par�metro el array de
     * tarjetas y el contador de tarjetas, adem�s de un contador que resta cada
     * vez que eliminas una tarjeta.
     * 3.- Gestionar tarjeta de cr�dito. Llamar� a otro sub men� con la funci�n
     * "gestionarTarjeta". Recibir� por par�metro el array de tarjetas y el 
     * contador de tarjetas.
     * 4.- Consultar gastos totales. Comprueba que haya al menos una
     * tarjeta antes de borrar una tarjeta. En caso de haber tarjetas se llamar�
     * a la funci�n "consultarGastosTotales" que recibir� por par�metro el array 
     * de tarjetas y el contador de tarjetas.
     * 5.- Salir del programa. Saldra del men� y del programa.
     *
     * @param tarjetas El array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas creadas/eliminadas. 
     */
    public static void menuPrincipal(ArrayList<TarjetaCredito> tarjetas, int numTarjetas) {
        int opcion = 0; //Variable encarga ed guardar el numero de opci�n.

        System.out.println("--------------------------------------------------------");
        System.out.println("BIENVENID@");
        System.out.println("ELIGE UNA OPCI�N:");
        System.out.println("--------------------------------------------------------");

        while (opcion != 5) {
            System.out.println("");
            System.out.println("1.- Crear tarjeta de cr�dito.");
            System.out.println("2.- Eliminar tarjeta de cr�dito.");
            System.out.println("3.- Gestionar tarjeta de cr�dito.");
            System.out.println("4.- Consultar gastos totales."); //de todas las tarjetas
            System.out.println("5.- Salir del programa.");
            System.out.println("");
            System.out.println("Seleccione una opci�n: ");
            opcion = Validar.leerIntSinNegConMax(0, 6);

            switch (opcion) {
                case 1:
                    if (numTarjetas > 9) {
                        System.out.println("");
                        System.out.println("No hay m�s espacio para crear mas tarjetas de cr�dito. \n");
                    } else {
                        crearTarjeta(tarjetas, numTarjetas);
                        numTarjetas++;
                    }
                    break;
                case 2:
                    if (numTarjetas == 0) {
                        System.out.println("");
                        System.out.println("No existe ninguna tarjeta. \n");
                    } else {
                        eliminarTarjeta(tarjetas, numTarjetas);
                        numTarjetas--;
                    }
                    break;
                case 3:
                    if (numTarjetas == 0) {
                        System.out.println("No existe ninguna tarjeta. \n");
                    } else {
                    gestionarTarjeta(tarjetas, numTarjetas);
                    }
                    break;
                case 4:
                    if (numTarjetas == 0) {
                        System.out.println("No existe ninguna tarjeta. \n");
                    } else {
                    consultarGastosTotales(tarjetas, numTarjetas);
                    }
                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opci�n inv�lida, por favor seleccione una opci�n v�lida.");
            }
        }
    }

    /**
     * Crear objeto tarjeta de cr�dito.
     * Esta funci�n es la encargada de crear un nuevo objeto en el aray que s�
     * le pasa por par�metro, solicitando al usuario los datos, en caso de no 
     * ser datos v�lidos los volver� a pedir, hasta que meta un dato correcto,
     * una vez validados los datos, cuando se est� validando el NIF,NIE,CIF s�
     * llamar� a una funci�n llamada "exisTarjeta" que recibir� por par�metro el
     * NIF,NIE,CIF, el array de tarjetas y el n�mero de tarjetas creadas, para
     * comprobar que no haya tarjetas con el mismo NIF,NIE,CIF, cuando s� 
     * introduzca el n�mero de la tarjeta se llamar� a una funci�n llamada 
     * "validarNumero" que recibir� por par�metro el n�mero de la tarjeta se 
     * validar� tambi�n para que el c�digo de control coincida con el resto del 
     * n�mero de la tarjeta. Una vez validados los datos se crear� el objeto 
     * Se llamar� a una funci�n (si hay espacio en el array) que se encargar� 
     * de solicitar todos los datos al usuario y devolver� un objeto que 
     * guardar� el objeto en la �ltima posici�n libre del array y s� 
     * aumentar� el contador de tarjetas creadas.
     * @param tarjetas Array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas creadas/eliminadas.
     */
    public static void crearTarjeta(ArrayList<TarjetaCredito> tarjetas, int numTarjetas) {
        String nombre, nif, pin, numero;
        int limite;
        do {
            System.out.println("Introduzca el nombre");
            nombre = teclado.nextLine();
        } while (Validar.validarNombre(nombre) != true);

        do {
            System.out.println("Introduzca el NIF: ");
            nif = teclado.next();
            if (!Validar.validarNIE(nif)) {
                System.out.println("NIF invalido, introduzcalo de nuevo: ");
            }
        } while (!Validar.validarNIE(nif));
        nif = exisTarjeta(tarjetas, nif, numTarjetas);

        do {
            System.out.println("Introduzca el PIN: ");
            pin = teclado.next();
            if (!Validar.validarPin(pin)) {
                System.out.println("PIN invalido, introduce un PIN de 4 cifras: ");
            }
        } while (!Validar.validarPin(pin));

        do {
            System.out.println("Introduzca la cantidad ");
            limite = teclado.nextInt();
            if (Validar.validarLimite(limite)) {
                System.out.println("L�mite invalido, introduce un l�mite entre 500 y 5000 euros: ");
            }
        } while (Validar.validarLimite(limite));

        do {
            System.out.println("Introduzca el n�mero de la tarjeta: ");
            numero = teclado.next();
            if (!Validar.validarNumero(numero)) {
                System.out.println("N�mero de la tarjeta incorrecto");
            }
        } while (!Validar.validarNumero(numero));

        System.out.println("");

        TarjetaCredito tarjeta = new TarjetaCredito(nombre, nif, pin, limite, numero);
        System.out.println("La tarjeta se cre� correctamente");
        tarjetas.set(9 - numTarjetas, tarjeta);
    }

    /**
     * Comprobar si una tarjeta existe con el mismo NIF/NIE/CIF.
     * Se encargar� de recorrer el array de final a principio cogiendo el NIF/NIE/CIF 
     * y compar�ndolo con el escrito por teclado, en caso de haber una tarjeta 
     * con el ese mismo NIF/NIE/CIF se pedir� un nuevo NIF/NIE/CIF hasta que sea
     * distinto, cuando sea distinto volver� a la funci�n "crearTarjeta" para 
     * seguir creando el objeto.
     * @param tarjetas Array creado anteriormente.
     * @param nif Valor escrito por teclado haciendo referencia a NIF/NIE/CIF.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas creadas/eliminadas.
     * @return Devolver� true cuando sea un NIF/NIE/CIF distinto.
     */
    private static String exisTarjeta(ArrayList<TarjetaCredito> tarjetas, String nif, int numTarjetas) {
        boolean esValido = false;
        String nuevo = nif;
        if (numTarjetas > 0) {
            while (esValido != true) {
                for (int i = 9; i >= 10 - numTarjetas; i--) {
                    if (tarjetas.get(i).getNif().equals(nif)) {
                        do {
                            System.out.println("Ya existe una tarjeta de cr�dito para el NIF " + nif);
                            do {
                                System.out.println("Introduzca una identificaci�n nueva:  ");
                                nif = teclado.next();
                            } while (!Validar.validarNIE(nif));
                        } while (nuevo.equals(nif));
                        nuevo = nif;
                        esValido = false;
                    } else {
                        esValido = true;
                    }
                }
            }
        }
        return nuevo;
    }

    /**
     * Buscar un objeto tarjeta de cr�dito dentro del array.
     * Se encargar� de recorrer el array buscando una tarjeta con NIF/NIE/CIF
     * igual al escrito por teclado pasado por par�metro, una vez encontrado
     * devolver� la posici�n.
     * @param tarjetas Array creado anteriormente.
     * @param nif Valor escrito por teclado haciendo referencia a NIF/NIE/CIF.
     * @return Devolver� la posici�n del objeto Tarjeta dentro del Array.
     */
    public static int buscarTarjeta(ArrayList<TarjetaCredito> tarjetas, String nif) {

        for (int posicion = 0; posicion < tarjetas.size(); posicion++) {
            if (tarjetas.get(posicion) != null && tarjetas.get(posicion).getNif().equals(nif)) {
                return posicion;
            }
        }
        return -1;
    }

    /**
     * Eliminar objeto tarjeta de cr�dito.
     * Esta funci�n es la encargada de eliminar un objeto en el array que s�
     * le pasa por par�metro, solicitando al usuario solo el NIF,NIE,CIF en caso de no 
     * existir ninguna tarjeta con el NIF,NIE,CIF volver� a pedir, hasta que 
     * meta un NIF,NIE,CIF que exista en alguna tarjeta
     * una vez validados los datos, se eliminar� la tarjeta del array, cuando s�
     * elimine el array se compactar� el array, dejando una nueva posici�n libre.
     * @param tarjetas Array creado anteriormente.
     * @param buscarTarjeta Funci�n que devuelve la posici�n del objeto dentro del array.
     * @return Devuelve el array con un objeto menos eliminado y compactada.
     */
    public static boolean eliminarTarjeta(ArrayList<TarjetaCredito> tarjetas, int buscarTarjeta) {
        String nif;
        boolean esValido = true;
        do {
            System.out.println("Introduzca el NIF: ");
            nif = teclado.next();
            if (!Validar.validarNIE(nif)) {
                System.out.println("NIF invalido, introduzcalo de nuevo: ");
            }
        } while (!Validar.validarNIE(nif));

        int indice = buscarTarjeta(tarjetas, nif);

        if (indice != -1) {
            for (int i = indice; i > 0; i--) {
                tarjetas.set(i, tarjetas.get(i - 1));
            }
            tarjetas.set(0, null);
            System.out.println("");
            System.out.println("La tarjeta ha sido eliminada correctamente.");
            esValido = true;
        } else {
            System.out.println("");
            System.out.println("No se ha encontrado la tarjeta con el NIF proporcionado.");
        }
        return esValido;
    }

    /**
     * Muestra men� de gesti�n por pantalla. 
     * Explicaci�n de las distintas opciones. 
     * Pedir� por teclado el NIF,NIE,CIF para buscar el objeto y gestionarlo.
     * 1.- Mostrar el n�mero de tarjeta completo. Mostrar� por pantalla el
     * n�mero de la tarjera asociado al NIF,NIE,CIF anterior.
     * 2.- Mostrar el nombre del titular de la tarjeta. Mostrar� por pantalla el
     * nombre de la tarjeta de la tarjera asociado al NIF,NIE,CIF anterior.
     * 3.- Mostrar la fecha de caducidad. Mostrar� por pantalla la fecha de 
     * caducidad de la tarjeta de la tarjera asociado al NIF,NIE,CIF anterior.
     * 4.- Modificar el PIN. Solicitar� al usuario un nuevo pin de 4 cifras
     * validado, despu�s llamara a la clase tarjeta y modificara el pin.
     * 5.- Realizar un pago. Solicitar� al usuario la cantidad valid�ndola 
     * adecuadamente no pas�ndose del l�mite y un concepto tambi�n validado, 
     * despu�s llamar� a la funci�n "pagar" de la clase "TarjetaCredito" 
     * para realizar el pago.
     * 6.- Consultar movimientos. Pedir� al usuario el n�mero de movimientos que 
     * desea ver valid�ndolo para que solo pueda poner un n�mero en el rango de 
     * movimientos que tiene el objeto, despu�s llamara a la funci�n 
     * "movimientos" de la clase "TarjetaCredito" que a su vez llamara a la 
     * clase "Movimientos, para ense�ar los movimientos por pantalla.
     * 6.- Consultar gasto total. Mostrar� por pantalla el gasto total que lleva
     * el objeto llamando a la funci�n "gastado de la clase "TarjetaCredito".
     * 7.- Volver al men� principal. Saldr� del men� y volver� al men� principal
     * @param tarjetas Array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas creadas/eliminadas.
     */
    public static void gestionarTarjeta(ArrayList<TarjetaCredito> tarjetas, int numTarjetas) {
        String nif, pin, concepto;
        do {
            System.out.println("Introduzca el NIF: "); //Validado
            nif = teclado.next();
            if (!Validar.validarNIE(nif)) {
                System.out.println("NIF invalido, introduzcalo de nuevo: ");
            }
        } while (!Validar.validarNIE(nif));

        int posicion = buscarTarjeta(tarjetas, nif);
        int opcion = 0;

        if (posicion != -1) {
            while (opcion != 8) {
                System.out.println("");
                System.out.println("1.- Mostrar el n�mero de tarjeta completo.");
                System.out.println("2.- Mostrar el nombre del titular de la tarjeta.");
                System.out.println("3.- Mostrar la fecha de caducidad.");
                System.out.println("4.- Modificar el PIN.");
                System.out.println("5.- Realizar un pago.");
                System.out.println("6.- Consultar movimientos.");
                System.out.println("7.- Consultar gasto total.");
                System.out.println("8.- Volver al men� principal.");
                System.out.println("");
                System.out.println("Seleccione una opci�n: ");
                opcion = Validar.leerIntSinNegConMax(0, 9);

                switch (opcion) {
                    case 1:
                        System.out.println(tarjetas.get(posicion).getNumero());
                        break;
                    case 2:
                        System.out.println(tarjetas.get(posicion).getNombre());
                        break;
                    case 3:
                        System.out.println(tarjetas.get(posicion).getMes() + "-" + tarjetas.get(posicion).getA�o());
                        break;
                    case 4:
                        do {
                            System.out.println("Introduzca el nuevo PIN: "); //Validado
                            pin = teclado.next();
                            if (!Validar.validarPin(pin)) {
                                System.out.println("PIN invalido, introduce un PIN de 4 cifras: ");
                            }
                        } while (!Validar.validarPin(pin));
                        tarjetas.get(posicion).setPin(pin);
                        System.out.println("El PIN se ha cambiado perfectamente");
                        break;
                    case 5:
                        double cantidad;
                        System.out.println("Introduza el valor a pagar: ");
                        cantidad = Validar.leerIntSinNegConMax(0, tarjetas.get(posicion).getLimite() + 1);
                        do {
                            System.out.println("Introduza el concepto del pago: "); //Validado
                            concepto = teclado.next();
                            if (Validar.validarConcepto(concepto, 51)) {
                                System.out.println("Debes introducir un concepto valido (5-50 caracteres): ");
                            }
                        } while (Validar.validarConcepto(concepto, 50));
                        tarjetas.get(posicion).pagar(cantidad, concepto);
                        break;
                    case 6:
                        System.out.println("Introduzca el numero de movimientos que desea ver: ");
                        if (tarjetas.get(posicion).numeroMovimientos() == 0) {
                            System.out.println("No hay movientos para esta tarjeta");
                        } else {
                            System.out.println(tarjetas.get(posicion).getNombre() + " tienes un total de " + tarjetas.get(posicion).numeroMovimientos() + " movimiento/s.");
                            int numero = Validar.leerIntSinNegConMax(0, tarjetas.get(posicion).numeroMovimientos() + 1);
                            System.out.println("�Quieres los movimientos ordenados?");
                            String opcion1 = teclado.next();
                            if(opcion1.equals("Si")){
                                System.out.println("Entro");
                                System.out.println(tarjetas.get(posicion).movimientos(numero));
                            }else{
                                System.out.println("No entro");
                                System.out.println(tarjetas.get(posicion).movimientos(numero-1));
                            }
                        }
                        break;
                    case 7:
                        System.out.println("El gasto total es: " + tarjetas.get(posicion).gastado());
                        break;
                    case 8:
                        System.out.println("Volviendo al menu principal. ");
                        break;
                    default:
                        System.out.println("Opci�n inv�lida, por favor seleccione una opci�n v�lida.");
                }
            }
        } else {
            System.out.println("No se ha encontrado la tarjeta con el NIF proporcionado.");
        }

    }

    /**
     * Calcular el gasto total del Array.
     * Esta funci�n recorre el array sumando los gasto de cada uno del objeto 
     * consecutivamente, una vez sumado, muestra por pantalla el gasto total que
     * hay entre todas las tarjetas del Array.
     * @param tarjetas Array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas creadas/eliminadas.
     * @return Devuelve el gasto total de todas las tarjetas del Array.
     */
    public static double consultarGastosTotales(ArrayList<TarjetaCredito> tarjetas, int numTarjetas) {
        double gastos = 0;
        for (int i = 9; i > 9 - numTarjetas; i--) {
            gastos += tarjetas.get(i).gastado();
        }
        System.out.println("");
        System.out.println("El gasto total es: " + gastos);
        return gastos;
    }
}
