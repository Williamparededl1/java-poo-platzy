package platzy.play.contenido;

public class Pelicula {

    public String titulo;
    public String descripcion;
    public int duraCion;
    public String genero;
    public int anioEstreno;
    public double calificacion;
    public double disponible;

    public void reprodducir () {
        System.out.println("Reproduciendo " +titulo);
    }

    public String obtenerFichaTecnica () {
        return titulo + " ("+ anioEstreno + ")\n" +
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