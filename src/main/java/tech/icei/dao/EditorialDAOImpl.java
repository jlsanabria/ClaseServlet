package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.model.Editorial;

import java.util.List;

public class EditorialDAOImpl implements EditorialDAO {
    private final SessionFactory factory;
    private Session session;

    public EditorialDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Editorial getEditorial(int id) {
        session = factory.openSession();
        Editorial editorial = (Editorial) session.get(Editorial.class, id);
        session.close();
        return editorial;
    }

    @Override
    public void save(Editorial editorial) {
        session = factory.openSession();
        session.beginTransaction();
        session.persist(editorial);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Editorial> obtenerEditoriales() {
        session = factory.openSession();
        session.beginTransaction();
        Query<Editorial> query = session
                .createQuery("from Editorial ", Editorial.class);
        return query.getResultList();
    }

}
