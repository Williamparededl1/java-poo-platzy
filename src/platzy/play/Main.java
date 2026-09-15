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
                    System.out.println("falta");
                }
                case ELIMINAR_PELICULA -> {
                    System.out.println("falta");
                }
                case SALIR -> System.exit(0);

            }

        }





//        String nombrePelicula = ScannerUtils.capturarTexto("cual es nombre de la pelicula que quiere ver");
//        String generoPelicula = ScannerUtils.capturarTexto("Que genero es la pelicula que quiere ver");
//        int duracionPelicula = ScannerUtils.capturarNumero("Cuanto dura la pelicula mins ");
//        double calificacionPelicula = ScannerUtils.capturarDecimal("tu calificacion  del 1 - 5");
//
//
//        Pelicula pelicula = new Pelicula(nombrePelicula,duracionPelicula,generoPelicula,calificacionPelicula);
//        Pelicula pelicula2 = new Pelicula("spiderman",123,"accion",4.9);
//        plataforma.agregarContenido(pelicula);
//        plataforma.agregarContenido(pelicula2);
//        System.out.println("La plataforma " + plataforma.getNombre() + " tiene " + plataforma.getContenidos().size() + " contenidos");
//
//        plataforma.mostrarContenido();
//
//        plataforma.eliminarContenido(pelicula2);
//
//        plataforma.mostrarContenido();
//
//
//
//        //System.out.println(pelicula.obtenerFichaTecnica());
//
//        String nombreUsuario = ScannerUtils.capturarTexto("cual es nombre tu nombre");
//        String emailUsuario = ScannerUtils.capturarTexto("ingresa tu correo");
//
//        Usuario  usuario = new Usuario(nombreUsuario,emailUsuario);
//
//
//        usuario.ver(pelicula);
//        System.out.println(usuario.fechaRegistro);




    }
}
