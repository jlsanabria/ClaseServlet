package tech.icei.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.icei.model.Libro;
import tech.icei.service.LibroService;
import tech.icei.service.LibroServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class ListLibroServlet extends HttpServlet {
    private LibroService libroService = new LibroServiceImpl();

//    public ListLibroServlet(LibroService libroService) {
//        this.libroService = libroService;
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            PrintWriter buildPage = response.getWriter();
            buildPage.println("<h2>Lista de libros</h2>");

            List<Libro> libroList = libroService.obtenerLibros();

            buildPage.println("<table border=1 width=100%>");
            buildPage.println("<tr><th>Código</th><th>Titulo</th><th>N° páginas</th></tr>");

//            for (Libro libro : libroList) {
//                buildPage.println("<tr>" +
//                        "<td>" + libro.getCodLibro() + "</td>" +
//                        "<td>" + libro.getTitulo() + "</td>" +
//                        "<td>" + libro.getNumeroPaginas() + "</td>" +
//                        "</tr>");
//            }

            libroList.forEach(libro -> {
                buildPage.println("<tr>" +
                        "<td>" + libro.getCodLibro() + "</td>" +
                        "<td>" + libro.getTitulo() + "</td>" +
                        "<td>" + libro.getNumeroPaginas() + "</td>" +
                        "</tr>");
            });

            buildPage.println("</table>");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
