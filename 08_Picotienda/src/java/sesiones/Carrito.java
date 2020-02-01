package sesiones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Carrito extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        
        String productos[]={
            "Xbox One",
            "Xbox One X",
            "Nintendo Switch",
            "Play Station 4",
            "Play Station 4 Pro",
        };
        
        for (String producto : productos) {
            if (producto.equalsIgnoreCase((String) session.getAttribute(producto))) {
                session.removeAttribute(producto);
            }
        }

        String[] selected = request.getParameterValues("console");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Carrito</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Carrito</h1>");
        out.println("<h3>Artículos Seleccionados</h3>");
        out.println("<ul>");
        
        if (selected != null) {
            for (String i : selected) {
                out.println("<li>" + i + "</li>");
                session.setAttribute(i, i);
            }
        }
        out.println("</ul>");

        out.println("<a href=\"index\" /> Volver");
        out.println("</body>");
        out.println("</html>");
    }
}
