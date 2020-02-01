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
        String nombreArchivo = request.getParameter("cancion");
        
        String ruta = this.getServletContext().getRealPath("/");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contenido Cargado</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"Reproduciendo\" method=\"get\">");
        out.println("<audio controls>");
        out.println("<source src='" + nombreArchivo + "' type='audio/mpeg' />");
        out.println("El navegador no soporta elementos de audio");
        out.println("</audio>");
        out.println("</form>");
        out.println("<br><a href=\"formulario.html\">Subir otra cancion</a><br>");
        out.println("<br><a href=\"Archivos\">Elegir otra cancion</a><br>");
        out.println("</body>");
        out.println("</html>");
    }
}
