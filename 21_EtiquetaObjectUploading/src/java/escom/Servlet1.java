
package escom;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        
        //Obtenemos la ruta de la aplicacion web en el disco
        File carpeta = new  File(this.getServletContext().getRealPath("/"));
        //Lista con los archivos dentro de la carpeta
        File archivos [] = carpeta.listFiles();
        //Lista para guardar los nombres de las canciones
        ArrayList<String> nombres = new ArrayList(); 
        
        /*Revisamos los nombres de los archivos y guardamos los archivos
        con extension ".pdf"*/
        for(File i : archivos){
            if(i.getName().contains(".pdf")){
                nombres.add(i.getName());
            }
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contenido Cargado</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Desplegar PDF</h2>");
        out.println("<form action='Servlet2' method=\"get\">");
        out.println("Elige un pdf: <input list=\"pdfs\" name=\"pdf\" />");
        out.println("<datalist id=\"pdfs\">");
        if(!nombres.isEmpty()){
            for(String pdf : nombres){
                out.println("<option value='"+pdf+"'>");
            }
        }
        out.println("</datalist>");
        out.println("<input type=\"submit\" />");
        out.println("</form>");
        out.println("<br><a href=\"formulario.html\">Subir otro PDF</a><br>");
        out.println("</body>");
        out.println("</html>");
    }
}
