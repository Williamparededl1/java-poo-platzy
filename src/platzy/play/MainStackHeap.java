package platzy.play;

import platzy.play.contenido.Pelicula;

public class MainStackHeap {
    public static void main(String[] args) {
        Pelicula reyLeon = new Pelicula("Rey Leon", 120, "Animacion");
        Pelicula harryPotter = new Pelicula("Harry Potter", 120, "Accion");

        reyLeon = harryPotter;

        reyLeon.titulo = "Rey simba";

        System.out.println("rey leon " +reyLeon.titulo);
        System.out.println("Herry Potter " + harryPotter.titulo);
    }
}
