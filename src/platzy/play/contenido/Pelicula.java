package platzy.play.contenido;

public class Pelicula extends Contenido {

    public Pelicula(String titulo, int duraCion, Genero genero, double calificacion) {
        super(titulo, duraCion, genero, calificacion);
    }

    @Override
    public void reprodducir() {
        System.out.println("Reproduciendo la Pelicula " +getTitulo());
    }

    @Override
    public String obtenerFichaTecnica() {
            return getTitulo() + " ("+ getFechaEstreno().getYear() + ")\n" +
                "Genero: " + getGenero().name() +"\n" +
                "Calificacion: " + getCalificacion() +"/5";
    }

}
