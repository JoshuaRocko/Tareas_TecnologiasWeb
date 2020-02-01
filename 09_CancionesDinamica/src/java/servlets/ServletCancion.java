package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCancion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cancion = request.getParameter("cancion");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Reproducir canción</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<audio controls>");
        out.println("<source src='"+cancion+".mp3' type='audio/mpeg' />");
        out.println("El navegador no soporta elementos de audio");
        out.println("</audio>");
        out.println("</body>");
        out.println("</html>");
    }
}
