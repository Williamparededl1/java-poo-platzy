package platzy.play.contenido;

public class Documental extends Contenido {
    private String narrador ;

    public Documental(String titulo, int duraCion, Genero genero, double calificacion, String narrador) {
        super(titulo, duraCion, genero, calificacion);
        this.narrador = narrador;
    }

    public String getNarrador() {
        return narrador;
    }
}
