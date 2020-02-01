package sesiones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
        String checked;
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Productos</title>");            
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h1>Productos</h1>");
        out.println("<form action=\"Carrito\" method=\"post\">");
        
        for (String producto : productos) {
            checked = "";
            if (producto.equalsIgnoreCase((String) session.getAttribute(producto))) {
                checked = "checked";
            }
            out.println("<input type=\"checkbox\" name=\"console\" value=\"" + producto + "\" " + checked + " />" + producto + "<br>");
        }
        
        out.println("<br><input type=\"submit\" value=\" Guardar Carrito \"/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
