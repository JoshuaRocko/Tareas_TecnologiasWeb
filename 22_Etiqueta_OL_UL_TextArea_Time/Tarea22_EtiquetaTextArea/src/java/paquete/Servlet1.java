package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

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
        out.println("<form action='Servlet2' method='get' id='form1'>");
        out.println("<input type='hidden' name='numero' value='"+numero+"'/>");
        for(int i = 0 ; i<numero ; i++){
            out.println("<h3>Text Area "+(i+1)+"</h3>");
            out.println("Cols <input type'text' name='cols"+i+"' />");
            out.println("Rows <input type'text' name='rows"+i+"' />");
        }
        out.println("<br /><input type='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
    }
}
