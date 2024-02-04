package vergeflix;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * Esta clase encargará de modelar un elemento temporada. 
 * Es una versión inicial que he creado sobre el trabajo de Vergeflix.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class Temporada implements Valorable {

    private LocalDate fechaEstreno;
    private ArrayList<Capitulo> capitulos;

    /**
     * Construcción el objeto Temporada. 
     * Se construirá un objeto con la fecha de estreno y un ArrayList de películas. 
     * Todos los parámetros son validados, en caso de no ser corrector se lanzará 
     * un IllegalArgumentException.
     *
     * @param fechaEstreno //La fecha de estreno de la temporada.,
     *
     */
    public Temporada(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
        this.capitulos = new ArrayList<Capitulo>();
    }

    /**
     * Construye una copia Temporada a través de un único parámetro. 
     * Se construirá un objeto con un valor(t), copiando los parámetros de otro
     * objeto(Temporada).
     *
     * @param t El valor de la Temporada que se usará para crearlo.
     */
    public Temporada(Temporada t) {
        this.fechaEstreno = t.fechaEstreno;
        this.capitulos = t.capitulos;
        for (Capitulo capitulo : t.capitulos) {
            this.capitulos.add(capitulo);
        }
    }

    /**
     * Extrae la fecha de estreno de la temporada.
     *
     * @return Devuelve la fecha de estreno de la temporada.
     */
    public LocalDate getFechaestreno() {
        return fechaEstreno;
    }

    /**
     * Extrae los capitulos de una temporada.
     *
     * @return Devuelve los capitulo de una temporada.
     */
    public ArrayList<Capitulo> getCapitulos() {
        return capitulos;
    }

    
    
    /**
     * Añadir un capítulo a la temporada. 
     * Esta función recibirá un objeto capítulo y lo añadirá a la temporada. 
     * Anteriormente, se habrá comprobado que no existe un igual dentro de 
     * dicha temporada.
     *
     * @param capitulo //Objeto capítulo
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(Capitulo capitulo) { //Comprobar
        boolean añadido = false;
        if (buscarCapitulo(capitulo.getTitulo()) < 0 && fechaEstreno.isEqual(capitulo.getFechaEmision()) || fechaEstreno.isBefore(capitulo.getFechaEmision())) {
            this.capitulos.add(new Capitulo(capitulo));
            añadido = true;
        }
        return añadido;
    }

     /**
     * Añadir un capítulo a la temporada.
     * Esta función recibirá una fecha de emisión y un capítulo.
     * Después construirá el objeto capítulo.
     * Anteriormente, se habrá comprobado que no existe un igual dentro de dicha temporada.
     * 
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se emitió
     * @param titulo //Valor que tendrá el nombre del capítulo
     * 
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(LocalDate fechaEmision, String titulo) { //Comprobar
        return añadirCapitulo(new Capitulo(titulo, fechaEmision));
    }

    /**
     * Añadir un capítulo a la temporada en una posición. 
     * Esta función recibirá un objeto capítulo y lo añadirá a la temporada en 
     * una posición exacta. Anteriormente, se habrá comprobado que no existe un 
     * igual dentro de dicha temporada y que la posición está dentro del rango 
     * de la temporada.
     *
     * @param posicion //número entero
     * @param capitulo //Objeto capítulo
     * @return Devolvera true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(int posicion, Capitulo capitulo) { //Comprobar
        boolean añadido = false;
        if (buscarCapitulo(capitulo.getTitulo()) < 0 && fechaEstreno.isEqual(capitulo.getFechaEmision()) || fechaEstreno.isAfter(capitulo.getFechaEmision()) && posicion > 0 || posicion < this.capitulos.size()) {
            this.capitulos.add(posicion, new Capitulo(capitulo));
            añadido = true;
        }
        return añadido;
    }

    /**
     * Añadir un capítulo a la temporada en una posición. 
     * Esta función recibirá un objeto capítulo y lo añadirá a la temporada en 
     * una posición exacta. Después construirá el objeto capítulo. Anteriormente 
     * se habrá comprobado que no existe un igual dentro de dicha temporada y que 
     * la posición está dentro del rango de la temporada.
     *
     * @param posicion //número entero
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se
     * emitió
     * @param titulo //Valor que tendrá el nombre del capítulo
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(int posicion, LocalDate fechaEmision, String titulo) { //Comprobar
        return añadirCapitulo(posicion, new Capitulo(titulo, fechaEmision));
    }

    /**
     * Eliminar capítulo. 
     * Esta función llamará a otra que buscara la posición 
     * del capítulo por su nombre, en caso de encontrarla eliminará el 
     * Capítulo con la posición como parámetro.
     *
     * @param titulo //Valor que tiene el nombre del capítulo
     * @return Devolverá true si se ha podido eliminar y si no, false.
     */
    public boolean eliminarCapitulo(String titulo) { //Comprobar
        boolean eliminado = false;
        int posicion = buscarCapitulo(titulo);
        if (posicion != -1) {
            this.capitulos.remove(posicion);
            eliminado = true;
        }
        return eliminado;

    }

    /**
     * Eliminar capítulo. 
     * Esta función llamará a otra que buscara la posición
     * del capítulo por su nombre, en caso de encontrarla eliminará todos los
     * Capítulos con la posición como parámetro.
     *
     * @param expresionRegular //Valor que contiene una expresión regular.
     * @return Devolverá true si se ha podido eliminar y si no, false.
     */
    public int eliminarCapitulos(String expresionRegular) { //Comprobar //Arreglar
        Pattern expresion = Pattern.compile(expresionRegular);
        int cantidadEliminados = 0;
        for (int i = 0; i < capitulos.size(); i++) {
            if (expresion.matcher(capitulos.get(i).getTitulo()).matches()) {
                capitulos.remove(i);
                cantidadEliminados++;
                i--;
            }
        }
        return cantidadEliminados;
    }

    /**
     * Extrae un capítulo de temporada.
     *
     * @param posicion //posición donde se encuentra el capítulo.
     * @return Devolverá una copia de un capítulo
     */
    public Capitulo getCapitulo(int posicion) { //Comprobar
        Capitulo nuevo = null;
        if (posicion >= 0 && posicion < capitulos.size()) {
            nuevo = new Capitulo(capitulos.get(posicion));
        }
        return nuevo;
    }

    /**
     * Modificar un capítulo en una temporada. 
     * A través de la posición pasa por
     * parámetro trabajaremos con dicho capítulo, podremos cambiar el título y
     * la fecha de emisión a las que se han pasado por parámetro, pero
     * anteriormente, se habrán validado, en caso de que no fueran válida, la
     * función no hará nada.
     *
     * @param posicion //posición donde se insertará el capítulo.
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se
     * emitió
     * @param titulo //Valor que tendrá el nombre del capítulo
     * @return Devolverá true si se ha podido modificar correctamente si no,
     * false.
     */
    public boolean setCapitulo(int posicion, LocalDate fechaEmision, String titulo) { //Comprobar
        boolean modificado = false;
        if (posicion >= 0 && posicion < capitulos.size() && buscarCapitulo(titulo) == -1) {
            if (fechaEstreno.isAfter(fechaEmision)) {
                capitulos.get(posicion).setFechaEmision(fechaEmision);
                modificado = true;
            } else {
                modificado = false;
            }
            if (!titulo.isBlank() && !titulo.isEmpty() && titulo.length() >= 5) {
                capitulos.get(posicion).setTitulo(titulo);
                modificado = true;
            } else {
                modificado = false;
            }
        }
        return modificado;
    }

    /**
     * Modificar un capítulo en una temporada. 
     * A través de la posición pasa por
     * Parámetro trabajaremos con dicho capítulo, podremos cambiar la fecha de
     * emisión por la que se ha pasado por parámetro pero anteriormente se habrá
     * validado, en caso de que no fueran válida, la función no hará nada.
     *
     * @param posicion //número entero
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se
     * emitió
     * @return Devolverá true si se ha podido modificar correctamente si no,
     * false.
     */
    public boolean setCapitulo(int posicion, LocalDate fechaEmision) { //Comprobar
        boolean modificado = false;
        if (posicion >= 0 && posicion < capitulos.size()) {
            if (fechaEstreno.isAfter(fechaEmision)) {
                capitulos.get(posicion).setFechaEmision(fechaEmision);
                modificado = true;
            }
        }
        return modificado;
    }

    /**
     * Modificar un capítulo en una temporada. 
     * A través de la posición pasa por
     * Parámetro trabajaremos con dicho capítulo, podremos cambiar el título por
     * el que se ha pasado por parámetro, pero anteriormente se habrá validado, en
     * caso de que no fueran válida, la función no hará nada.
     *
     * @param posicion //número entero
     * @param titulo //Valor que tendrá el nombre del capítulo
     * @return Devolverá true si se ha podido modificar correctamente si no,
     * false.
     */
    public boolean setCapitulo(int posicion, String titulo) { //Comprobar
        boolean modificado = false;
        if (posicion >= 0 && posicion < capitulos.size() && buscarCapitulo(titulo) == -1) {
            if (!titulo.isBlank() && !titulo.isEmpty() && titulo.length() >= 5) {
                capitulos.get(posicion).setTitulo(titulo);
                modificado = true;
            }
        }
        return modificado;
    }

    /**
     * Establecer puntuación al capítulo. Esta función se encargará de
     * establecer los votos al capítulo.
     *
     * @param posicionCapitulo //Posición donde está el capítulo a votar.
     * @param like //Valor que tendrá el voto (booleano) para el capítulo
     * @return Devolverá true si se ha podido votar y false si no.
     */
    public boolean meGusta(int posicionCapitulo, boolean like) { //Comprobar
        boolean añadido = false;
        if (posicionCapitulo >= 0 && posicionCapitulo < capitulos.size()) {
            capitulos.get(posicionCapitulo).meGusta(like);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Establecer puntuación al capítulo. Esta función se encargará de
     * establecer los votos al capítulo.
     *
     * @param titulo //Se buscará la posición por el título del capítulo.
     * @param like //Valor que tendrá el voto (booleano) para el capítulo
     * @return Devolverá true si se ha podido votar y false si no.
     */
    public boolean meGusta(String titulo, boolean like) { //Comprobar
        boolean añadido = false;
        int pos = buscarCapitulo(titulo);
        if (pos != -1) {
            capitulos.get(pos).meGusta(like);
            añadido = true;
        }
        return añadido;

    }

    /**
     * Establece la fecha de estreno a la temporada
     *
     * @param fecha //Valor que tendrá la fecha de estreno de la temporada.
     * @return Devolverá true si se hizo correctamente y false si no.
     */
    public boolean setFechaEstreno(LocalDate fecha) {
        for (Capitulo capitulo : capitulos) {
            if (fecha.isBefore(capitulo.getFechaEmision())) {
                return false;
            }
        }
        this.fechaEstreno = fecha;
        return true;
    }

    /**
     * Extraer los n mejores capítulos. Este método devolverá una lista con los
     * n capítulos mejor valorados. Esta lista contendrá copias de capítulos.
     * Deberán estar ordenados de mejor a peor.
     *
     * @param n //número de capítulo que queremos extraer.
     * @return Devuelve un ArrayList con los n mejores elementos ordenador de
     * mejor a peor
     */
    public ArrayList<Capitulo> capitulosMejorValorados(int n) {

        ArrayList<Capitulo> MejoresCapitulos = new ArrayList<>();

        for (Capitulo capitulo : this.capitulos) {
            capitulo.calcularPuntuacion();
        }

        Collections.sort(this.capitulos, new Comparator<Capitulo>() {

            public int compare(Capitulo capitulo1, Capitulo capitulo2) {
                return Integer.compare(capitulo2.calcularPuntuacion(), capitulo1.calcularPuntuacion());
            }
        });

        for (int i = 0; i < n && i < this.capitulos.size(); i++) {
            MejoresCapitulos.add(new Capitulo(this.capitulos.get(i))); // Crear una copia del capítulo
        }

        return MejoresCapitulos;

    }

    /**
     * Buscar capítulo. 
     * Recibirá el título de capítulo, recogerá el array
     * capítulos buscando si hay alguno con ese mismo título.
     *
     * @param titulo //Nombre del capítulo.
     * @return Devolverá la posición si lo ha encontrado y si no devolverá -1.
     */
    public int buscarCapitulo(String titulo) {
        for (int i = 0; i < capitulos.size(); i++) {
            if (capitulos.get(i).getTitulo().equals(titulo)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Mostrar objeto por pantalla.
     *
     * @return Mensaje por pantalla con información detallada de la temporada.
     */
    @Override
    public String toString() {
        return "\nTemporada: " + "\n Fecha de estreno: " + fechaEstreno + ", capitulos: " + capitulos + "\n";
    }

    /**
     * Calcular puntuación, temporada. 
     * Se encargará de calcular la media de
     * votos que tiene todos los capítulos, lo hará sumando la puntuación de
     * cada capítulo, en caso de ser 0 la puntuación será 0, si no dividirá la
     * suma de todos los votos por la cantidad de capítulos.
     *
     * @return Devolverá la media de votos de una temporada.
     */
    @Override
    public int calcularPuntuacion() {
        int puntuacionTotal = 0;
        int puntuacionMedia = 0;
        int numCapitulos = this.capitulos.size();
        for (Capitulo capitulo : this.capitulos) {
            puntuacionTotal += capitulo.calcularPuntuacion();
        }
        if (numCapitulos > 0) {
            puntuacionMedia = puntuacionTotal / numCapitulos;
        }

        return puntuacionMedia;
    }

}
