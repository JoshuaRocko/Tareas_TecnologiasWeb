package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String numero = (String) session.getAttribute("clave");
        int numeroi = Integer.parseInt(numero);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");
        out.println("</head>");
        out.println("<body>");
        for (int i = 0; i < numeroi; i++) {
            out.println("<abbr title='" + request.getParameter("title" + (i + 1)) + "'>" + request.getParameter("abreviatura" + (i + 1)) + "</abbr><br />");
        }
        out.println("</body>");
        out.println("</html>");
    }

}
