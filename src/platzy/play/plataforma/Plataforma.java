package platzy.play.plataforma;

import platzy.play.contenido.Genero;
import platzy.play.contenido.Pelicula;
import platzy.play.contenido.ResumenContenido;
import platzy.play.excepcion.PeliculaExistenteException;

import java.util.*;

public class Plataforma {

    private String nombre;
    private List<Pelicula> contenido;
    private Map<Pelicula, Integer> visualizaciones;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agregarContenido(Pelicula pelicula) {

        Pelicula existente = this.buscarPorTitulo(pelicula.getTitulo());

        if (existente != null) {
            throw new PeliculaExistenteException(pelicula.getTitulo());
        }

        contenido.add(pelicula);

    }

    public void reproducir(Pelicula pelicula) {

        this.contarVisualizaciones(pelicula);
        pelicula.reprodducir();

    }

    private void contarVisualizaciones(Pelicula pelicula) {

        int conteoActual = visualizaciones.getOrDefault(pelicula, 0);
        System.out.println( pelicula.getTitulo()+ " se ha reproducido " + conteoActual + " veces");
        visualizaciones.put(pelicula, conteoActual + 1);

    }

    public List<String> getTitulos() {

        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
    }
    public List<ResumenContenido> getResumenes() {
        return contenido.stream()
                .map(pelicula -> new ResumenContenido(pelicula.getTitulo(), pelicula.getGenero(), pelicula.getDuracion()))
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
                .max(Comparator.comparing(Pelicula::getDuracion))
                .orElse(null);

    }


    public int getDuracionTotal(){

        return contenido.stream()
                .mapToInt(Pelicula::getDuracion)
                .sum();

    }


    public List<Pelicula> getContenidos() {
        return contenido;
    }

    public String getNombre() {
        return nombre;
    }
}
