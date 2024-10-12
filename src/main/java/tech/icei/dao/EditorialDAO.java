package tech.icei.dao;

import tech.icei.model.Editorial;

import java.util.List;

public interface EditorialDAO {
    public Editorial getEditorial(int id);

    public void save(Editorial editorial);

    List<Editorial> obtenerEditoriales();
}
