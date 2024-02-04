package Aplicacion;

import java.util.Collections;
import java.util.Scanner;

/**
 * Esta clase se encargara de la manipulación de los objetos de las demas
 * clases. Es una versión inicial de un proyecto para Programación Orientada a
 * Objetos.
 *
 * El programa principal se encarga de gestionar la solicitud de datos al
 * usuario y la creación de los objetos en un array de objetos "TarjetaCredito".
 * Se comprueba en todo momento que no se supera el límite de creación de
 * tarjetas de crédito y se avisa al usuario en caso de que deseé crear una
 * nueva tarjeta de crédito y que no haya más espacio.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class AplicacionTarjetasCredito {

    static Scanner teclado = new Scanner(System.in);

    /**
     * Inicia el programa. El main se encarga de crear inicialmente un array de
     * 10 elementos de capacidad vacio. También se encarga de iniciar un
     * contador que llevará la cuenta de las tarjetas que están creadas. Además
     * de llamar a la función "menu" donde se encuentra el resto de la
     * aplicación.
     *
     * @param args
     */
    public static void main(String[] args) {
        TarjetaCredito[] tarjetas = new TarjetaCredito[10]; //crea array de tarjetas
        TarjetaCredito tarjeta1 = new TarjetaCredito("Carlos Bernal Barrionuevo", "77969117Z", "1478", 1000, "4013898552945887");
        TarjetaCredito tarjeta2 = new TarjetaCredito("Carlos Bernal Barrionuevo", "92284913N", "1478", 1000, "5545685986377595");
        //TarjetaCredito tarjeta3 = new TarjetaCredito("Carlos Bernal Barrionuevo", "94421953F", "1478", 1000, "5547319274753188");
        tarjetas[9] = tarjeta1;
        tarjetas[8] = tarjeta2;
        //tarjetas[7] = tarjeta3;
        tarjetas[9].pagar(500, "perro");
        tarjetas[9].pagar(200, "gatos");
        int numTarjetas = 2;// contador de tarjetas
        menuPrincipal(tarjetas, numTarjetas); //llamada al menú principal
    }

    /**
     * Muestra un menu por pantalla. Explicación de las distintas opciones. 1.-
     * Crear una tarjeta de crédito. Comprueba que haya espacio en el array
     * antes de poder crear nada. En caso de haber espacio llamará a la función
     * "crearTarjeta" que recibirá por parámetro el array de tarjetas y el
     * contador de tarjetas, además de un contador que suma cuando de sea una
     * tarjeta. 2.- Eliminar tarjeta de crédito. Comprueba que haya al menos una
     * tarjeta antes de borrar una tarjeta. En caso de haber tarjetas se llamará
     * a la función "eliminarTarjeta" que recibirá por parámetro el array de
     * tarjetas y el contador de tarjetas, además de un contador que resta cada
     * vez que eliminas una tarjeta. 3.- Gestionar tarjeta de crédito. Llamará a
     * otro sub menú con la función "gestionarTarjeta". Recibirá por parámetro
     * el array de tarjetas y el contador de tarjetas. 4.- Consultar gastos
     * totales. Comprueba que haya al menos una tarjeta antes de borrar una
     * tarjeta. En caso de haber tarjetas se llamará a la función
     * "consultarGastosTotales" que recibirá por parámetro el array de tarjetas
     * y el contador de tarjetas. 5.- Salir del programa. Saldra del menú y del
     * programa.
     *
     * @param tarjetas El array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas
     * creadas/eliminadas.
     */
    public static void menuPrincipal(TarjetaCredito[] tarjetas, int numTarjetas) {
        int opcion = 0; //Variable encarga ed guardar el numero de opción.

        System.out.println("--------------------------------------------------------");
        System.out.println("BIENVENID@");
        System.out.println("ELIGE UNA OPCIÓN:");
        System.out.println("--------------------------------------------------------");

        while (opcion != 5) {
            for (int i = 0; i < 10; i++) {
                System.out.println(tarjetas[i]);
            }
            System.out.println("");
            System.out.println("1.- Crear tarjeta de crédito.");
            System.out.println("2.- Eliminar tarjeta de crédito.");
            System.out.println("3.- Gestionar tarjeta de crédito.");
            System.out.println("4.- Consultar gastos totales."); //de todas las tarjetas
            System.out.println("5.- Salir del programa.");
            System.out.println("");
            System.out.println("Seleccione una opción: ");
            opcion = Validar.leerIntSinNegConMax(0, 6);
            
            switch (opcion) {
                case 1:
                    if (numTarjetas > 9) {
                        System.out.println("");
                        System.out.println("No hay más espacio para crear mas tarjetas de crédito. \n");
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
                        System.out.println("");
                        System.out.println("El gasto total es: " + consultarGastosTotales(tarjetas, numTarjetas));
                    }
                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opción inválida, por favor seleccione una opción válida.");
            }
        }
    }

    /**
     * Crear objeto tarjeta de crédito.Esta función es la encargada de crear un
 nuevo objeto en el aray que sé le pasa por parámetro, solicitando al
 usuario los datos, en caso de no ser datos válidos los volverá a pedir,
 hasta que meta un dato correcto, una vez validados los datos, cuando se
 esté validando el NIF,NIE,CIF sé llamará a una función llamada
 "exisTarjeta" que recibirá por parámetro el NIF,NIE,CIF, el array de
 tarjetas y el número de tarjetas creadas, para comprobar que no haya
 tarjetas con el mismo NIF,NIE,CIF, cuando sé introduzca el número de la
 tarjeta se llamará a una función llamada "validarNumero" que recibirá por
 parámetro el número de la tarjeta se validará también para que el código
 de control coincida con el resto del número de la tarjeta. Una vez
 validados los datos se creará el objeto Se llamará a una función (si hay
 espacio en el array) que se encargará de solicitar todos los datos al
 usuario y devolverá un objeto que guardará el objeto en la última
 posición libre del array y sé aumentará el contador de tarjetas creadas.
     *
     * @param tarjetas Array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas
     * creadas/eliminadas.
     * @return Devolvera una tarjeta de credito.
     */
    public static TarjetaCredito crearTarjeta(TarjetaCredito[] tarjetas, int numTarjetas) {
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
            if (!Validar.validarLimite(limite)) {
                System.out.println("Límite invalido, introduce un límite entre 500 y 5000 euros: ");
            }
        } while (!Validar.validarLimite(limite));

        do {
            System.out.println("Introduzca el número de la tarjeta: ");
            numero = teclado.next();
            if (!Validar.validarNumero(numero)) {
                System.out.println("Número de la tarjeta incorrecto");
            }
        } while (!Validar.validarNumero(numero));

        System.out.println("");

        TarjetaCredito tarjeta = new TarjetaCredito(nombre, nif, pin, limite, numero);
        System.out.println("La tarjeta se creó correctamente");
        tarjetas[9 - numTarjetas] = tarjeta;
        return tarjetas[numTarjetas];
    }

    /**
     * Comprobar si una tarjeta existe con el mismo NIF/NIE/CIF. Se encargará de
     * recorrer el array de final a principio cogiendo el NIF/NIE/CIF y
     * comparándolo con el escrito por teclado, en caso de haber una tarjeta con
     * el ese mismo NIF/NIE/CIF se pedirá un nuevo NIF/NIE/CIF hasta que sea
     * distinto, cuando sea distinto volverá a la función "crearTarjeta" para
     * seguir creando el objeto.
     *
     * @param tarjetas Array creado anteriormente.
     * @param nif Valor escrito por teclado haciendo referencia a NIF/NIE/CIF.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas
     * creadas/eliminadas.
     * @return Devolverá true cuando sea un NIF/NIE/CIF distinto.
     */
    private static String exisTarjeta(TarjetaCredito[] tarjetas, String nif, int numTarjetas) {
        boolean esValido = false;
        String nuevo = nif;
        if (numTarjetas > 0) {
            while (esValido != true) {
                for (int i = 9; i >= 10 - numTarjetas; i--) {
                    if (tarjetas[i].getNif().equals(nif)) {
                        do {
                            System.out.println("Ya existe una tarjeta de crédito para el NIF " + nif);
                            do {
                                System.out.println("Introduzca una identificación nueva:  ");
                                nif = teclado.next();
                            } while (!Validar.validarNIE(nif));
                        } while (buscarTarjeta(tarjetas,nif) != -1);
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
     * Buscar un objeto tarjeta de crédito dentro del array. Se encargará de
     * recorrer el array buscando una tarjeta con NIF/NIE/CIF igual al escrito
     * por teclado pasado por parámetro, una vez encontrado devolverá la
     * posición.
     *
     * @param tarjetas Array creado anteriormente.
     * @param nif Valor escrito por teclado haciendo referencia a NIF/NIE/CIF.
     * @return Devolverá la posición del objeto Tarjeta dentro del Array.
     */
    public static int buscarTarjeta(TarjetaCredito[] tarjetas, String nif) {

        for (int posicion = 0; posicion < tarjetas.length; posicion++) {
            if (tarjetas[posicion] != null && tarjetas[posicion].getNif().equals(nif)) {
                return posicion;
            }
        }
        return -1;
    }

    /**
     * Eliminar objeto tarjeta de crédito. Esta función es la encargada de
     * eliminar un objeto en el array que sé le pasa por parámetro, solicitando
     * al usuario solo el NIF,NIE,CIF en caso de no existir ninguna tarjeta con
     * el NIF,NIE,CIF volverá a pedir, hasta que meta un NIF,NIE,CIF que exista
     * en alguna tarjeta una vez validados los datos, se eliminará la tarjeta
     * del array, cuando sé elimine el array se compactará el array, dejando una
     * nueva posición libre.
     *
     * @param tarjetas Array creado anteriormente.
     * @param buscarTarjeta Función que devuelve la posición del objeto dentro
     * del array.
     * @return Devuelve el array con un objeto menos eliminado y compactada.
     */
    public static boolean eliminarTarjeta(TarjetaCredito[] tarjetas, int buscarTarjeta) {
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
            borrarTarjeta(tarjetas, indice);
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
     * Muestra menú de gestión por pantalla. Explicación de las distintas
     * opciones. Pedirá por teclado el NIF,NIE,CIF para buscar el objeto y
     * gestionarlo. 1.- Mostrar el número de tarjeta completo. Mostrará por
     * pantalla el número de la tarjera asociado al NIF,NIE,CIF anterior. 2.-
     * Mostrar el nombre del titular de la tarjeta. Mostrará por pantalla el
     * nombre de la tarjeta de la tarjera asociado al NIF,NIE,CIF anterior. 3.-
     * Mostrar la fecha de caducidad. Mostrará por pantalla la fecha de
     * caducidad de la tarjeta de la tarjera asociado al NIF,NIE,CIF anterior.
     * 4.- Modificar el PIN. Solicitará al usuario un nuevo pin de 4 cifras
     * validado, después llamara a la clase tarjeta y modificara el pin. 5.-
     * Realizar un pago. Solicitará al usuario la cantidad validándola
     * adecuadamente no pasándose del límite y un concepto también validado,
     * después llamará a la función "pagar" de la clase "TarjetaCredito" para
     * realizar el pago. 6.- Consultar movimientos. Pedirá al usuario el número
     * de movimientos que desea ver validándolo para que solo pueda poner un
     * número en el rango de movimientos que tiene el objeto, después llamara a
     * la función "movimientos" de la clase "TarjetaCredito" que a su vez
     * llamara a la clase "Movimientos, para enseñar los movimientos por
     * pantalla. 6.- Consultar gasto total. Mostrará por pantalla el gasto total
     * que lleva el objeto llamando a la función "gastado de la clase
     * "TarjetaCredito". 7.- Volver al menú principal. Saldrá del menú y volverá
     * al menú principal
     *
     * @param tarjetas Array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas
     * creadas/eliminadas.
     */
    public static void gestionarTarjeta(TarjetaCredito[] tarjetas, int numTarjetas) {
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
                System.out.println("1.- Mostrar el número de tarjeta completo.");
                System.out.println("2.- Mostrar el nombre del titular de la tarjeta.");
                System.out.println("3.- Mostrar la fecha de caducidad.");
                System.out.println("4.- Modificar el PIN.");
                System.out.println("5.- Realizar un pago.");
                System.out.println("6.- Consultar movimientos.");
                System.out.println("7.- Consultar gasto total.");
                System.out.println("8.- Volver al menú principal.");
                System.out.println("");
                System.out.println("Seleccione una opción: ");
                opcion = Validar.leerIntSinNegConMax(0, 9);

                switch (opcion) {
                    case 1:
                        System.out.println(tarjetas[posicion].getNumero());
                        break;
                    case 2:
                        System.out.println(tarjetas[posicion].getNombre());
                        break;
                    case 3:
                        System.out.println(tarjetas[posicion].getMes() + "-" + tarjetas[posicion].getAño());
                        break;
                    case 4:
                        do {
                            System.out.println("Introduzca el nuevo PIN: "); //Validado
                            pin = teclado.nextLine();
                            if (!Validar.validarPin(pin)) {
                                System.out.println("PIN invalido, introduce un PIN de 4 cifras: ");
                            }
                        } while (!Validar.validarPin(pin));
                        tarjetas[posicion].setPin(pin);
                        System.out.println("El PIN se ha cambiado perfectamente");
                        break;
                    case 5:
                        double cantidad;
                        System.out.println("Introduza el valor a pagar: ");
                        cantidad = Validar.leerIntSinNegConMax(0, tarjetas[posicion].getLimite() + 1);
                        do {
                            System.out.println("Introduza el concepto del pago: "); //Validado
                            concepto = teclado.nextLine();
                            if (!Validar.validarConcepto(concepto, 51)) {
                                System.out.println("Debes introducir un concepto valido (5-50 caracteres): ");
                            }
                        } while (!Validar.validarConcepto(concepto, 50));
                        if (tarjetas[posicion].pagar(cantidad, concepto)) {
                            tarjetas[posicion].pagar(cantidad, concepto);
                            System.out.println("\nEl pago se ha efectuado correctamente.");
                        }else{
                            System.out.println("\nEl pago no se ha efectuado correctamente.");
                        }
                        tarjetas[posicion].pagar(cantidad, concepto);
                        break;
                    case 6:
                        System.out.println("Introduzca el numero de movimientos que desea ver: ");
                        if (tarjetas[posicion].numeroMovimientos() == 0) {
                            System.out.println("No hay movientos para esta tarjeta");
                        } else {
                            System.out.println(tarjetas[posicion].getNombre() + " tienes un total de " + tarjetas[posicion].numeroMovimientos() + " movimiento/s.");
                            int numero = Validar.leerIntSinNegConMax(0, tarjetas[posicion].numeroMovimientos() + 1);
                            System.out.println(tarjetas[posicion].movimientos(numero) + "\n");
                        }
                        break;
                    case 7:
                        System.out.println("El gasto total es: " + tarjetas[posicion].gastado());
                        break;
                    case 8:
                        System.out.println("Volviendo al menu principal. ");
                        break;
                    default:
                        System.out.println("Opción inválida, por favor seleccione una opción válida.");
                }
            }
        } else {
            System.out.println("No se ha encontrado la tarjeta con el NIF proporcionado.");
        }

    }

    /**
     * Calcular el gasto total del Array. Esta función recorre el array sumando
     * los gasto de cada uno del objeto consecutivamente, una vez sumado,
     * muestra por pantalla el gasto total que hay entre todas las tarjetas del
     * Array.
     *
     * @param tarjetas Array creado anteriormente.
     * @param numTarjetas Contador que lleva la cuenta de las tarjetas
     * creadas/eliminadas.
     * @return Devuelve el gasto total de todas las tarjetas del Array.
     */
    public static double consultarGastosTotales(TarjetaCredito[] tarjetas, int numTarjetas) {
        double gastos = 0;
        for (int i = 9; i > 9 - numTarjetas; i--) {
            gastos += tarjetas[i].gastado();
        }
        return gastos;
    }

    private static void borrarTarjeta(TarjetaCredito[] tarjetas, int indice) {
        for (int i = indice; i > 0; i--) {
            tarjetas[i] = tarjetas[i - 1];
        }
        tarjetas[0] = null;
    }
}
