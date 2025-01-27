package dao;

import database.HibernateUtil;
import model.Personaje;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UsuarioDAO {
    private Session session;

    // Mostrar todos los usuarios
    public List<Usuario> mostrarUsuarios(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Usuario> query = session.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> listaUsuarios =  query.list();

        session.getTransaction().commit();
        session.close();
        return listaUsuarios;
    };

    // Mostrar un usuario por su ID
    public Usuario mostrarUsuarioPorId(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Usuario user = session.get(Usuario.class, id);

        session.getTransaction().commit();
        session.close();
        return user;
    };


}
