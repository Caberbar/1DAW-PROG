package vergeflix;

import java.time.LocalDate;

/**
 * Esta clase encargará de modelar un elemento capítulo. 
 * Es una versión inicial que he creado sobre el trabajo de Vergeflix.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class Capitulo implements Valorable {

    private int votosPositivos;
    private int votosNegativos;
    private String titulo;
    private LocalDate fechaEmision;

    /**
     * Construye el objeto capítulo a través de los parámetros titulo y
     * fecha de emisión. 
     * Se construirá un objeto con el título del catálogo y su fecha de emisión.
     * Todos los parámetros son validados, en caso de no ser corrector se
     * lanzará un IllegalArgumentException.
     * @param titulo//Valor que tendrá el nombre del capítulo
     * @param fechaEmision //Valor que tendrá la fecha del capítulo cuando se emitió
     * 
     * @throws Titulo, en caso de ser un título vacío se lanzará una excepción.
     */
    public Capitulo(String titulo, LocalDate fechaEmision) {
        if (titulo.isBlank() || titulo.isEmpty() || titulo.length() < 0) {
            throw new IllegalArgumentException("Debes introducir un título válido.");
        }
        this.titulo = titulo;
        this.fechaEmision = fechaEmision;
        this.votosPositivos = 0;
        this.votosNegativos = 0;
    }

    /**
     * Construye una copia Capítulo a través de un único parámetro.
     * Se construirá un objeto con un valor(c), copiando los parámetros 
     * de otro objeto(Capítulo).
     * 
     * @param c El valor del capítulo que se usará para crearlo.
     */
    public Capitulo(Capitulo c) {
        this(c.getTitulo(), c.getFechaEmision());
        this.votosPositivos = c.votosPositivos;
        this.votosNegativos = c.votosNegativos;
    }

    /**
     * Extrae el número de votos positivos.
     * @return Devuelve el número de votos positivos que tiene el capítulo.
     */
    public int getVotosPositivos() {
        return votosPositivos;
    }

    /**
     * Extrae el número de votos negativos.
     * @return Devuelve el número de votos negativos que tiene el capítulo.
     */
    public int getVotosNegativos() {
        return votosNegativos;
    }

    /**
     * Extrae el título del capítulo.
     * @return Devuelve el nombre del título del capítulo.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un título al capítulo.
     * Este Set comprobará si un título es válido, en caso de serlo, se le asignará 
     * el valor pasado al atributo.
     * @param titulo//Valor que tendrá el título del capítulo.
     */
    public void setTitulo(String titulo) {
        if (!titulo.isBlank() && !titulo.isEmpty() && titulo.length() >= 5) {
            this.titulo = titulo;
        }
    }

    /**
     * Extrae la fecha de emisión del capítulo.
     * @return Devuelve la fecha de emisión del capítulo.
     */
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión al capítulo.
     * 
     * @param fechaEmision //Valor que tendrá la fecha de emisión del capítulo.
     */
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Establecer puntuación al capítulo.
     * Esta función se encargará de establecer los votos al capítulo.
     * @param Like //Valor que tendrá el voto (booleano) para el capítulo
     */
    public void meGusta(boolean Like) {
        if (Like) {
            this.votosPositivos++;
        } else {
            this.votosNegativos++;
        }
    }

    /**
     * Mostrar objeto por pantalla.
     * @return Mensaje por pantalla con información detallada del capítulo.
     */
    @Override
    public String toString() {
        return "\n Capitulo -> Votos +: " + votosPositivos + " / Votos -: " + votosNegativos + " || Titulo: " + titulo + "  | fecha de emisión: " + fechaEmision;
    }

    /**
     * Carcular puntuación, capítulo.
     * Se encargará de calcular la media de votos que tiene un capítulo,
     * lo hará sumando los votos positivos con los negativos, en caso de ser 0 
     * la puntuación será 0, si no multiplicaremos los votos positivos por 10
     * y dividiéndolos por la suma de antes, después lo volveremos a multiplicar 
     * por 10.
     * @return Devolverá la media de votos de un capítulo.
     */
    @Override
    public int calcularPuntuacion() {
        int totalVotos = this.votosPositivos + this.votosNegativos;
        int puntuacion;
        if (totalVotos == 0) {
            puntuacion = 0;
        } else {
            puntuacion = (this.getVotosPositivos() * 10) / totalVotos;
            puntuacion = puntuacion * 10;
        }
        return puntuacion;
    }

}
