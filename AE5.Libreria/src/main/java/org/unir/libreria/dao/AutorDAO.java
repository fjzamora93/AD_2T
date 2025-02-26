package org.unir.libreria.dao;



import org.unir.libreria.HibernateUtil;
import org.unir.libreria.model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {
    private Session session;

    public void addAutor(Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(autor);
        session.getTransaction().commit();
        session.close();
    }


    // Mostrar todos los autores dados de alta, con sus libros asociados
    public List<Autor> mostrarAutoresConLibros() {

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Autor> query = session.createNamedQuery("Autor.findAll", Autor.class);

        List<Autor> listaAutores = query.list();

        session.getTransaction().commit();
        session.close();

        return listaAutores;
    }
}