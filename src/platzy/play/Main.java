package platzy.play;

import platzy.play.contenido.Pelicula;
import platzy.play.plataforma.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("PELICULAS !!!!! ");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = "Monster INC  2";
        pelicula.fechaEstreno = LocalDate.of(2006,10,14);
        pelicula.genero = "Animacion";
        pelicula.calificar(4.5);

        System.out.println(pelicula.obtenerFichaTecnica());

        Usuario  usuario = new Usuario();
        usuario.nombre = "Juan";
        usuario.fechaRegistro = LocalDateTime.now();

        usuario.ver(pelicula);
        System.out.println(usuario.fechaRegistro);

//        Scanner scanner  = new Scanner(System.in);
//
//        System.out.println("Cual es tu nombre?");
//
//        String nombre = scanner.nextLine();
//
//        System.out.println("Ya era hora de aprender java "+ nombre +" buen viaje");
//
//        System.out.println(nombre +" cual es tu edad?");
//
//        Integer edad = scanner.nextInt();
//
//        System.out.println(edad +" mmmm ya estas viejo");


    }
}
