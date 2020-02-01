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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String numero = request.getParameter("numero");
        HttpSession session = request.getSession();
        session.setAttribute("numero", numero);
        int numeroi = Integer.parseInt(numero);        
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet2' method='get'>");
        for (int i = 0; i < numeroi; i++) {
            out.println("<div><h3>Circulo "+(i+1)+"</h3>");
            out.println("X cento: <input type='text' name='xCentro_"+i+"' />");
            out.println("Y centro: <input type='text' name='yCentro_"+i+"' />");
            out.println("radio: <input type='text' name='radio_"+i+"' />");
            out.println("Angulo de Inicio: <input type='text' name='sAngle_"+i+"' />");
            out.println("Angulo final: <input type='text' name='eAngle_"+i+"' /></div>");
        }
        out.println("<input type='submit' />");
        out.println("</ form>");
        out.println("<pre>** Nota: Los angulos se expresan en radianes (Ej: 1.5, 2, 0, 0.5)</pre>");
        out.println("</body>");
        out.println("</html>");
    }

}
