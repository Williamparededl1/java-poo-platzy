package platzy.play.plataforma;

import platzy.play.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    public String nombre;
    public String email;
    public int edad;
    public LocalDateTime fechaRegistro;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = LocalDateTime.now();
    }

    public void ver(Pelicula pelicula){
        System.out.println(nombre +" esta viendo.....");
        pelicula.reprodducir();
    }


}
