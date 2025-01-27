package dao;

import model.Habilidad;
import model.Personaje;
import model.StatSet;
import model.Usuario;
import org.hibernate.Session;

import java.util.List;

public class PersonajeDAO {
    private Session session;

    // Mostrar un personaje por su ID
    public Personaje mostrarPersonajeById(int id){

        return null;
    };

    // Mostrar todos los personajes
    public List<Personaje> mostrarTodosPersonajes(){
        return null;
    };

    // Crear un nuevo personaje
    public void crearPersonaje(Personaje personaje){
    };

    // Eliminar un personaje por su ID
    public void eliminarPersonaje(int id){

    };

    // Actualizar los detalles de un personaje
    public void actualizarPersonaje(Personaje personaje){

    };

    // Mostrar las habilidades de un personaje
    public List<Habilidad> mostrarHabilidades(int personajeId){
        return null;
    };

    // Mostrar los stats de un personaje
    public StatSet mostrarStats(int personajeId){
        return null;
    };

    // Mostrar el usuario asociado a un personaje
    public Usuario mostrarUsuarioPersonaje(int personajeId){
        return null;
    };

}
