package escom;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Archivos extends HttpServlet {

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
        con extension ".mp4"*/
        for(File i : archivos){
            if(i.getName().contains(".mp4")){
                nombres.add(i.getName());
            }
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contenido Cargado</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Repoducir contenido</h2>");
        out.println("<form action=\"Reproduciendo\" method=\"get\">");
        out.println("Elige una canción: <input list=\"videos\" name=\"video\" />");
        out.println("<datalist id=\"videos\">");
        if(!nombres.isEmpty()){
            for(String video : nombres){
                out.println("<option value='"+video+"'>");
            }
        }
        out.println("</datalist>");
        out.println("<input type=\"submit\" value=\"Reproducir\"/>");
        out.println("</form>");
        out.println("<br><a href=\"formulario.html\">Subir otro video</a><br>");
        out.println("</body>");
        out.println("</html>");
    }
}
