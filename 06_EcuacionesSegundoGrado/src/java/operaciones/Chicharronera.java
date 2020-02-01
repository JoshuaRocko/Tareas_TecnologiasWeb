package operaciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Chicharronera extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Chicharronera uwu</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Resultado</h1>");

        /*Chicharronera*/
        double discriminante = (b * b) - (4 * a * c);
        double x1, x2;
        if (discriminante > 0) {
            x1 = ((-b) + Math.pow(discriminante, 0.5)) / (2 * a);
            x2 = ((-b) - Math.pow(discriminante, 0.5)) / (2 * a);
            out.println("<p>Primera solución:<br>");
            out.println("x1 = " + x1 + "<br>");
            out.println("<p>Segunda solución:<br>");
            out.println("x2 = " + x2 + "</p>");
        } else if (discriminante == 0) {
            x1 = (-b) / (2 * a);
            out.println("<p>Única solucion:<br>");
            out.println("x = " + x1 + "</p>");
        } else {
            discriminante *= -1;
            double real = (-b) / (2 * a);
            double imaginario = Math.pow(discriminante, 0.5) / (2 * a);
            out.println("<p>Soluciones imaginarias<br>");
            out.println("x1 = " + real + " + (" + imaginario + ") i<br>");
            out.println("x2 = " + real + " - (" + imaginario + ") i<br>");
        }
        out.println("</body>");
        out.println("</html>");

    }
}
