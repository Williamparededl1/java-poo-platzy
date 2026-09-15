package platzy.play.plataforma;

import platzy.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {

    private String nombre;
    private List<Pelicula> contenido;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregarContenido(Pelicula pelicula) {
        contenido.add(pelicula);
    }

    public void mostrarContenido() {
        for (Pelicula pelicula : contenido) {
            System.out.println(pelicula.obtenerFichaTecnica());
        }
    }

    public boolean eliminarContenido(Pelicula pelicula) {
        boolean isRemove = false;
        isRemove = contenido.remove(pelicula);
        return isRemove;
    }

    public Pelicula buscarPorTitulo(String titulo) {
        for (Pelicula pelicula : contenido) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }

    public List<Pelicula> getContenidos() {
        return contenido;
    }

    public String getNombre() {
        return nombre;
    }
}
