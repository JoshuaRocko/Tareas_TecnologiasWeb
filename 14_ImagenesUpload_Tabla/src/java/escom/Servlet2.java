package escom;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String filas = (String) session.getAttribute("filas");
        String columnas = (String) session.getAttribute("columnas");

        File carpeta = new File(this.getServletContext().getRealPath("/"));
        File archivos[] = carpeta.listFiles();
        ArrayList<String> nombres = new ArrayList();

        for (File i : archivos) {
            if (i.getName().contains(".jpeg") || i.getName().contains(".jpg") || i.getName().contains(".png")) {
                nombres.add(i.getName());
            }
        }

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Imagenes</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet3' method = 'get' />");
        out.println("<table border = '1'>");
        for (int i = 0; i < Integer.parseInt(filas); i++) {
            out.println("<tr>");
            for (int j = 0; j < Integer.parseInt(columnas); j++) {
                out.println("<td>");
                out.println("<select name='imagenes'>");
                if (!nombres.isEmpty()) {
                    for (String imagen : nombres) {
                        out.println("<option value='" + imagen + "'>"+imagen+"</option>");
                    }
                }
                out.println("</select>");
                out.println("</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br />");
        out.println("<input type='submit' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }
}
