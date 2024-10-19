package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.model.Editorial;
import tech.icei.util.HibernateUtil;

import java.util.List;

public class EditorialDAOImpl implements EditorialDAO {
    private Session session;

    public EditorialDAOImpl() {
    }

    @Override
    public Editorial getEditorial(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Editorial editorial = (Editorial) session.get(Editorial.class, id);
        //session.close();
        return editorial;
    }

    @Override
    public void save(Editorial editorial) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(editorial);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Editorial> obtenerEditoriales() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        Query<Editorial> query = session
                .createQuery("from Editorial ", Editorial.class);
        return query.getResultList();
    }

}
