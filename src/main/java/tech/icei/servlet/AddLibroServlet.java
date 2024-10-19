package tech.icei.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.service.LibroService;
import tech.icei.service.LibroServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/new")
public class AddLibroServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AddLibroServlet.class);

    private LibroService libroService = new LibroServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            PrintWriter buildPage = response.getWriter();
            buildPage.println("<h2>Nuevo libro</h2>");

            List<Autor> autores = libroService.obtenerAutores();
            List<Editorial> editoriales = libroService.obtenerEditoriales();

            buildPage.println("<form action=\"saved\" method=\"post\">"); //    \" -->  "
            buildPage.println("<table>");
            buildPage.println("<tr>");
            buildPage.println("<td>Código: </td><td><input type=\"text\" name=\"codigo\"/></td>");
            buildPage.println("</tr>");
            buildPage.println("<tr>");
            buildPage.println("<td>Título: </td><td><input type=\"text\" name=\"titulo\"/></td>");
            buildPage.println("</tr>");
            buildPage.println("<tr>");
            buildPage.println("<td>N° páginas: </td><td><input type=\"number\" min=\"1\" name=\"nroPaginas\"/></td>");
            buildPage.println("</tr>");
            buildPage.println("<tr>");
            buildPage.println("<td>Autor: </td>");
            buildPage.println("<td><select name=\"autores\">");
            autores.forEach(autor -> {
                buildPage.println("<option value=\"" + autor.getCodAutor() + "\">" +
                        autor.getNombreAutor() + " " + autor.getApellidoAutor() + "</option>");
            });
            buildPage.println("</select></td>");
            buildPage.println("</tr>");
            buildPage.println("<tr>");
            buildPage.println("<td>Editorial: </td>");
            buildPage.println("<td><select name=\"editoriales\">");
            editoriales.forEach(editorial -> {
                buildPage.println("<option value=\"" + editorial.getEditorialId() + "\">" +
                        editorial.getNombre() + "</option>");
            });
            buildPage.println("</select></td>");
            buildPage.println("</tr>");
            buildPage.println("<tr></tr>");
            buildPage.println("<tr>");
            buildPage.println("<td></td>");
            buildPage.println("<td><input type=\"submit\" value=\"Guardar\">" +
                    "<input type=\"button\" value=\"Limpiar\" style=\"margin-left: 5px\"></td>");
            buildPage.println("</tr>");
            buildPage.println("</table>");
            buildPage.println("</form>");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
