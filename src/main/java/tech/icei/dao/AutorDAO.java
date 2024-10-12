package tech.icei.dao;

import tech.icei.model.Autor;

import java.util.List;

public interface AutorDAO {

    //public void setSession(Session session);

    Autor getAutor(String codigo);

    Autor guardarAutor(Autor autor);

    List<Autor> obtenerAutores();
}
