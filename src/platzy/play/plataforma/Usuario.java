package platzy.play.plataforma;

import platzy.play.contenido.Pelicula;

public class Usuario {
    public String nombre;
    public String email;
    public int edad;

    public void ver(Pelicula pelicula){
        System.out.println(nombre +"esta viendo.....");
        pelicula.reprodducir();
    }

}
