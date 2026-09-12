package platzy.play;

import platzy.play.contenido.Pelicula;
import platzy.play.plataforma.Usuario;
import platzy.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("PELICULAS !!!!! ");




        String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quiere ver");
        String generoPelicula = ScannerUtils.capturarTexto("Que genero es la pelicula que quiere ver");
        int duracionPelicula = ScannerUtils.capturarNumero("Cuanto dura la pelicula mins ");
        double calificacionPelicula = ScannerUtils.capturarDecimal("tu calificacion  del 1 - 5");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = nombrePelicula;
        pelicula.fechaEstreno = LocalDate.of(2006,10,14);
        pelicula.genero = generoPelicula;
        pelicula.calificar(calificacionPelicula);
        pelicula.duraCion = duracionPelicula;

        System.out.println(pelicula.obtenerFichaTecnica());

        Usuario  usuario = new Usuario();
        usuario.nombre = "Juan";
        usuario.fechaRegistro = LocalDateTime.now();

        usuario.ver(pelicula);
        System.out.println(usuario.fechaRegistro);




    }
}
