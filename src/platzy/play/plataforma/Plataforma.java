package platzy.play.plataforma;

import platzy.play.contenido.Genero;
import platzy.play.contenido.Pelicula;
import platzy.play.excepcion.PeliculaExistenteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plataforma {

    private String nombre;
    private List<Pelicula> contenido;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregarContenido(Pelicula pelicula) {

        Pelicula existente = this.buscarPorTitulo(pelicula.getTitulo());

        if (existente != null) {
            throw new PeliculaExistenteException(pelicula.getTitulo());
        }

        contenido.add(pelicula);
    }

    public List<String> getTitulos() {

        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
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

    public List<Pelicula> buscarPorGenero(Genero genero) {

        return contenido.stream()
                .filter((contenido) -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<Pelicula> getPopulares (int cantidad) {

        return contenido.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();

    }

    public List<Pelicula> getValoradas () {

        return contenido.stream()
                .filter((contenido) -> contenido.getCalificacion() > 4.8)
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .toList();

    }

    public Pelicula getMasLarga() {
        return contenido.stream()
                .max(Comparator.comparing(Pelicula::getDuraCion))
                .orElse(null);

    }


    public int getDuracionTotal(){

        return contenido.stream()
                .mapToInt(Pelicula::getDuraCion)
                .sum();

    }


    public List<Pelicula> getContenidos() {
        return contenido;
    }

    public String getNombre() {
        return nombre;
    }
}
