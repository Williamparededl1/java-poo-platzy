package platzy.play;

import platzy.play.contenido.Genero;
import platzy.play.contenido.Pelicula;
import platzy.play.excepcion.PeliculaExistenteException;
import platzy.play.plataforma.Plataforma;
import platzy.play.util.ScannerUtils;

import java.util.List;


public class Main {
    public static final String NOMBRE_PLATAFORMA = "PELICULAS PLATZY";
    public static final String VERSION = "1.0.0";
    public static final int AGREGAR_PELICULA = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_PELICULA = 3;
    public static final int BUSCAR_GENERO = 4;
    public static final int POLULARES = 5;
    public static final int MEJOR_VALORADAS = 6;
    public static final int MAS_DURACION = 7;
    public static final int ELIMINAR_PELICULA = 8;
    public static final int SALIR = 9;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        cargarDatosIniciales(plataforma);

        while(true){

            System.out.println(NOMBRE_PLATAFORMA+" v:" +VERSION+"\n");
            System.out.println("Mas de "+plataforma.getDuracionTotal()+" minutos de Entretenimiento");

            int opcionElegida = ScannerUtils.capturarNumero("""
                    
                    Ingrese una opcion:
                    1. Agregar Pelicula
                    2. Mostrar Todo
                    3. Buscar por titulo
                    4. Buscar por genero
                    5. Mas Popularas
                    6. Mejor volardas
                    7. Con mas Duracion
                    8. Eliminar Pelicula
                    9. Salir
                    """);
            System.out.println("Opcion Elegida: "+ opcionElegida);

            switch (opcionElegida){
                case AGREGAR_PELICULA -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quieres agregar");
                    Genero generoPelicula = ScannerUtils.capturarGenero("Que genero es la pelicula quieres agregar");
                    int duracionPelicula = ScannerUtils.capturarNumero("Cuanto dura la pelicula mins ");
                    double calificacionPelicula = ScannerUtils.capturarDecimal("tu calificacion  del 1 - 5");

                    try {
                        plataforma.agregarContenido(new Pelicula(nombrePelicula, duracionPelicula, generoPelicula, calificacionPelicula));
                    }catch (PeliculaExistenteException e) {
                        System.out.println(e.getMessage());
                    }


                }
                case MOSTRAR_TODO -> {

                    List<String> titulos = plataforma.getTitulos();
                    System.out.println("tenemos "+titulos.size()+" peliculas en "+plataforma.getNombre());
                    if (!titulos.isEmpty()) {
                        titulos.forEach(System.out::println);
                    }


                }
                case BUSCAR_PELICULA -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quieres buscar");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombrePelicula);

                    if (pelicula != null) {
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println("No se encontro la pelicula dentro de "+plataforma.getNombre());
                    }

                }
                case BUSCAR_GENERO -> {
                    Genero nombreGenero = ScannerUtils.capturarGenero("Que genero es la pelicula que quiere ver");
                    List<Pelicula> peliculas = plataforma.buscarPorGenero(nombreGenero);

                    System.out.println("tenemos "+peliculas.size()+" de ese genero");
                    if (!peliculas.isEmpty()) {
                        peliculas.forEach((contenido) -> System.out.println(contenido.obtenerFichaTecnica() +"\n"));
                    }


                }
                case POLULARES -> {

                    int cantidad = ScannerUtils.capturarNumero("Cantidad de resultados a mostrar");
                    List<Pelicula> Rankig = plataforma.getPopulares(cantidad);
                    System.out.println("tenemos "+Rankig.size()+" Rankeadas en "+plataforma.getNombre());
                    if (!Rankig.isEmpty()) {
                        Rankig.forEach((contenido) -> System.out.println(contenido.obtenerFichaTecnica() +"\n"));
                    }

                }

                case MEJOR_VALORADAS -> {

                    List<Pelicula> Rankig = plataforma.getValoradas();
                    System.out.println("tenemos "+Rankig.size()+" peliculas con mas de 4.8 en "+plataforma.getNombre());
                    if (!Rankig.isEmpty()) {
                        Rankig.forEach((contenido) -> System.out.println(contenido.obtenerFichaTecnica() +"\n"));
                    }
                }

                case MAS_DURACION -> {

                    Pelicula duracion = plataforma.getMasLarga();
                    System.out.println("Con una duracion de "+ duracion.getDuraCion() + " tenemos ha: \n");
                    System.out.println(duracion.obtenerFichaTecnica());

                }
                case ELIMINAR_PELICULA -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quieres eliminnar");
                    Pelicula peliculaEliminar = plataforma.buscarPorTitulo(nombrePelicula);

                    if (peliculaEliminar != null) {
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
        plataforma.agregarContenido(new Pelicula("Spider-Man: A través del Spider-Verso", 140, Genero.ANIMACION, 4.8));
        plataforma.agregarContenido(new Pelicula("Avengers: Endgame", 181, Genero.ACCION, 4.7));
        plataforma.agregarContenido(new Pelicula("The Batman", 176, Genero.SUSPENSO, 4.6));
        plataforma.agregarContenido(new Pelicula("Interestelar", 169, Genero.CIENCIA_FICCION, 4.9));
        plataforma.agregarContenido(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 178, Genero.FANTASIA, 4.9));
        plataforma.agregarContenido(new Pelicula("Gladiador", 155, Genero.DRAMA, 4.7));
        plataforma.agregarContenido(new Pelicula("Top Gun: Maverick", 130, Genero.ACCION, 4.5));
        plataforma.agregarContenido(new Pelicula("Oppenheimer", 180, Genero.DRAMA, 4.8));
        plataforma.agregarContenido(new Pelicula("Spider-Man: Sin camino a casa", 148, Genero.AVENTURA, 4.6));
        plataforma.agregarContenido(new Pelicula("John Wick 4", 169, Genero.ACCION, 4.4));
        plataforma.agregarContenido(new Pelicula("Dune: Parte Dos", 166, Genero.FANTASIA, 4.9));
        plataforma.agregarContenido(new Pelicula("Batman Begins", 140, Genero.ACCION, 4.5));
        plataforma.agregarContenido(new Pelicula("The Dark Knight", 152, Genero.ACCION, 5.0));
        plataforma.agregarContenido(new Pelicula("Matrix", 136, Genero.CIENCIA_FICCION, 4.8));
        plataforma.agregarContenido(new Pelicula("Inception", 148, Genero.CIENCIA_FICCION, 4.8));
        plataforma.agregarContenido(new Pelicula("Como si Fuera la primera vez", 130, Genero.ROMANTICA, 5));
        plataforma.agregarContenido(new Pelicula("Loco por Merry", 148, Genero.ROMANTICA, 3));
        plataforma.agregarContenido(new Pelicula("Actividad Paranormal", 148, Genero.TERROR, 4));
    }
}
