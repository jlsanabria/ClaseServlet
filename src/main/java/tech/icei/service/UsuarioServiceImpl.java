package tech.icei.service;

import com.google.common.hash.Hashing;
import org.hibernate.SessionFactory;
import tech.icei.dao.UsuarioDAO;
import tech.icei.dao.UsuarioDAOImpl;
import tech.icei.model.Usuario;

import java.nio.charset.StandardCharsets;

public class UsuarioServiceImpl implements UsuarioService {
    private final SessionFactory factory;
    private UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(SessionFactory factory) {
        this.factory = factory;
        usuarioDAO = new UsuarioDAOImpl(this.factory);
    }

    @Override
    public Usuario login(String username, String password) {
        String sha256Password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        return usuarioDAO.loginUsuario(username, sha256Password);
    }
}
