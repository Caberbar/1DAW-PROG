package conversorlistacanciones;

import java.util.Objects;

public class Cancion implements Serializable, Comparable<Cancion> {

    private String titulo;
    private String autor;
    private int duracion;

    public Cancion(String titulo, String autor, int duracion) {
        if (duracion < 1) {
            throw new IllegalArgumentException("La duración debe ser una valor positivo.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (!titulo.isBlank() && !titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (!titulo.isBlank() && !titulo.isEmpty()) {
            this.autor = autor;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }

    }

    @Override
    public boolean equals(Object cancion) {
        if (this == cancion) {
            return true;
        }
        if (cancion == null) {
            return false;
        }
        if (getClass() != cancion.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) cancion;
        if (this.duracion != other.duracion) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }

    @Override
    public int compareTo(Cancion o) {
        return this.duracion - o.duracion;
    }

    @Override
    public String toString() {
        return "Cancion: \n\ttitulo: " + titulo + "\n\tautor: " + autor + "\n\tduracion: " + duracion;
    }

}
