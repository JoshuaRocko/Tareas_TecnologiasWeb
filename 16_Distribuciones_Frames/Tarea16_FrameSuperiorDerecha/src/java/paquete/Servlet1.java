package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String derecha = request.getParameter("derecha");
        String superior = request.getParameter("superior");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");
        
        out.println("<frameset rows='"+superior+",*' frameborder='yes' boder='1' framespacing='1'>");
        out.println("<frame src='superior.html' />");
        out.println("<frameset cols='*,"+derecha+"' frameborder='yes' boder='1' framespacing='1'>");
        out.println("<frame src='contenido.html' />'");
        out.println("<frame src='derecha.html' />");
        out.println("</frameset>");
        out.println("</frameset>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");
    }

}
