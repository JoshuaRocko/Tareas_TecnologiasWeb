package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String numero = request.getParameter("numero");
        HttpSession session = request.getSession();
        session.setAttribute("numero", numero);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Formulario</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<form action = \"UploadServlet\" method = \"post\" enctype = \"multipart/form-data\">");
        
        for (int i = 0; i < Integer.parseInt(numero); i++) {
            out.println("<input type = \"file\" name = \"file\" size = \"45\" /><br />");
        }
        out.println("<input type = \"submit\" value = \"Upload File\" />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }
}
