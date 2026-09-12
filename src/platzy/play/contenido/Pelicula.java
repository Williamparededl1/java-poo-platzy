package platzy.play.contenido;

import java.time.LocalDate;

public class Pelicula {

    public String titulo;
    public String descripcion;
    public int duraCion;
    public String genero;
    public LocalDate fechaEstreno;
    public double calificacion;
    public boolean disponible;

    public Pelicula(String titulo, int duracion ,String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.duraCion = duracion;
        this.fechaEstreno = LocalDate.now();
        this.disponible = true;
    }

    public Pelicula(String titulo, int duraCion, String genero, double calificacion) {

        this(titulo,duraCion, genero);
        this.calificar(calificacion);
    }

    public void reprodducir () {
        System.out.println("Reproduciendo " +titulo);
    }

    public String obtenerFichaTecnica () {
        return titulo + " ("+ fechaEstreno.getYear() + ")\n" +
                " Genero: " + genero +"\n" +
                " Calificacion: " + calificacion +"\5";
    }

    public void calificar (double calificacion){

        if (calificacion >= 0 && calificacion <= 5){
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular() {
        return calificacion >=4;
    }

}