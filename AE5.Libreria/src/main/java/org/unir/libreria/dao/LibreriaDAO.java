package org.unir.libreria.dao;

import org.unir.libreria.HibernateUtil;
import org.unir.libreria.model.LibreriaEntity;
import org.unir.libreria.model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDAO {
    private Session session;


    public void addLibreria(LibreriaEntity libreria){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public void addLibroToLibreria(Libro libro, LibreriaEntity libreria){
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
    public List<LibreriaEntity> mostrarLibreriasConLibros() {

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createNamedQuery("Libreria.findAll", LibreriaEntity.class);
        List<LibreriaEntity> listado = query.list();

        session.getTransaction().commit();
        session.close();

        return listado;
    }


}