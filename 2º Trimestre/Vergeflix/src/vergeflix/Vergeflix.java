package vergeflix;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import static vergeflix.Validar.*;

/**
 * Esta clase se encargara de la manipulación de los objetos de las demas
 * clases. Es una versión inicial de un proyecto para Programación Orientada a
 * Objetos.
 *
 * El programa principal se encarga de gestionar la solicitud de datos al
 * usuario y la creación de los objetos en un ArrayList de catalogo. Se
 * comprueba en todo momento los datos pasados por parametro.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class Vergeflix {

    /**
     * Inicia el programa. El main se encarga de crear inicialmente un ArrayList
     * catalogo donde a traves de una función se generara objetos Peliculas y
     * Series por defecto. Ademas iniciara el menu Principal y pedira al
     * ususario una de las opciones y llamara a una funcion que contendra un
     * submenu.
     *
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<Media> catalogo = GeneradorPelisSeries.generarPelisSeries();
        int opcion = 0;
        System.out.println("--------------------------------------");
        System.out.println("\tBIENVENIDO A VERGEFLIX");
        System.out.println("--------------------------------------");
        System.out.println();

        while (opcion != 4) {
            imprimirMenuPrincipal();
            System.out.print("Escoga una opción: ");
            opcion = leerIntSinNegConMax(0, 5);
            imprimirSubMenus(opcion, catalogo);

        }
    }

    /**
     * Muestra el menu por pantalla.
     *
     * Mostrará por pantalla las diferentes opciones que puede elegir el
     * usuario.
     *
     */
    public static void imprimirMenuPrincipal() {
        System.out.println("------------------------\n\tMENÚ");
        System.out.println();
        System.out.println("1. Gestionar películas.\n2. Gestionar series.\n3. Consultar catálogo.");
        System.out.println("4. Salir.\n\n-------------------------");
    }

    /**
     * Llamara a las diferentes funciones(opciones).
     *
     * Esta función se encargará de llamar a las diferentes funciones encargadas
     * de realizar las funciones mostradas en los menus.
     *
     * @param opcion //Número que ha elegido el ususario anteriomente.
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     */
    public static void imprimirSubMenus(int opcion, ArrayList<Media> catalogo) {
        switch (opcion) {
            case 1:
                imprimirSubMenuGestionarPelis(catalogo);
                break;
            case 2:
                imprimirSubMenuGestionarSeries(catalogo);
                break;
            case 3:
                imprimirSubMenuConsultarCatalogo(catalogo);
                break;
            case 4:
                System.out.println("------------------------\n\nVUELVA PRONTO :)\n\n-------------------------");
                break;
            default:
                throw new IllegalArgumentException("Esta opción no se encunetra dentro del rango");
        }
    }

    /**
     * Realizara las diferentes opciones sobre Peliculas. Explicación de las
     * diferentes opciones.
     *
     * 1.- Creación de un objeto pelicula, pidiendo al ususario sus debidos
     * datos, siempre validando dichos datos.
     *
     * 2.- Modificación de un objeto pelicula, buscaremos una pelicula dentro
     * del catalogo y muestrara diferentes datos que podemos modificar, los
     * datos nuevos que queremos cambiar estaran validados, una vez modificada
     * la pelicula, se mosrtrará por pantalla.
     *
     * 3.- Eliminación de un objeto pelicula, buscaremos una pelicula dentro del
     * catalogo y procederemos a borrarla
     *
     * 4.- Listaremos por patalla las diferentes peliculas dentro de catalogo.
     *
     * 5.- Votación de una pelicula, buscaremos una pelicula dentro del catalogo
     * y le pediremos al ususario un numero(0-10) debidamente validado para
     * votar a la película.
     *
     * 6.- Volver al menu principal.
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     */
    public static void imprimirSubMenuGestionarPelis(ArrayList<Media> catalogo) {
        Scanner teclado = new Scanner(System.in);
        int opcion, duracion = 0;
        String eleccion, titulo, director, actor, nombre;
        do {
            System.out.println("------------------------\n\nGESTIONAR PELICULAS");
            System.out.println("\n1. Añadir película.\n2. Modificar película.\n3. Eliminar película.\n4. Listar películas.\n5. Valorar película.");
            System.out.println("6. Volver.\n\n-------------------------");

            System.out.print("Escoga una opción: ");
            opcion = leerIntSinNegConMax(0, 7);
            switch (opcion) {
                case 1:
                    System.out.println("-- CREACIÓN DE PELICULA --\n");
                    do {
                        System.out.print("Introduce el titulo: ");
                        titulo = teclado.nextLine();
                        if (buscarPeliEnMedia(catalogo, titulo) != -1) {
                            System.out.println("\n Ya existe una película con este nombre. ");
                        }
                    } while (comprobarNombre(titulo, "titulo") == false || buscarPeliEnMedia(catalogo, titulo) != -1);
                    do {
                        System.out.print("\nIntroduce el nombre del director: ");
                        director = teclado.nextLine();
                    } while (comprobarNombre(director, "director") == false && director.length() < 5);
                    do {
                        System.out.print("\nIntroduce el nombre del actor principal: ");
                        actor = teclado.nextLine();
                    } while (comprobarNombre(actor, "actor") == false && actor.length() < 5);
                    do {
                        System.out.print("\nIntroduce la duración: ");
                        duracion = teclado.nextInt();
                        if (duracion < 60 || duracion > 240) {
                            System.out.println("Debes introducir una duración valida(60-240 mnts).");
                        }
                    } while (duracion < 60 || duracion > 240);
                    System.out.print("\nIntroduce la categoria: ");
                    System.out.println("\n1. Comedia\n2. Drama\n3. Terror\n4. Supense\n5. Ciencia Ficción\n6. Fantasia");
                    System.out.print("|nOpción: ");
                    int categoria = leerIntSinNegConMax(0, 7);
                    System.out.print("\nIntroduce la calificación de edad(0-18): ");
                    int edad = leerIntSinNegConMax(-1, 19);
                    catalogo.add(new Pelicula(titulo, edad, LocalDate.now(), true,director, actor, duracion, Tematica.values()[opcion - 1]));
                    System.out.println("\n La pélicula se creo correctamente. ");
                    System.out.println(peliculasDelCatalogo(catalogo).get(peliculasDelCatalogo(catalogo).size() - 1));
                    break;
                case 2:
                    System.out.println("modificacion");
                    opcion = 0;
                    System.out.println("\n\n¿No recuerda el titulo?\n¿Desea ver las pelis?.\n\nSI.\nNO.");
                    System.out.print("Esriba una opcion: ");
                    eleccion = teclado.nextLine();
                    eleccion = eleccion.toLowerCase();
                    if (eleccion.equals("si")) {
                        System.out.println("------------------------\n\n\nPELICULAS");
                        System.out.println(peliculasDelCatalogo(catalogo));
                        System.out.println("--------------------------\n\n");
                    }
                    do {
                        System.out.print("Introduzaca el título: ");
                        titulo = teclado.nextLine();
                        if (buscarPeliEnMedia(catalogo, titulo) != -1) {
                            System.out.println("\n Ya existe ninguna película con ese nombre.\nPruebe otra vez.");
                        }
                    } while (buscarPeliEnMedia(catalogo, titulo) == -1);

                    System.out.println(catalogo.get(buscarPeliEnMedia(catalogo, titulo)));
                    int posicion = buscarPeliEnMedia(catalogo, titulo);
                    do {
                        System.out.println("");
                        System.out.println("1. Titulo.\n2. Nombre del director.\n3. Nombre del actor principal.");
                        System.out.println("4. Duración.\n5. Categoria.\n6. Calificación de edad.\n7. Disponibilidad.\n8. Volver.");
                        System.out.print("Que desea modificar: ");
                        opcion = leerIntSinNegConMax(0, 9);
                        if (opcion < 9) {
                            switch (opcion) {
                                case 1:
                                    do {
                                        System.out.print("Introduzaca el nuevo título: ");
                                        titulo = teclado.nextLine();
                                        if (buscarPeliEnMedia(catalogo, titulo) != -1) {
                                            System.out.println("\n Ya existe una película con este nombre. ");
                                        }
                                    } while (buscarPeliEnMedia(catalogo, titulo) != -1 || comprobarNombre(titulo, "titulo") == false);
                                    catalogo.get(posicion).setNombre(titulo);
                                    break;
                                case 2:
                                    do {
                                        System.out.print("Introduzaca el nuevo nombre del director: ");
                                        director = teclado.nextLine();
                                    } while (comprobarNombre(director, "director") == false || director.length() < 5);
                                    peliculasDelCatalogo(catalogo).get(posicion).setDirector(director);
                                    break;
                                case 3:
                                    do {
                                        System.out.print("Introduzaca el nuevo nombre del actor principal: ");
                                        actor = teclado.nextLine();
                                    } while (comprobarNombre(actor, "actor") == false && actor.length() < 5);
                                    peliculasDelCatalogo(catalogo).get(posicion).setActorPrincipal(actor);
                                    break;
                                case 4:
                                    do {
                                        System.out.print("\nIntroduce la nueva duración: ");
                                        duracion = teclado.nextInt();
                                        if (duracion < 60 || duracion > 240) {
                                            System.out.println("Debes introducir una duración valida(60-240 mnts).");
                                        }
                                    } while (duracion < 60 || duracion > 240);
                                    peliculasDelCatalogo(catalogo).get(posicion).setDuracion(duracion);
                                    break;
                                case 5:
                                    System.out.print("\nEliga a que categoria desea cambiar: "); //TERMINAR
                                    System.out.println("\n1. Comedia\n2. Drama\n3. Terror\n4. Supense\n5. Ciencia Ficción\n6. Fantasia");
                                    System.out.print("|nOpción: ");
                                    opcion = leerIntSinNegConMax(0, 7);
                                    peliculasDelCatalogo(catalogo).get(posicion).setCategoria(Tematica.values()[opcion - 1]);
                                    break;
                                case 6:
                                    System.out.print("Introduzaca la nueva calificación de edad(0-18): ");
                                    edad = leerIntSinNegConMax(-1, 19);
                                    peliculasDelCatalogo(catalogo).get(posicion).setCalificaEdad(edad);
                                    break;
                                case 7:
                                    System.out.print("Introduzaca el nuevo estado de la pelicula(true - false): ");
                                    String estado = teclado.nextLine();
                                    if (estado.equals("true")) {
                                        peliculasDelCatalogo(catalogo).get(posicion).setEstaDsiponible(true);
                                    } else if (estado.equals("false")) {
                                        peliculasDelCatalogo(catalogo).get(posicion).setEstaDsiponible(false);
                                    }
                                    break;
                                case 8:
                                    System.out.println("Volviendo");
                                    break;
                                default:
                                    System.out.println("\n OPCIÓN INVALIDA");
                            }
                            System.out.println("\n PELICULA MODIFICADA: ");
                            System.out.println(catalogo.get(posicion));
                        }
                    } while (opcion < 8);
                    break;

                case 3:
                    System.out.println("\n\n¿No recuerda el titulo?\n¿Desea ver las pelis?.\n\nSI.\nNO.");
                    System.out.print("Esriba una opcion: ");
                    eleccion = teclado.nextLine();
                    eleccion = eleccion.toLowerCase();
                    if (eleccion.equals("si")) {
                        System.out.println("------------------------\n\n\nPELICULAS");
                        System.out.println(peliculasDelCatalogo(catalogo));
                        System.out.println("--------------------------\n\n");
                    }
                    do {
                        System.out.print("Introduzaca el título: ");
                        nombre = teclado.nextLine();
                        if (buscarPeliEnMedia(catalogo, nombre) == -1) {
                            System.out.println("\nNo existe una película con este nombre. ");
                        }
                    } while (buscarPeliEnMedia(catalogo, nombre) == -1);
                    catalogo.remove(buscarPeliEnMedia(catalogo, nombre));
                    System.out.println("\nLa pelicula se elimino correctamente.");
                    break;

                case 4:
                    System.out.println("------------------------\n\n\nPELICULAS");
                    System.out.println(peliculasDelCatalogo(catalogo));
                    System.out.println("--------------------------\n\n");
                    break;

                case 5:
                    System.out.println("\n\n¿No recuerda el titulo?\n¿Desea ver las pelis?.\n\nSI.\nNO.");
                    System.out.print("Esriba una opcion: ");
                    eleccion = teclado.nextLine();
                    eleccion = eleccion.toLowerCase();
                    if (eleccion.equals("si")) {
                        System.out.println("------------------------\n\n\nPELICULAS");
                        System.out.println(peliculasDelCatalogo(catalogo));
                        System.out.println("--------------------------\n\n");
                    }
                    do {
                        System.out.print("Introduzaca el título: ");
                        nombre = teclado.nextLine();
                        if (buscarPeliEnMedia(catalogo, nombre) == -1) {
                            System.out.println("\nNo existe una película con este nombre. ");
                        }
                    } while (buscarPeliEnMedia(catalogo, nombre) == -1);
                    System.out.println("Introduce un voto, entre 0 y 10: ");
                    int voto = leerIntSinNegConMax(-1, 11);
                    peliculasDelCatalogo(catalogo).get(buscarPeliEnMedia(catalogo, nombre)).votar(voto);
                    break;

                case 6:
                    System.out.println("Volviendo");
                    break;
                default:
                    throw new IllegalArgumentException("Esta opción no se encunetra dentro del rango");
            }
        } while (opcion != 6);
    }

    /**
     * Realizara las diferentes opciones sobre Series. Explicación de las
     * diferentes opciones.
     *
     * 1.- Creación de un objeto serie, pidiendo al ususario sus debidos datos,
     * siempre validando dichos datos.
     *
     * 2.- Modificación de un objeto serie, buscaremos una serie dentro del
     * catalogo y muestrara diferentes datos que podemos modificar, los datos
     * nuevos que queremos cambiar estaran validados, una vez modificada la
     * serie, se mosrtrará por pantalla.
     *
     * 3.- Eliminación de un objeto serie, buscaremos una serie dentro del
     * catalogo y procederemos a borrarla
     *
     * 4.- Listaremos por patalla las diferentes series dentro de catalogo.
     *
     * 5.- Entraremos en un submenu para gestionar una serie concreta. 5.1 -
     * Creación de un objeto temporada, pidiendo al ususario sus debidos datos,
     * siempre validando dichos datos. 5.2 - Modificación de una temporada,
     * buscarermos una temporada dentro de un serie, los datos nuevos que
     * queremos cambiar estaran validados, una vez modificada la serie, se
     * mosrtrará por pantalla. 5.3 - Eliminación de un objeto temporada,
     * buscaremos una temporada dentro del catalogo y procederemos a borrarla
     * 5.4 - Creación de un objeto capitulo, pidiendo al ususario sus debidos
     * datos, siempre validando dichos datos. 5.5 - Eliminación de un objeto
     * capitulo, buscaremos un capitulo dentro del catalogo y procederemos a
     * borrarla 5.6 - Listaremos por patalla las diferentes temporadas y
     * capitulos dentro de serie. 5.7 - Valoración de un capitulo, le pediremos
     * al ususario true o false y se votara al capitulo. 5.8 - Volver. 6.-
     * Volver
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     */
    public static void imprimirSubMenuGestionarSeries(ArrayList<Media> catalogo) {
        Scanner teclado = new Scanner(System.in);
        int opcion, dia, mes, anio, temporada = 0, capitulo, espacio;
        String nombre, eleccion;
        do {
            System.out.println("------------------------\n\nGESTIONAR SERIES");
            System.out.println();
            System.out.println("1. Añadir serie.\n2. Modificar serie.\n3. Eliminar serie.\n4. Listar series.\n5. Gestionar serie concreta.");
            System.out.println("6. Volver.\n\n-------------------------");

            System.out.print("Escoga una opción: ");
            opcion = leerIntSinNegConMax(0, 7);
            switch (opcion) {
                case 1:
                    System.out.println("-- CREACIÓN DE SERIE --");
                    System.out.print("\n\nIntroduce el titulo: ");
                    do {
                        System.out.print("Introduzaca el título: ");
                        nombre = teclado.nextLine();
                        if (buscarSerieEnMedia(catalogo, nombre) != -1) {
                            System.out.println("\n Ya existe una serie con este nombre. ");
                        }
                    } while (buscarSerieEnMedia(catalogo, nombre) != -1 || comprobarNombre(nombre, "nombre") == false);

                    System.out.print("Introduzca la fecha de estreno: ");
                    System.out.print("\nDia: ");
                    dia = leerIntSinNegConMax(0, 32);
                    System.out.print("Mes: ");
                    mes = leerIntSinNegConMax(0, 13);
                    System.out.print("Año: ");
                    anio = leerIntSinNegConMax(1894, 2024);

                    System.out.print("Introduzca la calificación de edad(0-18): ");
                    int edad = leerIntSinNegConMax(-1, 19);

                    catalogo.add(new Serie(nombre, edad, LocalDate.now(), true,LocalDate.of(anio, mes, dia)));
                    break;
                case 2:
                    System.out.println("\n\n¿No recuerda el titulo?\n¿Desea ver las series?.\n\nSI.\nNO.");
                    System.out.print("Esriba una opcion: ");
                    eleccion = teclado.nextLine();
                    eleccion = eleccion.toLowerCase();
                    if (eleccion.equals("si")) {
                        System.out.println("------------------------\n\n\nSERIES");
                        System.out.println(seriesDelCatalogo(catalogo));
                        System.out.println("--------------------------\n\n");
                    }
                    do {
                        System.out.print("Introduzaca el título: ");
                        nombre = teclado.nextLine();
                        if (buscarSerieEnMedia(catalogo, nombre) == -1) {
                            System.out.println("\nNo existe una serie con este nombre. ");
                        }
                    } while (buscarSerieEnMedia(catalogo, nombre) == -1);
                    System.out.println(catalogo.get(buscarSerieEnMedia(catalogo, nombre)));
                    int posicion = buscarSerieEnMedia(catalogo, nombre);
                    do {
                        System.out.println("");
                        System.out.println("1. Titulo.\n2. Calificación de edad.\n3. Fecha de estreno.\n4. Disponibilidad.\n5. Volver.\n");
                        System.out.print("Que desea modificar: ");
                        opcion = leerIntSinNegConMax(0, 6);
                        if (opcion < 5) {
                            switch (opcion) {
                                case 1:
                                    do {
                                        System.out.print("Introduzaca el nuevo título: ");
                                        nombre = teclado.nextLine();
                                        if (buscarSerieEnMedia(catalogo, nombre) != -1) {
                                            System.out.println("\n Ya existe una serie con este nombre. ");
                                        }
                                    } while (buscarSerieEnMedia(catalogo, nombre) != -1 || comprobarNombre(nombre, "nombre") == false);
                                    catalogo.get(posicion).setNombre(nombre);
                                    break;
                                case 2:
                                    System.out.print("Introduzaca la nueva calificación de edad(0-18): ");
                                    edad = leerIntSinNegConMax(-1, 19);
                                    catalogo.get(posicion).setCalificaEdad(edad);
                                    break;
                                case 3:
                                    int lugar = buscarSerieEnSeries(catalogo, nombre);
                                    System.out.print("Introduzaca la nueva fecha de estreno: "); //pedir fecha
                                    System.out.println("");
                                    System.out.print("Dia: ");
                                    dia = leerIntSinNegConMax(0, 32);
                                    System.out.print("Mes: ");
                                    mes = leerIntSinNegConMax(0, 13);
                                    System.out.print("Año: ");
                                    anio = leerIntSinNegConMax(1894, 2024);
                                    seriesDelCatalogo(catalogo).get(lugar).setFechaEstreno(LocalDate.of(anio, mes, dia));

                                    break;
                                case 4:
                                    System.out.print("Introduzaca el nuevo estado de la serie: ");
                                    String estado = teclado.nextLine();
                                    if (estado.equals("true")) {
                                        catalogo.get(posicion).setEstaDsiponible(true);
                                    } else if (estado.equals("false")) {
                                        catalogo.get(posicion).setEstaDsiponible(false);
                                    }
                                    break;
                                case 5:
                                    System.out.println("Volviendo...");
                                    break;
                                default:
                                    System.out.println("\n OPCIÓN INVALIDA");
                            }
                            System.out.println("\n SERIE MODIFICADA: ");
                            System.out.println(catalogo.get(posicion));
                        }
                    } while (opcion < 5);
                    break;
                case 3:
                    System.out.println("\n\n¿No recuerda el titulo?\n¿Desea ver las pelis?.\n\nSI.\nNO.");
                    System.out.print("Esriba una opcion: ");
                    eleccion = teclado.nextLine();
                    eleccion = eleccion.toLowerCase();
                    if (eleccion.equals("si")) {
                        System.out.println("------------------------\n\n\nPELICULAS");
                        System.out.println(seriesDelCatalogo(catalogo));
                        System.out.println("--------------------------\n\n");
                    }
                    do {
                        System.out.print("Introduzaca el título: ");
                        nombre = teclado.nextLine();
                        if (buscarSerieEnMedia(catalogo, nombre) == -1) {
                            System.out.println("\nNo existe una película con este nombre. ");
                        }
                    } while (buscarSerieEnMedia(catalogo, nombre) == -1);
                    catalogo.remove(buscarSerieEnMedia(catalogo, nombre));
                    System.out.println("\nLa Serie se elimino correctamente.");
                    break;
                case 4:
                    System.out.println("------------------------\n\n\nPELICULAS");
                    System.out.println(seriesDelCatalogo(catalogo));
                    System.out.println("--------------------------\n\n");
                    break;
                case 5:
                    System.out.println("\n\n¿No recuerda el titulo?\n¿Desea ver las series?.\n\nSI.\nNO.");
                    System.out.print("Esriba una opcion: ");
                    eleccion = teclado.nextLine();
                    eleccion = eleccion.toLowerCase();
                    if (eleccion.equals("si")) {
                        System.out.println("------------------------\n\n\nSERIES");
                        System.out.println(seriesDelCatalogo(catalogo));
                        System.out.println("--------------------------\n\n");
                    }
                    do {
                        System.out.print("Introduzaca el título: ");
                        nombre = teclado.nextLine();
                        if (buscarSerieEnMedia(catalogo, nombre) == -1) {
                            System.out.println("\nNo existe una serie con este nombre. ");
                        }
                    } while (buscarSerieEnMedia(catalogo, nombre) == -1);
                    System.out.println(catalogo.get(buscarSerieEnMedia(catalogo, nombre)));
                    posicion = buscarSerieEnSeries(catalogo, nombre);

                    do {

                        System.out.println("------------------------\n\nGESTIONAR SERIES CONCRETAS");
                        System.out.println();
                        System.out.println("1. Añadir Temporada.\n2. Modificar Temporada.\n3. Eliminar Temporada.\n4. Añadir capítulos.");
                        System.out.println("5. Eliminar capítulos.\n6. Listar temporadas y capítulos.\n7. Valorar Capítulo.");
                        System.out.println("8. Volver.\n\n-------------------------");

                        System.out.print("Escoga una opción: ");
                        opcion = leerIntSinNegConMax(0, 9);
                        if(opcion > 1 && opcion != 6){
                            System.out.println("La series tiene " + seriesDelCatalogo(catalogo).get(posicion).getTemporadas().size() + " temporada/s");
                            System.out.println("¿Con cual deseas trabajar?");
                            temporada = leerIntSinNegConMax(0, seriesDelCatalogo(catalogo).get(posicion).getTemporadas().size() + 1);
                        }
                        switch (opcion) {
                            case 1:
                                System.out.println("-- AÑADIR TEMPORADA --\n\n");
                                System.out.print("Introduzaca la fecha de estreno: ");
                                System.out.print("\nDia: "); dia = leerIntSinNegConMax(0, 32);
                                System.out.print("Mes: "); mes = leerIntSinNegConMax(0, 13);
                                System.out.print("Año: "); anio = leerIntSinNegConMax(1927, 2024);
                                if(seriesDelCatalogo(catalogo).get(posicion).getFechaEstreno().isBefore(LocalDate.of(anio, mes, dia))){
                                    seriesDelCatalogo(catalogo).get(posicion).añadirTemporada(LocalDate.of(anio, mes, dia));
                                }else{
                                    System.out.println("No se ha creado ninguna temporada");
                                    System.out.println("Debes introducir una fecha despues del estreno de la serie.");
                                }
                                break;
                            case 2: //Poder editar capitulos
                                System.out.print("Introduzaca la nueva fecha de estreno: "); //Poder modificar capitulo
                                System.out.print("\nDia: "); dia = leerIntSinNegConMax(0, 32);
                                System.out.print("Mes: "); mes = leerIntSinNegConMax(0, 13);
                                System.out.print("Año: "); anio = leerIntSinNegConMax(1927, 2024);
                                if(seriesDelCatalogo(catalogo).get(posicion).getFechaEstreno().isAfter(LocalDate.of(anio, mes, dia))){
                                    System.out.println("No se ha modificado ninguna temporada");
                                    System.out.println("Debes introducir una fecha despues del estreno de la serie.");
                                }else{
                                    seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada - 1).setFechaEstreno(LocalDate.of(anio, mes, dia));
                                }
                            break;
                            case 3:
                                if (seriesDelCatalogo(catalogo).get(posicion).eliminarTemporada(temporada - 1)) {
                                    System.out.println("Temporada eliminada");
                                }else{
                                    System.out.println("No se ha podido eliminar la temporada");
                                }
                                break;
                            case 4:
                                do {
                                    System.out.print("Introduce el titulo de capitulo: ");
                                    nombre = teclado.nextLine();
                                    if (seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada - 1).buscarCapitulo(nombre) != -1) {
                                        System.out.println("\n Ya existe un capitulo con este nombre. ");
                                    }
                                } while (comprobarNombre(nombre, "titulo") == false || seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada - 1).buscarCapitulo(nombre) != -1);
                                System.out.println(nombre);
                                System.out.print("Introduzaca la fecha de estreno: "); //Poder modificar capitulo
                                System.out.print("\nDia: "); dia = leerIntSinNegConMax(0, 32);
                                System.out.print("Mes: "); mes = leerIntSinNegConMax(0, 13);
                                System.out.print("Año: "); anio = leerIntSinNegConMax(1927, 2024);
                                if (seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada - 1).getFechaestreno().isAfter(LocalDate.of(anio, mes, dia))) {
                                    System.out.println("No se ha creado ningún capítulo, debe tener una fecha posterior a la de la temporada.");
                                }else{
                                    seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada - 1).añadirCapitulo(new Capitulo(nombre,LocalDate.of(anio, mes, dia)));
                                }
                                break;
                            case 5:
                                System.out.println("La series tiene " + seriesDelCatalogo(catalogo).get(posicion).getTemporadas().size() + " temporada/s");
                                System.out.println("¿Con cual deseas trabajar?");
                                temporada = temporada - 1;
                                System.out.println("CAPITULOS\n");
                                System.out.println(seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada).toString());
                                System.out.println("Escoga uno de los capitulo/s: ");
                                capitulo = leerIntSinNegConMax(0, seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada).getCapitulos().size() + 1);
                                seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada).getCapitulos().remove(capitulo - 1);
                                break;
                            case 6:
                                System.out.println("------------------------\n\nSERIE");
                                System.out.println(seriesDelCatalogo(catalogo).get(posicion));
                                System.out.println("--------------------------\n\n");
                                break;
                            case 7:
                                temporada = temporada - 1;
                                System.out.println("CAPITULOS\n");
                                System.out.println(seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada).toString());
                                System.out.println("Escoga uno de los capitulo/s: ");
                                capitulo = leerIntSinNegConMax(0, seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada).getCapitulos().size() + 1);
                                System.out.print("Introduzaca el voto al capitulo: ");
                                String estado = teclado.nextLine();
                                if (estado.equals("true")) {
                                    seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada).meGusta(capitulo - 1, true);
                                } else if (estado.equals("false")) {
                                    seriesDelCatalogo(catalogo).get(posicion).getTemporadas().get(temporada).meGusta(capitulo - 1, false);
                                }
                                break;
                            case 8:
                                System.out.println("Volver");
                                break;
                            default:
                                System.out.println("Esta opción no se encunetra dentro del rango");
                        }
                        System.out.println("-- SERIE MODIFICADA --");
                        System.out.println(seriesDelCatalogo(catalogo).get(posicion));
                    } while (opcion < 8);
                    break;
                case 6:
                    System.out.println("Volver");
                    break;
                default:
                    System.out.println("Esta opción no se encunetra dentro del rango");
            }
        } while (opcion < 6);
    }

    /**
     * Realizara las diferentes opciones de consultas.Explicación de las
     * diferentes opciones. 1.- Mostraremos por pantalla las diferentes
     * peliculas o series dependiendo de su calificación de edad.
     *
     * 2.- Mostraremos por pantalla un numero pedido al ususario de mejores
     * peliculas filtradas por tematica.
     *
     * 3.- Mostraremos por pantalla un numero pedido al ususario de mejores
     * peliculas filtradas por actor principal.
     *
     * 4.- Mostraremos por pantalla un numero pedido al ususario de mejores
     * peliculas filtradas por director.
     *
     * 5.- Mostramos por pantalla un numero pedido al ususario de mejores
     * series.
     *
     * 6. - Mostramos por pantalla un numero pedido al ususario de mejores
     * series o peliculas disponibles.
     *
     * 7.- Volver
     *
     * @param catalogo
     */
    public static void imprimirSubMenuConsultarCatalogo(ArrayList<Media> catalogo) {
        int edad, cantidad;
        String actor, director;
        Scanner teclado = new Scanner(System.in);
        System.out.println("------------------------\n\nFILTRADO DE CATALOGO");
        System.out.println();
        System.out.println("1. Mostrar Series o películas según su calificación de edad.\n2. Listar las n mejores películas por temática.");
        System.out.println("3. Listar las n mejores películas por actor.\n4. Listar las n mejores películas por director.");
        System.out.println("5. Listar las n mejores series.\n6. Listar los n mejores elementos disponibles del catálogo (serie o película).");
        System.out.println("7. Volver.\n\n-------------------------");
        System.out.print("Escoga una opción: ");
        int opcion = leerIntSinNegConMax(0, 8);
        switch (opcion) {
            case 1:
                System.out.println("\n1. Series\n2. Peliculas");
                System.out.print("Eliga una opción: ");
                opcion = leerIntSinNegConMax(0, 3);
                System.out.println(listaPeliculaSeriesEdad(catalogo, opcion));
                break;
            case 2:
                System.out.print("\nEliga a que categoria desea filtrar: ");
                System.out.println("\n1. Comedia\n2. Drama\n3. Terror\n4. Supense\n5. Ciencia Ficción\n6. Fantasia");
                System.out.print("|nOpción: ");
                opcion = leerIntSinNegConMax(0, 7);
                System.out.println("¿Cuantas peliculas desea sacar?");
                cantidad = leerIntSinNegConMax(0, catalogo.size());
                System.out.println("Listando las n mejores peliculas por temática.");
                System.out.println(listaPeliculaTematica(cantidad, catalogo, Tematica.values()[opcion - 1]));
                break;
            case 3:
                do {
                    System.out.println("Introduce el nombre del actor: ");
                    actor = teclado.nextLine();
                } while (!comprobarNombre(actor, "actor"));
                System.out.println("¿Cuantas peliculas desea sacar?");
                cantidad = leerIntSinNegConMax(0, catalogo.size());
                System.out.println("Listando las n mejores peliculas por actor principal.");
                System.out.println(listaPeliculaActor(cantidad, catalogo, actor));
                break;
            case 4:
                do {
                    System.out.println("Introduce el nombre del director: ");
                    director = teclado.nextLine();
                } while (!comprobarNombre(director, "director"));
                System.out.println("¿Cuantas peliculas desea sacar?");
                cantidad = leerIntSinNegConMax(0, catalogo.size());
                System.out.println("Listando las n mejores peliculas por director.");
                System.out.println(listaPeliculaDirector(cantidad, catalogo, director));
                break;
            case 5:
                System.out.println("¿Cuantas series desea sacar?");
                cantidad = leerIntSinNegConMax(0, catalogo.size());
                System.out.println("Listando las n mejores series.");
                System.out.println(listaMejoresSeries(cantidad, catalogo, "no"));
                break;
            case 6:
                System.out.println("\n1. Series\n2. Peliculas");
                System.out.print("Eliga una opción: ");
                opcion = leerIntSinNegConMax(0, 3);
                if (opcion == 1) {
                    System.out.println("¿Cuantas series desea sacar?");
                    cantidad = leerIntSinNegConMax(0, catalogo.size());
                    System.out.println("Listando las n mejores series disponibles.");
                    System.out.println(listaMejoresSeries(cantidad, catalogo, "si"));
                } else {
                    System.out.println("¿Cuantas peliculas desea sacar?");
                    cantidad = leerIntSinNegConMax(0, catalogo.size());
                    System.out.println("Listando las n mejores peliculas disponibles.");
                    System.out.println(listaMejoresPeliculas(cantidad, catalogo));
                }
                break;
            case 7:
                System.out.println("Volviendo ...");
                break;
            default:
                System.out.println("Opción invalida.");
        }
    }

    /**
     * Imprimir por pantalla el catalogo. Mostrara por pantalla los diferentes
     * elementos dentro de catalogo.
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     */
    public static void imprimirLista(ArrayList<Media> catalogo) {
        for (Media media : catalogo) {
            System.out.println();
            System.out.println(media);
        }
    }

    /**
     * ArrayList filtrada por edad.
     * Se pedira al ususario si desea sacar una lista de series o películas,
     * despues se llamar a la funcion que instacia el catalogo y guardara solo
     * los objetos que coincidan con la edad de clasificación que se le pide al 
     * usuario.
     * 
     * @param catalogo ArrayList encargado de almacenar el catalogo.
     * @param opcion Elección entre serie y pelicula
     * @return ArrayList con las mejores peliculas o series, filtrando por edad.
     */
    public static ArrayList<Media> listaPeliculaSeriesEdad(ArrayList<Media> catalogo, int opcion) {
        int edad;
        ArrayList<Media> lista = new ArrayList<>();
        System.out.println("Introduzca la calificación que desea sacar.");
        edad = leerIntSinNegConMax(-1, 19);
        if (opcion == 1) {
            for (int i = 0; i < seriesDelCatalogo(catalogo).size(); i++) {
                if (seriesDelCatalogo(catalogo).get(i).getCalificaEdad() == edad) {
                    lista.add(seriesDelCatalogo(catalogo).get(i));
                }
            }
        } else {
            for (int i = 0; i < peliculasDelCatalogo(catalogo).size(); i++) {
                if (peliculasDelCatalogo(catalogo).get(i).getCalificaEdad() == edad) {
                    lista.add(peliculasDelCatalogo(catalogo).get(i));
                }
            }
        }
        return lista;
    }

    /**
     * ArrayList películas filtrada por temática.
     * Se pedira al ususario la temática y la cantidad de peliculas que se desea extraer, 
     * despues se instaciará el catalogo y guardara solo los objetos que coincidan con la 
     * temática que se le pide al usuario.
     * 
     * Se usará un comparator para comparar la puntuación total de peliculas, 
     * para poder ordenarlas por mejor puntuación ademas de filtrar por temática.
     * 
     * @param cantidad Cantidad de peliculas que queremos filtrar.
     * @param catalogo ArrayList encargado de almacenar el catalogo.
     * @param Categoria Categoria por que se filtrará.
     * @return ArrayList con las mejores peliculas, filtrando por temática.
     */
    public static ArrayList<Pelicula> listaPeliculaTematica(int cantidad, ArrayList<Media> catalogo, Tematica Categoria) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<Pelicula> mejores = new ArrayList<>();
        if (cantidad > 0) {
            for (Media media : catalogo) {
                if (media instanceof Pelicula) {
                    if (((Pelicula) media).getCategoria().equals(Categoria)) {
                        peliculas.add((Pelicula) media);
                    }
                }
            }
            Collections.sort(peliculas, new Comparator<Pelicula>() {
                public int compare(Pelicula p1, Pelicula p2) {
                    return p2.calcularPuntuacion() - p1.calcularPuntuacion();
                }
            });

            for (int i = 0; i < cantidad; i++) {
                if (i < peliculas.size()) {
                    mejores.add(peliculas.get(i));
                }
            }
        }

        return mejores;
    }

    /**
     * ArrayList películas filtrada por actor.
     * Se pedira al ususario el nombre del actor y la cantidad de peliculas que se desea extraer, 
     * despues se  instaciará el catalogo y guardara solo los objetos que coincidan con el 
     * nombre del actor que se le pide al usuario.
     * 
     * Se usará un comparator para comparar la puntuación total de peliculas, 
     * para poder ordenarlas por mejor puntuación ademas de filtrar por el nombr del actor.
     * 
     * @param cantidad Cantidad de peliculas que queremos filtrar.
     * @param catalogo ArrayList encargado de almacenar el catalogo.
     * @param actor Nombre del actor por el que se filtrará.
     * @return ArrayList con las mejores peliculas, filtrando por actor.
     */
    public static ArrayList<Pelicula> listaPeliculaActor(int cantidad, ArrayList<Media> catalogo, String actor) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<Pelicula> mejores = new ArrayList<>();
        if (cantidad > 0) {
            for (Media media : catalogo) {
                if (media instanceof Pelicula) {
                    if (((Pelicula) media).getActorPrincipal().equals(actor)) {
                        peliculas.add((Pelicula) media);
                    }
                }
            }
            Collections.sort(peliculas, new Comparator<Pelicula>() {
                public int compare(Pelicula p1, Pelicula p2) {
                    return p2.calcularPuntuacion() - p1.calcularPuntuacion();
                }
            });
            for (int i = 0; i < cantidad; i++) {
                if (i < peliculas.size()) {
                    mejores.add(peliculas.get(i));
                }
            }
        }

        return mejores;
    }

    /**
     * ArrayList películas filtrada por director.
     * Se pedira al ususario el nombre del director y la cantidad de peliculas que se desea extraer, 
     * despues se  instaciará el catalogo y guardara solo los objetos que coincidan con el 
     * nombre del director que se le pide al usuario.
     * 
     * Se usará un comparator para comparar la puntuación total de peliculas, 
     * para poder ordenarlas por mejor puntuación ademas de filtrar por el nombre del director.
     * 
     * @param cantidad Cantidad de peliculas que queremos filtrar.
     * @param catalogo ArrayList encargado de almacenar el catalogo.
     * @param director Nombre del directo por el que se filtrará.
     * @return ArrayList con las mejores peliculas, filtrando por director.
     */
    public static ArrayList<Pelicula> listaPeliculaDirector(int cantidad, ArrayList<Media> catalogo, String director) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<Pelicula> mejores = new ArrayList<>();
        if (cantidad > 0) {
            for (Media media : catalogo) {
                if (media instanceof Pelicula) {
                    if (((Pelicula) media).getDirector().equals(director)) {
                        peliculas.add((Pelicula) media);
                    }
                }
            }
            Collections.sort(peliculas, new Comparator<Pelicula>() {
                public int compare(Pelicula p1, Pelicula p2) {
                    return p2.calcularPuntuacion() - p1.calcularPuntuacion();
                }
            });
            for (int i = 0; i < cantidad; i++) {
                if (i < peliculas.size()) {
                    mejores.add(peliculas.get(i));
                }
            }
        }

        return mejores;
    }

    /**
     * ArrayList series filtrada.
     * Se pedira al ususario la disponibilidad y la cantidad de series que se desea extraer, 
     * despues se  instaciará el catalogo y guardara solo los objetos que coincidan con la
     * disponibilidad que se le pide al usuario.
     * 
     * Se usará un comparator para comparar la puntuación total de series, 
     * para poder ordenarlas por mejor puntuación ademas de filtrar por su disponibilidad.
     * 
     * @param cantidad Cantidad de peliculas que queremos filtrar.
     * @param catalogo ArrayList encargado de almacenar el catalogo.
     * @param disponibilidad Disponibilidad por la que se filtrará.
     * @return ArrayList con las mejores series.
     */
    public static ArrayList<Serie> listaMejoresSeries(int cantidad, ArrayList<Media> catalogo, String disponibilidad) {
        ArrayList<Serie> series = new ArrayList<>();
        ArrayList<Serie> mejores = new ArrayList<>();
        if (cantidad > 0) {
            for (Media media : catalogo) {
                if (media instanceof Serie) {
                    if (disponibilidad.equals("si")) {
                        if (((Serie) media).getEstaDsiponible() == true) {
                            series.add((Serie) media);
                        }
                    } else {
                        series.add((Serie) media);
                    }
                }
            }
            Collections.sort(series, new Comparator<Serie>() {
                public int compare(Serie s1, Serie s2) {
                    return s2.calcularPuntuacion() - s1.calcularPuntuacion();
                }
            });
            for (int i = 0; i < cantidad; i++) {
                if (i < series.size()) {
                    mejores.add(series.get(i));
                }
            }
        }

        return mejores;
    }

    /**
     *  ArrayList películas filtrada.
     * Se pedira al ususario la cantidad de peliculas que se desea extraer, 
     * despues se  instaciará el catalogo y guardara los objetos.
     * 
     * Se usará un comparator para comparar la puntuación total de películas, 
     * para poder ordenarlas por mejor puntuación ademas de filtrar por su disponibilidad.
     * 
     * @param cantidad Cantidad de peliculas que queremos filtrar.
     * @param catalogo ArrayList encargado de almacenar el catalogo.
     * @return ArrayList con las mejores peliculas.
     */
    public static ArrayList<Media> listaMejoresPeliculas(int cantidad, ArrayList<Media> catalogo) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<Media> mejores = new ArrayList<>();
        if (cantidad > 0) {
            for (Media media : catalogo) {
                if (media instanceof Pelicula) {
                    if (((Pelicula) media).getEstaDsiponible() == true) {
                        peliculas.add((Pelicula) media);
                    }
                }
                Collections.sort(peliculas, new Comparator<Pelicula>() {
                    public int compare(Pelicula p1, Pelicula p2) {
                        return p2.calcularPuntuacion() - p1.calcularPuntuacion();
                    }
                });
                for (int i = 0; i < cantidad; i++) {
                    if (i < peliculas.size()) {
                        mejores.add(peliculas.get(i));
                    }
                }
            }
        }
        return mejores;
    }

    /**
     * Filtrado de peliculas. Crearemos un ArrayList de peliculas, donde
     * instanciaremos catalogo y iremos filtrando sacando las peliculas
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     * @return ArrayList con peliculas.
     */
    public static ArrayList<Pelicula> peliculasDelCatalogo(ArrayList<Media> catalogo) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for (Media media : catalogo) {
            if (media instanceof Pelicula) {
                peliculas.add((Pelicula) media);
            }
        }
        return peliculas;
    }

    /**
     * Filtrado de series. Crearemos un ArrayList de series, donde
     * instanciaremos catalogo y iremos filtrando sacando las series
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     * @return ArrayList con series.
     */
    public static ArrayList<Serie> seriesDelCatalogo(ArrayList<Media> catalogo) {
        ArrayList<Serie> series = new ArrayList<>();
        for (Media media : catalogo) {
            if (media instanceof Serie) {
                series.add((Serie) media);
            }
        }
        return series;
    }

    /**
     * Buscar peliculas en el Array catalogo. Buscaremos la posicion de las
     * peliculas que coinciden con el titulo pasado por paramento
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     * @param titulo // Nombre de la pelicula
     * @return Posición de la pelicula que conicide con el titulo, si no
     * devolvera -1
     */
    public static int buscarPeliEnMedia(ArrayList<Media> catalogo, String titulo) {
        int posicion = -1;
        for (int i = 0; i < catalogo.size(); i++) {
            if (titulo.equals(catalogo.get(i).getNombre())) {
                if (catalogo.get(i) instanceof Pelicula) {
                    return i;
                }
            }
        }
        return posicion;
    }

    /**
     * Buscar series en el Array catalogo. Buscaremos la posicion de las series
     * que coinciden con el titulo pasado por paramento
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     * @param titulo // Nombre de la serie
     * @return Posición de la serie que conicide con el titulo, si no devolvera
     * -1
     */
    public static int buscarSerieEnMedia(ArrayList<Media> catalogo, String titulo) {
        int posicion = -1;
        for (int i = 0; i < catalogo.size(); i++) {
            if (titulo.equals(catalogo.get(i).getNombre())) {
                if (catalogo.get(i) instanceof Serie) {
                    return i;
                }
            }
        }
        return posicion;
    }

    /**
     * Buscar series en el Array Series. Buscaremos la posicion de las series
     * que coinciden con el titulo pasado por paramento
     *
     * @param catalogo //ArrayList encargado de almacenar el catalogo.
     * @param titulo // Nombre de la serie
     * @return Posición de la serie que conicide con el titulo, si no devolvera
     * -1
     */
    public static int buscarSerieEnSeries(ArrayList<Media> catalogo, String titulo) {
        int posicion = -1;

        for (int i = 0; i < seriesDelCatalogo(catalogo).size(); i++) {
            if (seriesDelCatalogo(catalogo).get(i).getNombre().equals(titulo)) {
                posicion = i;
            }
        }
        return posicion;
    }

}
