package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class izquierda extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        
        int numeroI = Integer.parseInt((String)session.getAttribute("numero"));
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Izquierda</title>");            
        out.println("</head>");
        out.println("<body>");

        ArrayList<String> href = new ArrayList<>();
        ArrayList<String> text = new ArrayList<>();
        
        for (int i = 0; i < numeroI; i++) {
            href.add((String) session.getAttribute("href"+i));
            text.add((String) session.getAttribute("text"+i));
        }
        
        for (int i = 0; i < numeroI; i++) {
            out.println("<a href='"+ href.get(i) +"' target='contenido' >"+text.get(i)+"</a><br />");
        }
        
        out.println("</body>");
        out.println("</html>");
    }

}
