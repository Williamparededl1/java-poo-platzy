package platzy.play;

import platzy.play.contenido.*;
import platzy.play.excepcion.PeliculaExistenteException;
import platzy.play.plataforma.Plataforma;
import platzy.play.util.FileUtils;
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
    public static final int REPRODUCIR = 8;
    public static final int MOSTRAR_PELICULAS = 9;
    public static final int MOSTRAR_DOCUMENTALES = 10;
    public static final int ELIMINAR_PELICULA = 11;
    public static final int SALIR = 12;

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
                    9. Mostrar Peliculas
                    10. Mostrar Documentales
                    11. Eliminar Pelicula
                    12. Salir
                    """);
            System.out.println("Opcion Elegida: "+ opcionElegida);

            switch (opcionElegida){
                case AGREGAR_PELICULA -> {
                    int tipoContenido = ScannerUtils.capturarNumero("1. Pelicula\n2. Documental");
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la contenido que quieres agregar");
                    Genero generoPelicula = ScannerUtils.capturarGenero("Que genero es la contenido quieres agregar");
                    int duracionPelicula = ScannerUtils.capturarNumero("Cuanto dura la contenido mins ");
                    double calificacionPelicula = ScannerUtils.capturarDecimal("tu calificacion  del 1 - 5");

                    try {
                        if (tipoContenido == 1){
                            plataforma.agregarContenido(new Pelicula(nombrePelicula, duracionPelicula, generoPelicula, calificacionPelicula));
                        }else{
                            String nombreNarrador = ScannerUtils.capturarTexto("cual es el nombre del narrador");
                            plataforma.agregarContenido(new Documental(nombrePelicula, duracionPelicula, generoPelicula, calificacionPelicula, nombreNarrador));
                        }

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
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la contenido que quieres buscar");
                    Contenido contenido = plataforma.buscarPorTitulo(nombrePelicula);

                    if (contenido != null) {
                        System.out.println(contenido.obtenerFichaTecnica());
                    } else {
                        System.out.println("No se encontro la contenido dentro de "+plataforma.getNombre());
                    }

                }
                case BUSCAR_GENERO -> {
                    Genero nombreGenero = ScannerUtils.capturarGenero("Que genero es la contenido que quiere ver");
                    List<Contenido> contenidos = plataforma.buscarPorGenero(nombreGenero);

                    System.out.println("tenemos "+ contenidos.size()+" de ese genero");
                    if (!contenidos.isEmpty()) {
                        contenidos.forEach((contenido) -> System.out.println(contenido.obtenerFichaTecnica() +"\n"));
                    }


                }
                case POLULARES -> {

                    int cantidad = ScannerUtils.capturarNumero("Cantidad de resultados a mostrar");
                    List<Contenido> Rankig = plataforma.getPopulares(cantidad);
                    System.out.println("tenemos "+Rankig.size()+" Rankeadas en "+plataforma.getNombre());
                    if (!Rankig.isEmpty()) {
                        Rankig.forEach((contenido) -> System.out.println(contenido.obtenerFichaTecnica() +"\n"));
                    }

                }

                case MEJOR_VALORADAS -> {

                    List<Contenido> Rankig = plataforma.getValoradas();
                    System.out.println("tenemos "+Rankig.size()+" peliculas con mas de 4.8 en "+plataforma.getNombre());
                    if (!Rankig.isEmpty()) {
                        Rankig.forEach((contenido) -> System.out.println(contenido.obtenerFichaTecnica() +"\n"));
                    }
                }

                case MAS_DURACION -> {

                    Contenido duracion = plataforma.getMasLarga();
                    System.out.println("Con una duracion de "+ duracion.getDuracion() + " tenemos ha: \n");
                    System.out.println(duracion.obtenerFichaTecnica());

                }
                case REPRODUCIR -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la contenido que quieres reproducir");
                    Contenido contenidoReproducir = plataforma.buscarPorTitulo(nombrePelicula);

                    if (contenidoReproducir != null){
                        plataforma.reproducir(contenidoReproducir);
                    }else{
                        System.out.println(nombrePelicula + " no se encontro en "+plataforma.getNombre());
                    }


                }
                case MOSTRAR_PELICULAS -> {
                    List<Pelicula> Peliculas = plataforma.getPeliculas();
                    System.out.println("tenemos "+Peliculas.size()+" Peliculas en "+plataforma.getNombre());
                    if (!Peliculas.isEmpty()) {
                        Peliculas.forEach((pelicula) -> System.out.println(pelicula.obtenerFichaTecnica() +"\n"));
                    }
                }
                case MOSTRAR_DOCUMENTALES -> {
                    List<Documental> Documentales = plataforma.getDocumentales();
                    System.out.println("tenemos "+Documentales.size()+" Documentales en "+plataforma.getNombre());
                    if (!Documentales.isEmpty()) {
                        Documentales.forEach((documental) -> System.out.println(documental.obtenerFichaTecnica() +"\n"));
                    }
                }
                case ELIMINAR_PELICULA -> {
                    String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la contenido que quieres eliminnar");
                    Contenido contenidoEliminar = plataforma.buscarPorTitulo(nombrePelicula);

                    if (contenidoEliminar != null) {
                        boolean eliminar = plataforma.eliminarContenido(contenidoEliminar);
                        if (eliminar){
                            System.out.println("La contenido "+nombrePelicula+" ha sido eliminada");
                        } else {
                            System.out.println("La contenido "+nombrePelicula+" no se pudo eliminaR");
                        }

                    } else {
                        System.out.println("No se encontro la contenido dentro de "+plataforma.getNombre());
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
