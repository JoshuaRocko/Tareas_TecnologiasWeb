package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String nombreArchivo = request.getParameter("pdf");
        
        String ruta = this.getServletContext().getRealPath("/");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contenido Cargado</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<object type='application/pdf' data='"+nombreArchivo+"' width='1200' height='900'></object>");
        out.println("<br><a href=\"formulario.html\">Subir otro PDF</a><br>");
        out.println("<br><a href=\"Archivos\">Elegir otro PDF</a><br>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
