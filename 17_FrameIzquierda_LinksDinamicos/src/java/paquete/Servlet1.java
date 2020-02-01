package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String izquierda = (String)session.getAttribute("izquierda");
        String numero = (String)session.getAttribute("numero");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");
        
        String link = "izquierda?numero="+numero+"";
        for (int i = 0; i < Integer.parseInt(numero) ; i++) {
            link += "&href"+i+"="+request.getParameter("href"+i)+"&text"+i+"="+request.getParameter("text"+i)+"";
        }
        
        out.println("<frameset cols='"+izquierda+",*' frameborder='yes' border='1' framespacing='1'>");
        out.println("<frame src='"+link+"'>");
        out.println("<frame src='contenido.html' name = 'contenido'></frameset>");
   
                
        out.println("</head>");
        out.println("<body>");
        
        out.println("</body>");
        out.println("</html>");
    }

}
