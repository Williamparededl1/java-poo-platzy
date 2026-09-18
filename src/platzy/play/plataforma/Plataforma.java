package platzy.play.plataforma;

import platzy.play.contenido.*;
import platzy.play.excepcion.PeliculaExistenteException;
import platzy.play.util.FileUtils;

import java.util.*;

public class Plataforma {

    private String nombre;
    private List<Contenido> contenido;
    private Map<Contenido, Integer> visualizaciones;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agregarContenido(Contenido contenido) {

        Contenido existente = this.buscarPorTitulo(contenido.getTitulo());

        if (existente != null) {
            throw new PeliculaExistenteException(contenido.getTitulo());
        }

        FileUtils.escribirContenido(contenido);

        this.contenido.add(contenido);

    }

    public void reproducir(Contenido contenido) {

        this.contarVisualizaciones(contenido);
        contenido.reprodducir();

    }

    public List<Promocionable> getContenidoPromocionables() {
        return contenido.stream()
                .filter(contenido -> contenido instanceof Promocionable)
                .map(contenidoProm -> (Promocionable) contenidoProm)
                .toList();
    }

    private void contarVisualizaciones(Contenido contenido) {

        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        System.out.println( contenido.getTitulo()+ " se ha reproducido " + conteoActual + " veces");
        visualizaciones.put(contenido, conteoActual + 1);

    }

    public List<String> getTitulos() {

        return contenido.stream()
                .map(Contenido::getTitulo)
                .toList();
    }
    public List<ResumenContenido> getResumenes() {
        return contenido.stream()
                .map(pelicula -> new ResumenContenido(pelicula.getTitulo(), pelicula.getGenero(), pelicula.getDuracion()))
                .toList();
    }

    public boolean eliminarContenido(Contenido contenido) {
        boolean isRemove = false;
        isRemove = this.contenido.remove(contenido);
        return isRemove;
    }

    public Contenido buscarPorTitulo(String titulo) {

        return  contenido.stream()
                .filter((contenido) -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

    }

    public List<Contenido> buscarPorGenero(Genero genero) {

        return contenido.stream()
                .filter((contenido) -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<Contenido> getPopulares (int cantidad) {

        return contenido.stream()
                .sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed())
                .limit(cantidad)
                .toList();

    }

    public List<Contenido> getValoradas () {

        return contenido.stream()
                .filter((contenido) -> contenido.getCalificacion() > 4.8)
                .sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed())
                .toList();

    }

    public Contenido getMasLarga() {
        return contenido.stream()
                .max(Comparator.comparing(Contenido::getDuracion))
                .orElse(null);

    }


    public int getDuracionTotal(){

        return contenido.stream()
                .mapToInt(Contenido::getDuracion)
                .sum();

    }

    public List<Pelicula> getPeliculas() {

        return contenido.stream()
                .filter((contenido) -> contenido instanceof Pelicula)
                .map(contenidofiltraddo -> (Pelicula) contenidofiltraddo )
                .toList();

    }

    public List<Documental> getDocumentales() {

        return contenido.stream()
                .filter((contenido) -> contenido instanceof Documental)
                .map(contenidofiltraddo -> (Documental) contenidofiltraddo )
                .toList();

    }


    public List<Contenido> getContenidos() {
        return contenido;
    }

    public String getNombre() {
        return nombre;
    }
}
