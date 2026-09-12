package platzy.play;

import platzy.play.contenido.Pelicula;
import platzy.play.plataforma.Usuario;
import platzy.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "PELICULAS PLATZY";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        System.out.println(NOMBRE_PLATAFORMA+" v:" +VERSION);




        String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quiere ver");
        String generoPelicula = ScannerUtils.capturarTexto("Que genero es la pelicula que quiere ver");
        int duracionPelicula = ScannerUtils.capturarNumero("Cuanto dura la pelicula mins ");
        double calificacionPelicula = ScannerUtils.capturarDecimal("tu calificacion  del 1 - 5");


        Pelicula pelicula = new Pelicula(nombrePelicula,duracionPelicula,generoPelicula,calificacionPelicula);


        System.out.println(pelicula.obtenerFichaTecnica());

        String nombreUsuario = ScannerUtils.capturarTexto("cual es nombre tu nombre");
        String emailUsuario = ScannerUtils.capturarTexto("ingresa tu correo");

        Usuario  usuario = new Usuario(nombreUsuario,emailUsuario);

@
        usuario.ver(pelicula);
        System.out.println(usuario.fechaRegistro);




    }
}
