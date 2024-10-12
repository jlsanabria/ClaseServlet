package tech.icei.dao;

import tech.icei.model.Usuario;

public interface UsuarioDAO {
    Usuario loginUsuario(String username, String password);
}
