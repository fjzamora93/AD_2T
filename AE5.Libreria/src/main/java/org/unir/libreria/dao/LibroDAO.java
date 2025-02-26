package org.unir.libreria.dao;

import org.unir.libreria.HibernateUtil;
import org.unir.libreria.model.Libro;
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
    public List<Libro> mostrarTodos() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createNamedQuery("Libro.findAll", Libro.class);
        List <Libro> librosList= query.list();

        session.getTransaction().commit();
        session.close();

        return librosList;
    }


}