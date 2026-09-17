package platzy.play.excepcion;

public class PeliculaExistenteException extends RuntimeException{

    public PeliculaExistenteException (String titulo){
        super("La pelicula con el titulo: " + titulo + " ya existe");
    }

}
