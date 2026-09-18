package platzy.play.contenido;

import java.time.LocalDate;

public abstract class Contenido {

    private String titulo;
    private String descripcion;
    private int duraCion;
    private Genero genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;

    public Contenido(String titulo, int duracion , Genero genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.duraCion = duracion;
        this.fechaEstreno = LocalDate.now();
        this.disponible = true;
    }

    public Contenido(String titulo, int duraCion, Genero genero, double calificacion) {

        this(titulo,duraCion, genero);
        this.calificar(calificacion);
    }

    public abstract void reprodducir ();

    public abstract String obtenerFichaTecnica ();

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

    public int getDuracion() {
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

    public Genero getGenero() {
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