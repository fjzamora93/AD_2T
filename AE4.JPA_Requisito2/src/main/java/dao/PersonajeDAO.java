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
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Personaje personaje = session.get(Personaje.class, id);

        session.getTransaction().commit();
        session.close();
        return personaje;
    };

    // Mostrar todos los personajes
    public List<Personaje> mostrarTodosPersonajes(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Personaje> query = session.createNamedQuery("Personaje.findAll", Personaje.class);
        List<Personaje> listadoPersonajes = query.list();

        session.getTransaction().commit();
        session.close();
        return listadoPersonajes;
    };

    // Crear un nuevo personaje
    public void crearPersonaje(Personaje personaje){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.merge(Personaje);

        session.getTransaction().commit();
        session.close();
    };

    // Eliminar un personaje por su ID
    public void eliminarPersonaje(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Personaje personaje = session.get(Personaje.class, id);
        session.delete(personaje);
        session.getTransaction().commit();
        session.close();

    };

    // Actualizar los detalles de un personaje
    public void actualizarPersonaje(Personaje personaje){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(jugador);
        session.getTransaction().commit();
        session.close();
    };

}
