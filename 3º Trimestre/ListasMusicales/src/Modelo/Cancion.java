package Modelo;

/**
 * Esta clase crea una canción. Es una versión inicial que he creado sobre el
 * trabajo de Listas Musicalees.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class Cancion {

    private String titulo;
    private String ruta;
    private int duracion;

    /**
     * Crea una nueva instancia de la clase Cancion con los valores
     * especificados. El título, la ruta y la duración se validan antes de
     * asignarlos a los atributos.
     *
     * @param titulo el título de la canción
     * @param ruta la ruta de la canción
     * @param duracion la duración de la canción
     * @throws IllegalArgumentException si alguno de los valores proporcionados
     * no es válido
     */
    public Cancion(String titulo, String ruta, int duracion) { //validar
        if (titulo.isBlank() && titulo.isEmpty()) {
            throw new IllegalArgumentException("Introduce un nombre correcto. ");
        }
        if (ruta.isBlank() && ruta.isEmpty()) {
            throw new IllegalArgumentException("Introduce una ruta correcta. ");
        }
        if (duracion < -1) {
            throw new IllegalArgumentException("Introduce una duración valida. ");
        }
        this.titulo = titulo;
        this.ruta = ruta;
        this.duracion = duracion;
    }

    /**
     * Crea una nueva instancia de la clase Cancion a partir de otra instancia.
     * Realiza una copia de los valores de la canción pasada por parametro.
     *
     * @param c la canción a copiar
     */
    public Cancion(Cancion c) {
        this.titulo = c.getTitulo();
        this.ruta = c.getRuta();
        this.duracion = c.duracion;
    }

    /**
     * Devuelve el título de la canción.
     *
     * @return el título de la canción
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la canción. El título se establece solo si no está
     * en blanco o vacío.
     *
     * @param titulo el título de la canción
     */
    public void setTitulo(String titulo) {
        if (!titulo.isBlank() && !titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }

    /**
     * Devuelve la ruta de la canción.
     *
     * @return la ruta de la canción
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Establece la ruta de la canción. La ruta se establece solo si no está en
     * blanco o vacía.
     *
     * @param ruta la ruta de la canción
     */
    public void setRuta(String ruta) {
        if (!ruta.isBlank() && !ruta.isEmpty()) {
            this.ruta = ruta;
        }
    }

    /**
     * Obtiene la duración de la canción.
     *
     * @return la duración de la canción
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la canción. La duración se establece solo si no
     * menos que 0
     *
     * @param duracion la duración de la canción
     */
    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }
}
