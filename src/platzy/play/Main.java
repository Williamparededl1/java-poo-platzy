package platzy.play;

import platzy.play.contenido.Genero;
import platzy.play.contenido.Pelicula;
import platzy.play.contenido.ResumenContenido;
import platzy.play.excepcion.PeliculaExistenteException;
import platzy.play.plataforma.Plataforma;
import platzy.play.util.FileUtils;
import platzy.play.util.ScannerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
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
    public static final int REPRODUCIR = 8;
    public static final int ELIMINAR_PELICULA = 9;
    public static final int SALIR = 10;

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
                    8. Reproducir
                    9. Eliminar Pelicula
                    10. Salir
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

                    List<ResumenContenido> titulos = plataforma.getResumenes();
                    System.out.println("tenemos "+titulos.size()+" peliculas en "+plataforma.getNombre());
                    if (!titulos.isEmpty()) {
                        titulos.forEach((resumen) -> System.out.println(resumen.titulo()+" - "+resumen.genero()+" - "+resumen.duracion()+ " mins"));
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
                    System.out.println("Con una duracion de "+ duracion.getDuracion() + " tenemos ha: \n");
                    System.out.println(duracion.obtenerFichaTecnica());

                }
                case REPRODUCIR -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quieres reproducir");
                    Pelicula peliculaReproducir = plataforma.buscarPorTitulo(nombrePelicula);

                    if (peliculaReproducir != null){
                        plataforma.reproducir(peliculaReproducir);
                    }else{
                        System.out.println(nombrePelicula + " no se encontro en "+plataforma.getNombre());
                    }


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
     plataforma.getContenidos().addAll(FileUtils.leerContenido());
    }
}
