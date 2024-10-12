package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
    private final SessionFactory factory;
    private Session session;

    public UsuarioDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Usuario loginUsuario(String username, String password) {
        session = factory.openSession();
        Query<Usuario> query = session.createQuery(
                "FROM Usuario " +
                "WHERE username = :username " +
                "AND password = :password",
                Usuario.class);
        query.setParameter("username", username)
                .setParameter("password", password);
        return !query.list().isEmpty() ? query.uniqueResult() : null;
    }
}
