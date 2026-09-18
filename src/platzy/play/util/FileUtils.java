package platzy.play.util;

import platzy.play.contenido.Contenido;
import platzy.play.contenido.Documental;
import platzy.play.contenido.Genero;
import platzy.play.contenido.Pelicula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String NOMBRE_ARCHIVO = "Contenido.txt";
    public static final String SEPARADOR = "|";
    public static final String TIPO_PELICULA = "PELICULA";
    public static final String TIPO_DOCUMENTAL = "DOCUMENTAL";

    public static void escribirContenido(Contenido contenido) {



        String linea = String.join(SEPARADOR,
                contenido.getTitulo(),
                String.valueOf(contenido.getDuracion()),
                contenido.getGenero().name(),
                String.valueOf(contenido.getCalificacion()),
                contenido.getFechaEstreno().toString());

        String lineaFinal;
        if (contenido instanceof Documental documental){
            lineaFinal = "DOCUMENTAL"+SEPARADOR+linea+SEPARADOR+documental.getNarrador();
        }else{
            lineaFinal = "PELICULA"+SEPARADOR+linea;
        }

        try{
            Files.writeString(Paths.get(NOMBRE_ARCHIVO),
                    lineaFinal+ System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println("ocurrio un error al escribir los datos :"+e.getMessage());
        }



    }

    public static List<Contenido> leerContenido() {
        List<Contenido> lista = new ArrayList<>();
        try {

            List<String> lineas =  Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            lineas.forEach(linea ->{
                String[] datos = linea.split("\\" + SEPARADOR);
                if ((TIPO_PELICULA.equals(datos[0]) &&datos.length == 6)||(TIPO_DOCUMENTAL.equals(datos[0]) &&datos.length == 7)) {
                    String titulo = datos[1];
                    int duracion = Integer.parseInt(datos[2]);
                    Genero genero = Genero.valueOf(datos[3].toUpperCase());
                    double calificacion = datos[4].isBlank() ? 0 : Double.parseDouble(datos[4]);
                    LocalDate fechaEstreno = LocalDate.parse(datos[5]);
                    Contenido contenido;

                    if(TIPO_PELICULA.equals(datos[0])){

                        contenido = new Pelicula(titulo, duracion, genero, calificacion);

                    }else{
                        String narrador = datos[6];
                        contenido = new Documental(titulo, duracion, genero, calificacion,narrador);
                    }

                    contenido.setFechaEstreno(fechaEstreno);

                    lista.add(contenido);
                }
            });

        } catch (IOException e) {
            System.out.println("ocurrio un error al cargar los datos :"+e.getMessage());
        }
            return lista;
    }
}
