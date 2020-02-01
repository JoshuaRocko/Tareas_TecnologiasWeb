package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reproduciendo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String nombreArchivo = request.getParameter("video");
        
        String ruta = this.getServletContext().getRealPath("/");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contenido Cargado</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<video controls>");
        out.println("<source src='"+ nombreArchivo +"' type='video/mp4' />");
        out.println("Tu navegador no soporta video");
        out.println("</video>");
        out.println("<br><a href=\"formulario.html\">Subir otro video</a><br>");
        out.println("<br><a href=\"Archivos\">Elegir otro video</a><br>");
        out.println("</body>");
        out.println("</html>");
    }
}
