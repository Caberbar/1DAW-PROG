package vergeflix;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase encargará de modelar un elemento serie. Es una versión inicial que
 * he creado sobre el trabajo de Vergeflix.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class Serie extends Media {

    private LocalDate fechaEstreno;
    private ArrayList<Temporada> temporadas;

    /**
     * Construcción el objeto Serie. Se construirá un objeto con la fecha de
     * estreno, su nombre, su calificación de edad, su fecha de incorporación al
     * catálogo y su disponibilidad. Todos los parámetros son validados, en caso
     * de no ser corrector se lanzará un IllegalArgumentException.
     *
     * @param fechaEstreno //Fecha en la que se estrenó la serie
     * @param nombre //Nombre de la película
     * @param calificaEdad //La edad de calificación
     * @param fechaIncorporacionAlCatalogo //La fecha de incorporación al
     * catálogo,
     * @param estaDsiponible //La disponibilidad
     *
     */
    public Serie(String nombre, int calificaEdad, LocalDate fechaIncorporacionAlCatalogo, boolean estaDsiponible,LocalDate fechaEstreno) {
        super(nombre, calificaEdad, fechaIncorporacionAlCatalogo, estaDsiponible);
        this.fechaEstreno = fechaEstreno;
        this.temporadas = new ArrayList<>();
    }

    /**
     * Construye una copia Serie a través de un único parámetro. Se construirá
     * un objeto con un valor(s), copiando los parámetros de otro objeto(Serie).
     *
     * @param s El valor de la Serie que se usará para crearlo.
     */
    public Serie(Serie s) {
        super(s.getNombre(), s.getCalificaEdad(), s.getFechaIncorporacionAlCatalogo(), s.getEstaDsiponible());
        this.fechaEstreno = s.getFechaEstreno();
        this.temporadas = s.temporadas;
        for (Temporada temporada : s.temporadas) {
            this.temporadas.add(temporada);
        }
    }

    /**
     * Extrae la fecha de estreno de la serie.
     *
     * @return Devuelve la fecha de estreno de la serie.
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    
    /**
     * Extrae las temporadas de una serie..
     *
     * @return Devuelve las temporadas de una serie.
     */
    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }
    
    /**
     * Añadir una temporada a la serie. Esta función recibirá una fecha de
     * estreno. Después construirá el objeto temporada. Anteriormente, se habrá
     * comprobado que no existe una igual dentro de dicha serie.
     *
     * @param fechaEstreno //Valor que tendrá la fecha de la temporada cuando se
     * estrenó.
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirTemporada(LocalDate fechaEstreno) { //PROBAR
        boolean añadido = false;

        Temporada t = new Temporada(fechaEstreno);

        if (!temporadas.contains(t)) {
            temporadas.add(t);
            añadido = true;

        }
        return añadido;
    }

    /**
     * Añadir una temporada a la serie. Esta función recibirá un objeto
     * temporada y lo añadirá a la serie. Anteriormente, se habrá comprobado que
     * no existe una igual dentro de dicha temporada.
     *
     * @param temporada //Objeto temporada.
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirTemporada(Temporada temporada) { //probar
        boolean añadido = false;

        if (!(temporadas.contains(temporada))) {
            temporadas.add(temporada);
            añadido = true;
        }

        return añadido;
    }

    /**
     * Eliminar Temporada. Esta función eliminará la temporada que esté en la
     * posición pasada por Parámetro, pero validando que este está este en el
     * rango del Array.
     *
     * @param n //posición de la temporada.
     * @return Devolverá true si se ha podido eliminar y si no, false.
     */
    public boolean eliminarTemporada(int n) {
        boolean eliminado = false;
        if (n >= 0 && n <= temporadas.size()) {
            temporadas.remove(n);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Añadir un capítulo a la serie en una temporada. Esta función recibirá un
     * objeto capítulo y lo añadirá a una temporada en una posición exacta.
     * Anteriormente, se habrá comprobado que no existe un capítulo igual dentro
     * de dicha temporada y que la posición está dentro del rango de la
     * temporada y que la temporada esté en el rango de las temporadas de la
     * serie.
     *
     * @param nTemporada //número entero, temporada.
     * @param capitulo //Objeto capítulo.
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(int nTemporada, Capitulo capitulo) {
        boolean añadido = false;
        if (nTemporada >= 1 && nTemporada <= temporadas.size()) {
            Temporada temporada = temporadas.get(nTemporada - 1);
            temporada.añadirCapitulo(capitulo);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Añadir un capítulo a la serie en una temporada. Esta función recibirá una
     * fecha de emisión y un título, se construirá el objeto capítulo y lo
     * añadirá a una temporada en una posición exacta. Anteriormente, se habrá
     * comprobado que no existe un capítulo igual dentro de dicha temporada y
     * que la posición está dentro del rango de la temporada y que la temporada
     * este en el rango de las temporadas de la serie.
     *
     * @param nTemporada //número entero, temporada.
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se
     * emitió
     * @param titulo //Valor que tendrá el nombre del capítulo
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(int nTemporada, LocalDate fechaEmision, String titulo) {
        boolean añadido = false;
        if (nTemporada >= 1 && nTemporada <= temporadas.size()) {
            Capitulo capitulo = new Capitulo(titulo, fechaEmision);
            if (temporadas.get(nTemporada).buscarCapitulo(titulo) == -1) {
                if (!fechaEmision.isBefore(temporadas.get(nTemporada).getFechaestreno())) {
                    temporadas.get(nTemporada).añadirCapitulo(capitulo);
                    añadido = true;
                }
            }
        }
        return añadido;
    }

    /**
     * Añadir un capítulo a la serie en una temporada. Esta función recibirá un
     * objeto capítulo y lo añadirá a una temporada exacta en una posición
     * exacta. Después construirá el objeto capítulo. Anteriormente, se habrá
     * comprobado que no existe un capítulo igual dentro de dicha temporada y
     * que la posición está dentro del rango de la temporada y que la temporada
     * esté en el rango de las temporadas de la serie.
     *
     * @param nTemporada //número entero, temporada.
     * @param posicion //número entero
     * @param capitulo //Objeto capítulo
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(int nTemporada, int posicion, Capitulo capitulo) {
        boolean añadido = false;
        if (nTemporada >= 1 && nTemporada <= temporadas.size()) {
            if (temporadas.get(nTemporada).buscarCapitulo(capitulo.getTitulo()) == -1) {
                if (!capitulo.getFechaEmision().isBefore(temporadas.get(nTemporada).getFechaestreno())) {
                    temporadas.get(nTemporada).añadirCapitulo(posicion, capitulo);
                    añadido = true;
                }

            }
        }
        return añadido;
    }

    /**
     * Añadir un capítulo a la serie en una temporada. Esta función recibirá una
     * fecha de emisión y un título, se construirá el objeto capítulo y lo
     * añadirá a una temporada exacta en una posición exacta. Anteriormente, se
     * habrá comprobado que no existe un capítulo igual dentro de dicha
     * temporada y que la posición está dentro del rango de la temporada y que
     * la temporada este en el rango de las temporadas de la serie.
     *
     * @param nTemporada ///número entero, temporada.
     * @param posicion //número entero
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se
     * emitió
     * @param titulo //Valor que tendrá el nombre del capítulo
     * @return Devolverá true si se ha podido añadir y si no, false.
     */
    public boolean añadirCapitulo(int nTemporada, int posicion, LocalDate fechaEmision, String titulo) {
        boolean añadido = false;
        if (nTemporada >= 1 && nTemporada <= temporadas.size()) {
            if (temporadas.get(nTemporada).buscarCapitulo(titulo) == -1) {
                if (!fechaEmision.isBefore(temporadas.get(nTemporada).getFechaestreno())) {
                    temporadas.get(nTemporada).añadirCapitulo(posicion, fechaEmision, titulo);
                    añadido = true;
                }
            }
        }
        return añadido;
    }

    /**
     * Eliminar capítulo. Esta función llamará a otra que buscara la posición
     * del capítulo por su nombre, en caso de encontrarla eliminará el Capítulo
     * con la posición como parámetro en una temporada exacta, pasada por
     * parámetro.
     *
     * @param nTemporada ///número entero, temporada.
     * @param titulo //Valor que tiene el nombre del capítulo
     * @return Devolverá true si se ha podido eliminar y si no, false.
     */
    public boolean eliminarCapitulo(int nTemporada, String titulo) {
        boolean eliminado = false;
        if (nTemporada >= 1 && nTemporada <= temporadas.size()) {
            Temporada temporada = temporadas.get(nTemporada);
            eliminado = temporada.eliminarCapitulo(titulo);
            temporada.eliminarCapitulo(titulo);
        }
        return eliminado;
    }

    /**
     * Eliminar capítulo. Esta función llamará a otra que buscara la posición de
     * todos los capítulo que concuerden con dicha expresión regular, en caso de
     * encontrarla, eliminará el capítulo o varios.      *
     * @param expresionRegular //Es una expresión regular.
     * @return Devolverá un contador con los capítulos eliminados.
     */
    public int eliminarCapitulo(String expresionRegular) { //Arreglar
        int contador = 0;
        for (Temporada temporada : temporadas) {
            contador += temporada.eliminarCapitulos(expresionRegular);
        }
        return contador;
    }

    /**
     * Extrae un capítulo de temporada exacta.
     *
     * Se buscará un capítulo en una posición exacta en una temporada en una
     * posición exacta y se devolverá una copia.
     *
     * @param nTemporada //posición de la temporada con la que se trabajara.
     * @param posicion //posición donde se encuentra el capítulo.
     * @return Devolverá una copia de un capítulo
     */
    public Capitulo getCapitulo(int nTemporada, int posicion) {
        Capitulo capitulo = null;
        if (nTemporada >= 0 && nTemporada < temporadas.size()) {
            Temporada temporada = temporadas.get(nTemporada);
            capitulo = new Capitulo(temporada.getCapitulo(posicion));
        }
        return capitulo;
    }

    /**
     *
     * Modificar un capítulo en una temporada exacta. A través de la posición
     * pasada para la posición del capítulo y de la temporada por parámetro
     * trabajaremos con dicho capítulo, podremos cambiar el título y la fecha de
     * emisión a las que se han pasado por parámetro, pero anteriormente, se
     * habrán validado, en caso de que no fueran válida, la función no hará
     * nada.
     *
     * @param nTemporada //posición de la temporada con la que se trabajara.
     * @param posicion //posición donde se insertará el capítulo.
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se
     * emitió
     * @param titulo //Valor que tendrá el nombre del capítulo
     * @return Devolverá true si se ha podido modificar correctamente si no,
     * false.
     */
    public boolean setCapitulo(int nTemporada, int posicion, LocalDate fechaEmision, String titulo) {
        boolean añadido = false;
        if (nTemporada >= 0 && nTemporada < temporadas.size()) {
            if (fechaEmision.isAfter(this.temporadas.get(nTemporada).getFechaestreno())) {
                if (!titulo.isBlank() && !titulo.isEmpty() && titulo.length() >= 5) {
                    Temporada temporada = temporadas.get(nTemporada);
                    temporada.setCapitulo(posicion, fechaEmision, titulo);
                    añadido = true;
                }
            }
        }
        return añadido;
    }

    /**
     * Modificar un capítulo en una temporada. A través de la posición pasa para
     * la posición del capítulo y de la temporada por Parámetro trabajaremos con
     * dicho capítulo, podremos cambiar la fecha de emisión por la que se ha
     * pasado por parámetro pero anteriormente se habrá validado, en caso de que
     * no fueran válida, la función no hará nada.
     *
     * @param nTemporada //posición de la temporada con la que se trabajara.
     * @param posicion //posición donde se insertará el capítulo.
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se
     * emitió
     * @return Devolverá true si se ha podido modificar correctamente si no,
     * false.
     */
    public boolean setCapitulo(int nTemporada, int posicion, LocalDate fechaEmision) {
        boolean añadido = false;
        if (nTemporada >= 0 && nTemporada < temporadas.size()) {
            if (fechaEmision.isAfter(this.temporadas.get(nTemporada).getFechaestreno())) {
                Temporada temporada = temporadas.get(nTemporada);
                temporada.setCapitulo(posicion, fechaEmision);
                añadido = true;
            }
        }
        return añadido;
    }

    /**
     ** Modificar un capítulo en una temporada. A través de la posición pasa
     * para la posición del capítulo y de la temporada por Parámetro
     * trabajaremos con dicho capítulo, podremos cambiar el título por el que se
     * ha pasado por parámetro, pero anteriormente se habrá validado, en caso de
     * que no fueran válida, la función no hará nada.
     *
     * @param nTemporada //posición de la temporada con la que se trabajara.
     * @param posicion //posición donde se insertará el capítulo.
     * @param titulo //Valor que tendrá el nombre del capítulo
     * @return Devolverá true si se ha podido modificar correctamente si no,
     * false.
     */
    public boolean setCapitulo(int nTemporada, int posicion, String titulo) {
        boolean añadido = false;
        if (nTemporada >= 0 && nTemporada < temporadas.size()) {
            if (!titulo.isBlank() && !titulo.isEmpty() && titulo.length() >= 5) {
                Temporada temporada = temporadas.get(nTemporada);
                temporada.setCapitulo(posicion, titulo);
                añadido = true;
            }

        }
        return añadido;

    }

    /**
     * Establecer puntuación al capítulo. Esta función se encargará de
     * establecer los votos al capítulo de una temporada que es pasada su
     * posición por parámetro.
     *
     * @param nTemporada //posición de la temporada con la que se trabajara.
     * @param posicionCapitulo //Posición donde está el capítulo a votar.
     * @param like //Valor que tendrá el voto (booleano) para el capítulo
     * @return Devolverá true si se ha podido votar y false si no.
     */
    public boolean meGusta(int nTemporada, int posicionCapitulo, boolean like) {
        boolean añadido;
        if (nTemporada < 1 || nTemporada > temporadas.size()) {
            añadido = false;
        } else {
            Temporada temporada = temporadas.get(nTemporada - 1);
            temporada.meGusta(posicionCapitulo, like);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Establecer puntuación al de una temporada. Esta función se encargará de
     * establecer los votos al capítulo de una temporada que es pasada su
     * posición por parámetro.
     *
     * @param nTemporada //posición de la temporada con la que se trabajara.
     * @param titulo //Se buscará la posición por el título del capítulo.
     * @param like //Valor que tendrá el voto (booleano) para el capítulo
     * @return Devolverá true si se ha podido votar y false si no.
     */
    public boolean meGusta(int nTemporada, String titulo, boolean like) {
        boolean añadido;
        if (nTemporada < 1 || nTemporada > temporadas.size()) {
            añadido = false;
        } else {
            Temporada temporada = temporadas.get(nTemporada - 1);
            temporada.meGusta(titulo, like);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Establece la fecha de estreno a la serie
     *
     * @param fecha //Valor que tendrá la fecha de estreno de la serie.
     * @return Devolverá true si se hizo correctamente y false si no.
     */
    public boolean setFechaEstreno(LocalDate fecha) {
        boolean cambio = false;
        for (Temporada temporada : temporadas) {
            if (temporada.getFechaestreno().isAfter(fecha) || temporada.getFechaestreno().equals(fecha)) {
                this.fechaEstreno = fecha;
                cambio = true;
            }
        }
        return cambio;
    }

    /**
     * Copia de una temporada. Se creará un objeto nuevo en el que copiaremos la
     * temporada que se Encuentra en la posición pasada por parámetro.
     *
     * @param nTemporada //Posición de una temporada.
     * @return Devolverá un objeto temporada, copiado de otra objeto.
     */
    public Temporada getCopiaTemporada(int nTemporada) {
        Temporada copia;
        if (nTemporada >= 0 && nTemporada < temporadas.size()) {
            copia = new Temporada(temporadas.get(nTemporada));
        } else {
            copia = null;
        }
        return copia;
    }

    /**
     * Buscar capítulo. Recibirá la fecha de la temporada, recogerá el array
     * temporadas buscando si hay alguna con esa misma fecha.
     *
     * @param fechaEstreno //Valor que tiene la fecha de estreno de la serie.
     * @return Devolverá la posición si lo ha encontrado y si no devolverá -1.
     */
    public int buscarTemporada(LocalDate fechaEstreno) {
        int encontrada = -1;
        for (int i = 0; i < temporadas.size(); i++) {
            if (temporadas.get(i).getFechaestreno().equals(fechaEstreno)) {
                encontrada = i;
            }
        }
        return encontrada;
    }

    /**
     * Mostrar objeto por pantalla.
     *
     * @return Mensaje por pantalla con información detallada de la serie.
     */
    @Override
    public String toString() {
        return "\n\nSerie: " + super.toString() + "\n Fecha de estreno: " + fechaEstreno + "\n Temporadas: " + temporadas + "\n";
    }

    /**
     * Calcular puntuación, temporada. Se encargará de calcular la media de
     * votos que tiene todos los capítulos en cada una temporada de la serie, lo
     * hará sumando la puntuación de cada capítulo, en caso de ser 0 la
     * puntuación será 0, si no dividirá la suma de todos los votos por la
     * cantidad de votos totales que hay.
     *
     * @return Devolverá la media de votos de una serie.
     */
    @Override
    public int calcularPuntuacion() {
        int calculo = 0;
        if (!temporadas.isEmpty()) {
            int votosTotales = 0;
            int sumaValoracionesTemporadas = 0;
            for (Temporada temporada : temporadas) {
                int valoracionTemporada = temporada.calcularPuntuacion();
                if (valoracionTemporada > 0) {
                    votosTotales++;
                    sumaValoracionesTemporadas += valoracionTemporada;
                }
            }
            if (votosTotales > 0) {
                calculo = sumaValoracionesTemporadas / votosTotales;
            }
        }
        return calculo;
    }
}
