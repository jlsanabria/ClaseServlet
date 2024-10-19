package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.model.Libro;
import tech.icei.util.HibernateUtil;

import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private Session session;

    public LibroDAOImpl() {
    }

    /**
     * Buscar un libro por código de libro
     * @param codLibro
     * @return
     */
    @Override
    public Libro findByCode(String codLibro) {
        // HQL -->  Hibernate Query Language
        session = HibernateUtil.getSessionFactory().openSession();
        Query<Libro> query = session.createQuery("from Libro where codLibro = :codLibro", Libro.class);
        query.setParameter("codLibro", codLibro);
        return query.uniqueResult();
    }

    /**
     * Registrar un libro
     * @param libro
     * @return
     */
    @Override
    public Libro create(Libro libro) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        if(!session.getTransaction().isActive()) {
            session.beginTransaction();
        }
        try {
            session.persist(libro);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
        //session.close();
        return libro;
    }

    /**
     * Listar todos los libros
     * @return
     */
    @Override
    public List<Libro> readAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        Query<Libro> query = session.createQuery("from Libro", Libro.class);
        return query.list();
    }

    /**
     * Actualizar un libro
     * @param libro
     * @return
     */
    @Override
    public Libro update(Libro libro) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(libro);
        session.getTransaction().commit();
        session.close();
        return libro;
    }

    /**
     * Eliminar un libro
     * @param libro
     */
    @Override
    public void delete(Libro libro) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(libro);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Buscar un libro por títutlo
     * @param titulo
     * @return
     */
    @Override
    public List<Libro> searchByTitle(String titulo) {
        session = HibernateUtil.getSessionFactory().openSession();
        Query<Libro> query = session
                .createQuery("from Libro where lower(titulo) like lower(:titulo)", Libro.class)
                .setParameter("titulo", "%" + titulo + "%");
        return query.list();
    }

}
