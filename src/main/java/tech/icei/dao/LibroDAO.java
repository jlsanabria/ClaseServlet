package tech.icei.dao;

import tech.icei.model.Libro;

import java.util.List;

public interface LibroDAO {
    public Libro findByCode(String codLibro);

    public Libro create(Libro libro);

    public List<Libro> readAll();

    public Libro update(Libro libro);

    public void delete(Libro libro);

    public List<Libro> searchByTitle(String titulo);

}
