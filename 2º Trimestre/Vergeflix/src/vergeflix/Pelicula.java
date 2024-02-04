package vergeflix;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase encargará de modelar un elemento película. 
 * Es una versión inicial que he creado sobre el trabajo de Vergeflix.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class Pelicula extends Media {

    private String director;
    private String actorPrincipal;
    private int duracion;
    private Tematica categoria;
    private ArrayList<Integer> votos;

    /**
     * Contrucción el objeto Película. 
     * Se construirá un objeto con el nombre del directo, del director principal,
     * su duración, la categoría a la que perteneces, su nombre, su calificación
     * de edad, su fecha de incorporación al catálogo y su disponibilidad.
     * Todos los parámetros son validados, en caso de no ser corrector se
     * lanzará un IllegalArgumentException.
     * 
     * @param director //Nombre del director.
     * @param actorPrincipal //Nombre del actor principal.
     * @param duracion //Duración de la película.
     * @param categoria //Categoría a la que pertenece la película.
     * @param nombre //Nombre de la película
     * @param calificaEdad //La edad de calificación
     * @param fechaIncorporacionAlCatalogo //La fecha de incorporación al catálogo,
     * @param estaDsiponible //La disponibilidad
     * 
     * @throws duracion, en caso de que el número introducido no se encuentre en el rango lanzara excepción.
     * @throws director, en caso de ser un nombre vacío se lanzará una excepción.
     * @throws actorPrincipal, en caso de ser un nombre vacío se lanzará una excepción.
     */
    public Pelicula( String nombre, int calificaEdad, LocalDate fechaIncorporacionAlCatalogo, boolean estaDsiponible, String director, String actorPrincipal, int duracion, Tematica categoria) {
        super(nombre, calificaEdad, fechaIncorporacionAlCatalogo, estaDsiponible);
        if (duracion < 60 || duracion > 240) {
            throw new IllegalArgumentException("Debes introducir una duración valida(60-240 mnts).");
        }
        if (director.isBlank() || director.isEmpty() || director.length()<5) {
            throw new IllegalArgumentException("Debes introducir un nombre válido.");

        }
        if (actorPrincipal.isBlank() || actorPrincipal.isEmpty() || director.length()<5) {
            throw new IllegalArgumentException("Debes introducir un nombre válido.");

        }
        this.director = director;
        this.actorPrincipal = actorPrincipal;
        this.duracion = duracion;
        this.categoria = categoria;
        this.votos = new ArrayList<>();
    }

    /**
     * Construye una copia Película a través de un único parámetro.
     * Se construirá un objeto con un valor(p), copiando los parámetros 
     * de otro objeto(Película).
     * 
     * @param p El valor de la película que se usará para crearlo.
     */
    public Pelicula(Pelicula p) {
        super(p.getNombre(), p.getCalificaEdad(), p.getFechaIncorporacionAlCatalogo(), p.getEstaDsiponible());
        this.director = p.director;
        this.actorPrincipal = p.actorPrincipal;
        this.duracion = p.duracion;
        this.categoria = p.categoria;
        this.votos = new ArrayList<>(p.votos);

    }

    /**
     * Extrae el nombre del director.
     * 
     * @return Devuelve el nombre del director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Establece un nombre al director.
     * Este Set comprobará si un nombre es válido, en caso de serlo, se le asignará 
     * el valor pasado al atributo.
     * @param director //Valor que tendrá el nombre del director.
     */
    public void setDirector(String director) {
        if (!director.isBlank() && !director.isEmpty() && director.length()>=5) {
            this.director = director;
        }
    }

    /**
     * Extrae el nombre del actor principal.
     * 
     * @return Devuelve el nombre del actor principal.
     */
    public String getActorPrincipal() {
        return actorPrincipal;
    }

    /**
     * Establece un nombre al actor principal.
     * Este Set comprobará si un nombre es válido, en caso de serlo, se le asignará 
     * el valor pasado al atributo.
     * @param actorPrincipal //Valor que tendrá el nombre del actor principal.
     */
    public void setActorPrincipal(String actorPrincipal) {
        if (!actorPrincipal.isBlank() && !actorPrincipal.isEmpty() && actorPrincipal.length()>=5) {
            this.actorPrincipal = actorPrincipal;
        }
    }

    /**
     * Extrae la duración de la película.
     * 
     * @return Devuelve un entero con la duración de la película.
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración.
     * Este Set comprobará si una duración está dentro de un rango es válido, en caso de 
     * serlo, se le asignará el valor pasado al atributo.
     * @param duracion //Valor que tendrá la duración de la película.
     */
    public void setDuracion(int duracion) {
        if (duracion >= 60 && duracion <= 240) {
            this.duracion = duracion;
        }
    }

    /**
     * Extrae la categoría de la película.
     * 
     * @return Devolverá una categoría dentro de un ENUM.
     */
    public Tematica getCategoria() {
        return categoria;
    }

    /**
     * Establece una categoría a la película dentro de un ENUM.
     * 
     * @param categoria //Categoría dentro de un ENUM que tomara una película.
     */
    public void setCategoria(Tematica categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Establecer un voto a la película.
     * Esta función se encargará de establecer los votos a la película.

     * @param voto //Valor que tendrá el voto (0-10) para la película
     * @return Devolverá false si el voto se añadió correctamente y true si lo hizo
     */
    public boolean votar(int voto) {
        boolean votado = false;
        if (voto >= 0 && voto <= 10) {
            votos.add(voto);
            votado = true;
        }
        return votado;
    }

    /**
     * Mostrar objeto por pantalla.
     * @return Mensaje por pantalla con información detallada de la película.
     */
    @Override
    public String toString() {
        return "\n\nPelicula:"+super.toString()+"\tDirector: " + director + "\n\tActor Principal: " + actorPrincipal + "\n\tDuración: " + duracion +"\n\tCategoria: "+ categoria + "\n\tVotos; "+votos;
    }

     /**
     * Calcular puntuación, película.
     * Se encargará de calcular la media de votos que tiene una película,
     * lo hará sumando votos, en caso de ser 0  la puntuación será 0, 
     * si no dividirá la suma de los votos por la cantidad de votos.
     * @return Devolverá la media de votos de una película.
     */
    @Override
    public int calcularPuntuacion() {
        int sumaVotos = 0;
        int total = 0;
        int numVotos = votos.size();
        for (int i = 0; i < numVotos; i++) {
            sumaVotos += votos.get(i);
        }
        if (numVotos != 0){
            total = sumaVotos / numVotos;
        }
        return total;
    }    
}
