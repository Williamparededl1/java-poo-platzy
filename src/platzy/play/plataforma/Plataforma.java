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


        contenido.forEach((Pelicula pelicula) -> System.out.println(pelicula.obtenerFichaTecnica()));
    }

    public boolean eliminarContenido(Pelicula pelicula) {
        boolean isRemove = false;
        isRemove = contenido.remove(pelicula);
        return isRemove;
    }

    public Pelicula buscarPorTitulo(String titulo) {

        return  contenido.stream()
                .filter((contenido) -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

    }

    public List<Pelicula> buscarPorGenero(String genero) {

        return contenido.stream()
                .filter((contenido) -> contenido.getGenero().equalsIgnoreCase(genero))
                .toList();
    }


    public List<Pelicula> getContenidos() {
        return contenido;
    }

    public String getNombre() {
        return nombre;
    }
}
