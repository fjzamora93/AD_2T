package dao;

import database.HibernateUtil;
import model.Personaje;
import model.Usuario;
import org.hibernate.Session;

import java.util.List;

public class UsuarioDAO {
    private Session session;

    // Mostrar todos los usuarios
    public List<Usuario> mostrarUsuarios(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Y aquí va el cuerpo de la consulta

        session.getTransaction().commit();
        session.close();
        return null;
    };

    // Mostrar un usuario por su ID
    public Usuario mostrarUsuarioPorId(int id){
        return null;
    };

    // Crear un nuevo usuario
    public void crearUsuario(Usuario usuario){

    };

    // Eliminar un usuario por su ID
    public void eliminarUsuario(int id){

    };

    // Mostrar los personajes de un usuario
    public List<Personaje> mostrarPersonajesUsuario(int usuarioId){
        return null;
    };

}
