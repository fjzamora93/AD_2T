package org.unir.libreria.dao;
import org.unir.libreria.HibernateUtil;
import org.unir.libreria.model.Editorial;
import org.hibernate.Session;

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
