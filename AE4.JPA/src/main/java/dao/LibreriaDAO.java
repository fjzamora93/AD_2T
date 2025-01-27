package dao;

import database.HibernateUtil;
import model.Autor;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LibreriaDAO {
    private Session session;


    public void addLibreria(Libreria libreria){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public void addLibroToLibreria(Libro libro, Libreria libreria){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        libreria.getLibros().add(libro);
        libro.getLibrerias().add(libreria);

        session.merge(libreria);
        session.merge(libro);

        session.getTransaction().commit();
        session.close();
    }

    // Mostrar todas las librerías, con solamente sus libros asociados
    public List<Libreria> mostrarLibreriasConLibros() {

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Libreria l JOIN FETCH l.libros", Libreria.class);
        List<Libreria> listado = query.list();

        session.getTransaction().commit();
        session.close();

        return listado;
    }


}