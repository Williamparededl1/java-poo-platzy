package platzy.play;

import platzy.play.contenido.Pelicula;
import platzy.play.plataforma.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("PELICULAS !!!!! ");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = "La Era del hielo rama 2 para la prueebaa";
        pelicula.anioEstreno = 2002;
        pelicula.genero = "Animacion";
        pelicula.calificar(4.5);

        System.out.println(pelicula.obtenerFichaTecnica());

        Usuario  usuario = new Usuario();
        usuario.nombre = "Juan";

        usuario.ver(pelicula);

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
