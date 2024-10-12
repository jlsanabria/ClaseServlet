package tech.icei.service;

import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.model.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> obtenerLibros();

    Libro guardarLibro(Libro libro);

    List<Autor> obtenerAutores();

    List<Editorial> obtenerEditoriales();
}
