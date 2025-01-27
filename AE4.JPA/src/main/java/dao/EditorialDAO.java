package dao;
import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EditorialDAO {
    private Session session;


    public void addEditorial(Editorial editorial) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(editorial);

        session.getTransaction().commit();
        session.close();
    }
}
