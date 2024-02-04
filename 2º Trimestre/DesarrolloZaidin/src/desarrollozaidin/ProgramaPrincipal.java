/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desarrollozaidin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Empresa> empresas = new ArrayList();
        int opcion, empresa;

        empresas.add(new Empresa("Nestle"));
        System.out.println(empresas.size());
        empresas.get(0).añadirEmpleado(new Comercial(Zona_Ventas.CENTRO, 2, "Pedro", "Sanchez Ruiz", 100, 4));
        empresas.get(0).añadirEmpleado(new Comercial(Zona_Ventas.COSTA, 4, "Juan", "Gonzalez Vega", 200, 1));
        empresas.get(0).añadirEmpleado(new Comercial(Zona_Ventas.NORTE, 7, "Jacobo", "Lopez Martin", 500, 4));
        empresas.get(0).añadirEmpleado(new Programador("Java", 200, 2, "Fernando", "Muñoz Fernandez", 400, 3));
        empresas.get(0).añadirEmpleado(new Programador("Python", 300, 3, "Tomas", "Gonzalez Vega", 600, 7));

        System.out.println("");
        Scanner teclado = new Scanner(System.in);
        do {
            for (int i = 0; i < empresas.size(); i++) {
                System.out.println("Empresa: " + (i + 1));
                System.out.println(empresas.get(i));
            }
            System.out.println("\n\nCon que empresa deseas trabajar: ");
            empresa = teclado.nextInt();
            if (empresa > empresas.size()) {
                System.out.println("No existe niguna empresa en ese rango");
            }
        } while (empresa > empresas.size());

        empresa = empresa - 1;

        do {
            do {
                System.out.println("");
                imprimirMenuPrincipal();
                System.out.println("");
                System.out.println("Elija una opción: ");
                opcion = teclado.nextInt();
                if (opcion > 8 || opcion < 1) {
                    System.out.println("Introduce una opción valida en el rango.");
                }
            } while (opcion > 8 && opcion < 0);

            switch (opcion) {
                case 1:
                    crearProgramador(empresas, empresa);
                    break;
                case 2:
                    crearComercial(empresas, empresa);
                    break;
                case 3:
                    eliminarEmpleado(empresas, empresa);
                    break;
                case 4:
                    eliminarEmpleados(empresas, empresa);
                    break;
                case 5:
                    imprimirEmpleados(empresas);
                    break;
                case 6:
                    System.out.println("Un total de: ");
                    System.out.println(empresas.get(empresa).calcularCosteProgramadores());
                    break;
                case 7:
                    System.out.print("Un total de: ");
                    System.out.println(empresas.get(empresa).calcularCosteEmpleados());
                    break;
                case 8:

                    break;
                default:
                    System.out.println("");
            }
        } while (opcion < 9);
    }

    /**
     *
     */
    public static void imprimirMenuPrincipal() {
        System.out.println("-- MENU --");
        System.out.println("1. Añadir Programador.");
        System.out.println("2. Añadir Comercial.");
        System.out.println("3. Eliminar empleado.");
        System.out.println("4. Eliminar empleados.");
        System.out.println("5. Listar empleados.");
        System.out.println("6. Calcular coste total Programadores.");
        System.out.println("7. Calcular coste total Empleados.");
        System.out.println("8. Lista los n mejores comerciales.");
        System.out.println("9. Salir.");
    }

    /**
     *
     * @param empresas
     */
    public static void imprimirEmpleados(ArrayList<Empresa> empresas) {
        for (int i = 0; i < empresas.size(); i++) {
            System.out.println(empresas.get(i));
        }
    }

    /**
     *
     * @param empresas
     * @param indice
     */
    public static void crearProgramador(ArrayList<Empresa> empresas, int indice) {
        Scanner teclado = new Scanner(System.in);
        String nombre, apellidos, lenguaje;
        int salario, anios, plus, proyectos;
        do {
            System.out.println("Introduce el nombre el empleado: ");
            nombre = teclado.nextLine();

            if (nombre.isBlank() || nombre.isEmpty()) {
                System.out.println("Introduce un nombre valido.");
            }
        } while (nombre.isBlank() || nombre.isEmpty());
        do {
            System.out.println("Introduce los apellidos el empleado: ");
            apellidos = teclado.nextLine();

            if (apellidos.isBlank() || apellidos.isEmpty()) {
                System.out.println("Introduce los apellidos valido.");
            }
        } while (apellidos.isBlank() || apellidos.isEmpty());
        if (empresas.get(indice).posicionEmpleado(nombre, apellidos) != -1) {
            System.out.println("Ya existe un empleado con este nombre.");
        } else {
            do {
                System.out.println("Inntroduce el salario base:");
                salario = teclado.nextInt();
                if (salario < 1) {
                    System.out.println("introduce un salario valido.");
                }
            } while (salario < 1);

            do {
                System.out.println("Inntroduce los años de empresa:");
                anios = teclado.nextInt();
                if (anios < 0) {
                    System.out.println("introduce unos años validos.");
                }
            } while (anios < 0);
            do {
                System.out.println("Introduce el lenguaje del programador: ");
                lenguaje = teclado.nextLine();
                if (lenguaje.isBlank() || lenguaje.isEmpty()) {
                    System.out.println("Introduce un lenguaje valido.");
                }
            } while (lenguaje.isBlank() || lenguaje.isEmpty());
            do {
                System.out.println("Inntroduce el plus del trabajador:");
                plus = teclado.nextInt();
                if (plus < 0) {
                    System.out.println("introduce un plus validos.");
                }
            } while (plus < 0);
            do {
                System.out.println("Inntroduce el nº de proyectos del trabajador:");
                proyectos = teclado.nextInt();
                if (proyectos < 0) {
                    System.out.println("introduce un nº de proyectos validos.");
                }
            } while (proyectos < 0);

            empresas.get(indice).añadirEmpleado(new Programador(lenguaje, plus, proyectos, nombre, apellidos, salario, anios));
        }
    }

    /**
     *
     * @param empresas
     * @param indice
     */
    public static void crearComercial(ArrayList<Empresa> empresas, int indice) {
        Scanner teclado = new Scanner(System.in);

        String nombre, apellidos;
        int salario, anios, zona, numVentas;
        do {
            System.out.println("Introduce el nombre el empleado: ");
            nombre = teclado.nextLine();
            if (nombre.isBlank() || nombre.isEmpty()) {
                System.out.println("Introduce un nombre valido.");
            }
        } while (nombre.isBlank() || nombre.isEmpty());
        do {
            System.out.println("Introduce los apellidos el empleado: ");
            apellidos = teclado.nextLine();
            if (apellidos.isBlank() || apellidos.isEmpty()) {
                System.out.println("Introduce los apellidos valido.");
            }
        } while (apellidos.isBlank() || apellidos.isEmpty());

        if (empresas.get(indice).posicionEmpleado(nombre, apellidos) != -1) {
            System.out.println("Ya existe un empleado con este nombre.");
        } else {

            do {
                System.out.println("Inntroduce el salario base:");
                salario = teclado.nextInt();
                if (salario < 1) {
                    System.out.println("introduce un salario valido.");
                }
            } while (salario < 1);

            do {
                System.out.println("Inntroduce los años de empresa:");
                anios = teclado.nextInt();
                if (anios < 0) {
                    System.out.println("introduce unos años validos.");
                }
            } while (anios < 0);
            do {
                System.out.println("Elija una de las zonas:");
                System.out.println("\n1. Centro\n2. Norte\n3. Costa");
                zona = teclado.nextInt();
                if (zona > 0 && zona < 4) {
                    System.out.println("introduce un zona valida.");
                }
            } while (zona > 0 && zona < 4);
            do {
                System.out.println("Inntroduce el nº de proyectos del trabajador:");
                numVentas = teclado.nextInt();
                if (numVentas < 0) {
                    System.out.println("introduce un nº de proyectos validos.");
                }
            } while (numVentas < 0);
            empresas.get(indice).añadirEmpleado(new Comercial(Zona_Ventas.values()[zona - 1], numVentas, nombre, apellidos, salario, anios));
        }
    }

    private static void eliminarEmpleado(ArrayList<Empresa> empresas, int indice) {
        Scanner teclado = new Scanner(System.in);

        String nombre, apellidos;
        do {
            System.out.println("Introduce el nombre el empleado: ");
            nombre = teclado.nextLine();
            if (nombre.isBlank() || nombre.isEmpty()) {
                System.out.println("Introduce un nombre valido.");
            }
        } while (nombre.isBlank() || nombre.isEmpty());
        do {
            System.out.println("Introduce los apellidos el empleado: ");
            apellidos = teclado.nextLine();
            if (apellidos.isBlank() || apellidos.isEmpty()) {
                System.out.println("Introduce los apellidos valido.");
            }
        } while (apellidos.isBlank() || apellidos.isEmpty());
        if (empresas.get(indice).posicionEmpleado(nombre, apellidos) == -1) {
            System.out.println("No existe ningún empleado no este nombre.");
        } else {
            empresas.get(indice).eliminarEmpleado(nombre, apellidos);
            System.out.println("El empleado se elimino correctamente. ");
        }
    }

    private static void eliminarEmpleados(ArrayList<Empresa> empresas, int indice) {
        Scanner teclado = new Scanner(System.in);
        String apellidos;
        do {
            System.out.println("Introduce los apellidos el empleado: ");
            apellidos = teclado.nextLine();
            if (apellidos.isBlank() || apellidos.isEmpty()) {
                System.out.println("Introduce los apellidos valido.");
            }
        } while (apellidos.isBlank() || apellidos.isEmpty());
        if (empresas.get(indice).posicionEmpleadoApellido(apellidos) == -1) {
            System.out.println("No existen empleados con esos apellidos.");
        } else {
            empresas.get(indice).eliminarEmpleados(apellidos);
        }
    }
}
