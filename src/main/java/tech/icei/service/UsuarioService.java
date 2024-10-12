package tech.icei.service;

import tech.icei.model.Usuario;

public interface UsuarioService {
    Usuario login(String username, String password);
}
