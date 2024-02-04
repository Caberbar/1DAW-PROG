package vergeflix;

import java.time.LocalDate;

/**
 * Esta clase abstracta se encargará de modelar un elemento del catálogo. 
 * Es una versión inicial que he creado sobre el trabajo de Vergeflix.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public abstract class Media implements Comparable<Media>, Valorable {

    private String nombre; //Nombre del elemento del catálogo. 
    private int calificaEdad; //Edad mínima para la que está recomendada. Será un valor entre 0 y 18.
    private LocalDate fechaIncorporacionAlCatalogo; //. Fecha en la que el elemento catalogable Media se incorpora a nuestro catálogo.
    private boolean estaDsiponible; // Indica si el elemento está disponible para visualizarse o no.

/**
     * Construye el objeto Media. 
     * Se construirá un objeto con el nombre del catálogo, su calificación de edad,
     * su fecha de incorporación al catálogo y, si ese catálogo está disponible.
     * Todos los parámetros son validados, en caso de no ser corrector se
     * lanzará un IllegalArgumentException.
     *
     * @param nombre //Valor que tendrá el nombre del catálogo.
     * @param calificaEdad //Valor que tendrá la calificación de edad.
     * @param fechaIncorporacionAlCatalogo //Valor que tendrá la fecha de
     * incorporación del catálogo.
     * @param estaDsiponible //Valor que tendrá la disponibilidad del catálogo.
     * 
     * @throws Nombre, en caso de ser un nombre vacío se lanzará una excepción.
     * @throws Calificación, en caso de que el número introducido no se encuentre en el rango lanzara excepción.
     */
    public Media(String nombre, int calificaEdad, LocalDate fechaIncorporacionAlCatalogo, boolean estaDsiponible) {
        if (nombre.isEmpty() && nombre.isBlank()) {
            throw new IllegalArgumentException("Debes introducir un nombre valido");
        }
        if (calificaEdad < 0 || calificaEdad > 18) {
            throw new IllegalArgumentException("Debes introducir una calificacion entre 0 y 18");
        }
        this.nombre = nombre;
        this.calificaEdad = calificaEdad;
        this.fechaIncorporacionAlCatalogo = fechaIncorporacionAlCatalogo;
        this.estaDsiponible = estaDsiponible;
    }

    /**
     * Extrae el nombre del catálogo.
     * @return Devuelve el nombre del catálogo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nombre al catálogo.
     * Este Set comprobara si un nombre es válido, en caso de serlo, se le asignará 
     * el valor pasado al atributo.
     * @param nombre //Valor que tendrá el nombre del catálogo.
     */
    public void setNombre(String nombre) {
        if (!nombre.isEmpty() && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    /**
     * Extrae la edad de calificación.
     * 
     * @return Devuelve un entero con el número de edad de calificación.
     */
    public int getCalificaEdad() {
        return calificaEdad;
    }

    /**
     * Establece la edad de calificación.
     * Este Set comprobará si una edad dentro de un rago es válido, en caso de 
     * serlo, se le asignará el valor pasado al atributo.
     * @param calificaEdad //Valor que tendrá la calificación de edad.
     */
    public void setCalificaEdad(int calificaEdad) {
        if (calificaEdad > 0 && calificaEdad < 19) {
            this.calificaEdad = calificaEdad;
        }
    }

    /**
     * Extrae la fecha de incorporación al catálogo.
     *
     * @return Devolverá la fecha de incorporación al catálogo.
     */
    public LocalDate getFechaIncorporacionAlCatalogo() {
        return fechaIncorporacionAlCatalogo;
    }

    /**
     * Establece la fecha de incorporación.
     * Este Set asignará la fecha pasado al atributo.
     * @param fechaIncorporacionAlCatalogo //Valor que tendrá la fecha de
     * incorporación del catálogo.
     */
    public void setFechaIncorporacionAlCatalogo(LocalDate fechaIncorporacionAlCatalogo) {
        this.fechaIncorporacionAlCatalogo = fechaIncorporacionAlCatalogo;
    }

    /**
     * Establece la disponibilidad.
     * Este Set asignará un valor booleano al atributo disponibilidad.
     * @param estaDsiponible //Valor que tendrá la disponibilidad del catálogo.
     */
    public void setEstaDsiponible(boolean estaDsiponible) {
        this.estaDsiponible = estaDsiponible;
    }

    /**
     * Establece la disponibilidad en el catálogo.
     *
     * @return Devolverá true si está disponible y false si no.
     */
    public boolean getEstaDsiponible() {
        return estaDsiponible;
    }

    /**
     * Mostrar objeto por pantalla.
     * @return Mensaje por pantalla con información detallada del catálogo.
     */
    @Override
    public String toString() {
        return "\n\tNombre: " + nombre + "\n\tClasificación de edad: " + calificaEdad + "\n\tFecha de incorporación: " + fechaIncorporacionAlCatalogo + "\n\tDisponibilidad: " + estaDsiponible + "\n";
    }

    /**
     * Compara si dos objetos son iguales.
     * @param obj El valor de media que se usará para compararlo con el de media actual.
     * Dos elementos media son iguales si su nombre y calificación edad lo son.
     * @return Devolverá true si hay un objeto media igual, si no devolverá false.
     */
    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Media)) {
            return false;
        }

        Media m = (Media) obj;
        if (this.calificaEdad == m.calificaEdad && this.nombre.equals(m.nombre)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Ordenación
     * @param m El valor de media que se usará para comparar.
     * @return Si el objeto media es alfabéticamente mayor que m la función devolverá un número positivo
     * si el objeto m es alfabéticamente mayor que media la función devolverá un número negativo
     *  y si dos cadenas coincidieran alfabéticamente, se compararán por la media de sus calificaciones
     * siendo menor que tenga la calificación más baja.
     */
    @Override
    public int compareTo(Media m) {
        int nombreComparacion = nombre.compareTo(m.getNombre());
        if (nombreComparacion == 0) {
            return Integer.compare(calificaEdad, m.getCalificaEdad());
        }
        return nombreComparacion;
    }
}
