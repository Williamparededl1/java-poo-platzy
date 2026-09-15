package platzy.play;

import platzy.play.contenido.Pelicula;
import platzy.play.plataforma.Plataforma;
import platzy.play.plataforma.Usuario;
import platzy.play.util.ScannerUtils;



public class Main {
    public static final String NOMBRE_PLATAFORMA = "PELICULAS PLATZY";
    public static final String VERSION = "1.0.0";
    public static final int AGREGAR_PELICULA = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_PELICULA = 3;
    public static final int ELIMINAR_PELICULA = 4;
    public static final int SALIR = 5;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        cargarDatosIniciales(plataforma);

        while(true){

            System.out.println(NOMBRE_PLATAFORMA+" v:" +VERSION);

            int opcionElegida = ScannerUtils.capturarNumero("""
                    System.out.println(NOMBRE_PLATAFORMA+" v:" +VERSION);
                    Ingrese una opcion:
                    1. Agregar Pelicula
                    2. Mostrar Todo
                    3. Buscar por titulo
                    4. Eliminar Pelicula
                    5. Salir
                    """);
            System.out.println("Opcion Elegida: "+ opcionElegida);

            switch (opcionElegida){
                case AGREGAR_PELICULA -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quiere ver");
                    String generoPelicula = ScannerUtils.capturarTexto("Que genero es la pelicula que quiere ver");
                    int duracionPelicula = ScannerUtils.capturarNumero("Cuanto dura la pelicula mins ");
                    double calificacionPelicula = ScannerUtils.capturarDecimal("tu calificacion  del 1 - 5");


                    plataforma.agregarContenido(new Pelicula(nombrePelicula, duracionPelicula, generoPelicula, calificacionPelicula));
                }
                case MOSTRAR_TODO -> plataforma.mostrarContenido();

                case BUSCAR_PELICULA -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quieres buscar");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombrePelicula);

                    if (pelicula != null) {
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println("No se encontro la pelicula dentro de "+plataforma.getNombre());
                    }

                }
                case ELIMINAR_PELICULA -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quieres eliminnar");
                    Pelicula peliculaEliminar = plataforma.buscarPorTitulo(nombrePelicula);

                    if (pelicula != null) {
                        boolean eliminar = plataforma.eliminarContenido(peliculaEliminar);
                        if (eliminar){
                            System.out.println("La pelicula "+nombrePelicula+" ha sido eliminada");
                        } else {
                            System.out.println("La pelicula "+nombrePelicula+" no se pudo eliminaR");
                        }

                    } else {
                        System.out.println("No se encontro la pelicula dentro de "+plataforma.getNombre());
                    }
                }
                case SALIR -> System.exit(0);

            }

        }

    }

    private static void cargarDatosIniciales(Plataforma plataforma){
        plataforma.agregarContenido(new Pelicula("Spider-Man: A través del Spider-Verso", 140, "Acción", 4.8));
        plataforma.agregarContenido(new Pelicula("Avengers: Endgame", 181, "Acción", 4.7));
        plataforma.agregarContenido(new Pelicula("The Batman", 176, "Crimen", 4.6));
        plataforma.agregarContenido(new Pelicula("Interestelar", 169, "Ciencia Ficción", 4.9));
        plataforma.agregarContenido(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 178, "Fantasía", 4.9));
        plataforma.agregarContenido(new Pelicula("Gladiador", 155, "Acción", 4.7));
        plataforma.agregarContenido(new Pelicula("Top Gun: Maverick", 130, "Acción", 4.5));
        plataforma.agregarContenido(new Pelicula("Oppenheimer", 180, "Drama", 4.8));
        plataforma.agregarContenido(new Pelicula("Spider-Man: Sin camino a casa", 148, "Acción", 4.6));
        plataforma.agregarContenido(new Pelicula("John Wick 4", 169, "Acción", 4.4));
        plataforma.agregarContenido(new Pelicula("Dune: Parte Dos", 166, "Ciencia Ficción", 4.9));
        plataforma.agregarContenido(new Pelicula("Batman Begins", 140, "Acción", 4.5));
        plataforma.agregarContenido(new Pelicula("The Dark Knight", 152, "Acción", 5.0));
        plataforma.agregarContenido(new Pelicula("Matrix", 136, "Ciencia Ficción", 4.8));
        plataforma.agregarContenido(new Pelicula("Inception", 148, "Ciencia Ficción", 4.8));
    }
}
