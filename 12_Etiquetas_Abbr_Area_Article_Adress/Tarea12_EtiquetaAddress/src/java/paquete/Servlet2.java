package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        int numero = Integer.parseInt(request.getParameter("numero"));
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");            
        out.println("</head>");
        out.println("<body>");
        for(int i = 0 ; i<numero ; i++){
            out.println("<address><h3>Address "+(i+1)+"</h3><pre>"+request.getParameter("address"+i)+"</pre></address>");
        }
        out.println("</body>");
        out.println("</html>");
        
    }
}
