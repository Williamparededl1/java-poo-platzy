package platzy.play.contenido;

import java.time.LocalDate;

public class Pelicula {

    private String titulo;
    private String descripcion;
    private int duraCion;
    private String genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;

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
                " Calificacion: " + calificacion +"/5";
    }

    public void calificar (double calificacion){

        if (calificacion >= 0 && calificacion <= 5){
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular() {
        return calificacion >=4;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuraCion() {
        return duraCion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuraCion(int duraCion) {
        this.duraCion = duraCion;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }
}