package tech.icei.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.model.Libro;
import tech.icei.service.LibroService;
import tech.icei.service.LibroServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/saved")
public class SavedLibroServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SavedLibroServlet.class);

    private LibroService libroService = new LibroServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        String codigo = request.getParameter("codigo");
        String titulo = request.getParameter("titulo");
        String nroPaginas = request.getParameter("nroPaginas");
        String codAutor = request.getParameter("autores");
        String editorialId = request.getParameter("editoriales");
        log.info("Código --> " + codigo);
        log.info("Titulo --> " + titulo);
        log.info("NroPagina --> " + nroPaginas);
        log.info("Autor --> " + codAutor);
        log.info("Editorial --> " + editorialId);

        Libro libro = new Libro();
        libro.setCodLibro(codigo);
        libro.setTitulo(titulo);
        libro.setNumeroPaginas(Integer.parseInt(nroPaginas));

        Autor autor = libroService.obtenerAutorPorCodigo(codAutor);
        if (Objects.nonNull(autor)) {
            libro.setAutor(autor);
        }

        Editorial editorial = libroService.obtenerEditorialPorId(Integer.valueOf(editorialId));
        if (Objects.nonNull(editorial)) {
            libro.setEditorial(editorial);
        }

        log.info("Libro --> " + libro);

        Libro libroSaved = libroService.guardarLibro(libro);
        try {
            PrintWriter buildPage = response.getWriter();
            if(Objects.nonNull(libroSaved)) {
                buildPage.println("<h3 style=\"color: blue\">Libro registrado correctamente</h3>");
            } else {
                buildPage.println("<h3 style=\"color: red\">Error, no se pudo registrar el libro</h3>");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
