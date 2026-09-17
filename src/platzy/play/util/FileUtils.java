package platzy.play.util;

import platzy.play.contenido.Genero;
import platzy.play.contenido.Pelicula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String NOMBRE_ARCHIVO = "Contenido.txt";
    public static final String SEPARADOR = "|";

    public static List<Pelicula> leerContenido() {
        List<Pelicula> lista = new ArrayList<>();
        try {

            List<String> lineas =  Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            lineas.forEach(linea ->{
                String[] datos = linea.split("\\" + SEPARADOR);
                if (datos.length == 5) {
                    String titulo = datos[0];
                    int duracion = Integer.parseInt(datos[1]);
                    Genero genero = Genero.valueOf(datos[2].toUpperCase());
                    double calificacion = datos[3].isBlank() ? 0 : Double.parseDouble(datos[3]);
                    LocalDate fechaEstreno = LocalDate.parse(datos[4]);
                    Pelicula pelicula = new Pelicula(titulo, duracion, genero, calificacion);
                    pelicula.setFechaEstreno(fechaEstreno);

                    lista.add(pelicula);
                }
            });

        } catch (IOException e) {
            System.out.println("ocurrio un error al cargar los datos :"+e.getMessage());
        }
            return lista;
    }
}
