package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {
    private Session session;

    // Mostrar todos los autores dados de alta, con sus libros asociados
    public List<Autor> mostrarAutoresConLibros() {

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Autor> query = session.createQuery("FROM Autor", Autor.class);

        List<Autor> listaAutores = query.list();

        session.getTransaction().commit();
        session.close();

        return listaAutores;
    }
}