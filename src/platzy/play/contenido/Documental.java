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

    @Override
    public void reprodducir() {
        System.out.println("Reproduciendo el documental " +getTitulo()+ " con el narrador " +getNarrador());
    }

    @Override
    public String obtenerFichaTecnica() {
        return getTitulo() + " ("+ getFechaEstreno().getYear() + ")\n" +
                "Genero: " + getGenero().toString() +"\n" +
                "Calificacion: " + getCalificacion() +"/5 \n"+
                "Narrador: " + getNarrador();
    }
}
