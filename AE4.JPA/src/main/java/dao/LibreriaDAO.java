package dao;

import database.HibernateUtil;
import model.Libreria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LibreriaDAO {
    private Session session;


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