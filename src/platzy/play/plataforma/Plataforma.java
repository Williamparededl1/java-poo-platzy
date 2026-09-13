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

    public void eliminarContenido(Pelicula pelicula) {
        contenido.remove(pelicula);
    }

    public List<Pelicula> getContenidos() {
        return contenido;
    }

    public String getNombre() {
        return nombre;
    }
}
