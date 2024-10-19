package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.model.Autor;
import tech.icei.util.HibernateUtil;

import java.util.List;
import java.util.Objects;

public class AutorDAOImpl implements AutorDAO {
    private Session session;

    public AutorDAOImpl() {
    }

    @Override
    public Autor getAutor(String codigo) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        Query<Autor> query = session
                .createQuery("from Autor a where a.codAutor = :codigo", Autor.class)
                .setParameter("codigo", codigo);
        //return Objects.nonNull(query.list()) ? query.getSingleResult() : null;
        return query.list() != null && !query.list().isEmpty() ? query.getSingleResult() : null;
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
        return autor;
    }

    @Override
    public List<Autor> obtenerAutores() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Autor> query = session
                .createQuery("from Autor", Autor.class);
        return query.getResultList();
    }
}
