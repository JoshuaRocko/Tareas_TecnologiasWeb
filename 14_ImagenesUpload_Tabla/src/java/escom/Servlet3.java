package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String filas = (String) session.getAttribute("filas");
        String columnas = (String) session.getAttribute("columnas");
        String imagenes [] = request.getParameterValues("imagenes");
            
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Formulario</title>");
        out.println("</head>");
        out.println("<body>");
        int contador = 0;
        out.println("<table border = '1'>");
        for (int i = 0; i < Integer.parseInt(filas); i++) {
            out.println("<tr>");
            for (int j = 0; j < Integer.parseInt(columnas); j++) {
                out.println("<td>");
                out.println("<img src = '"+imagenes[contador]+"' />");
                out.println("</td>");
                contador++;
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}
