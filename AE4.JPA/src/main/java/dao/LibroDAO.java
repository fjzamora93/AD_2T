package dao;

import database.HibernateUtil;
import model.Autor;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

// DAO para Libros
public class LibroDAO {
    private Session session;

    public void addLIbro(Libro libro){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(libro);


        session.getTransaction().commit();
        session.close();
    }

    // Mostrar todos los libros dados de alta, con su editorial y su autor
    public List<Libro> mostrarLibrosConEditorialYAutor() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Libro", Libro.class);
        List <Libro> librosList= query.list();

        session.getTransaction().commit();
        session.close();

        return librosList;
    }



    public List <Libro> mostrarLibrosEnLibrerias() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Libro l JOIN FETCH l.librerias", Libro.class);
        List <Libro> listaLibros = query.list();

        session.getTransaction().commit();
        session.close();

        return listaLibros;
    }

}