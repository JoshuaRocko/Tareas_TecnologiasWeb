/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JoshuaRocko
 */
public class Cramer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int filas = 3, columnas = 4;
        int matriz [][] = new int[filas][columnas];
        
        for(int i = 0; i<filas ; i++){
            for(int j = 0; j<columnas; j++){
                switch(j){
                    case 0:
                        matriz[i][j] = Integer.parseInt(request.getParameter("x"+(i+1)));
                        break;
                    case 1:
                        matriz[i][j] = Integer.parseInt(request.getParameter("y"+(i+1)));
                        break;
                    case 2:
                        matriz[i][j] = Integer.parseInt(request.getParameter("z"+(i+1)));
                        break;
                    case 3:
                        matriz[i][j] = Integer.parseInt(request.getParameter("a"+(i+1)));
                        break;
                }
            }
        }
        int determinanteS = (matriz[0][0]*matriz[1][1]*matriz[2][2])+
                (matriz[1][0]*matriz[2][1]*matriz[0][2])+(matriz[2][0]*matriz[0][1]*matriz[1][2])-
                ((matriz[0][2]*matriz[1][1]*matriz[2][0])+(matriz[1][2]*matriz[2][1]*matriz[0][0])+
                (matriz[2][2]*matriz[0][1]*matriz[1][0]));
        
        int determinanteX = (matriz[0][3]*matriz[1][1]*matriz[2][2])+
                (matriz[0][1]*matriz[1][2]*matriz[2][3])+(matriz[0][2]*matriz[1][3]*matriz[2][1])-
                ((matriz[0][1]*matriz[1][3]*matriz[2][2])+(matriz[0][3]*matriz[1][2]*matriz[2][1])+
                (matriz[0][2]*matriz[1][1]*matriz[2][3]));
        
        int determinanteY = (matriz[0][0]*matriz[1][3]*matriz[2][2])+
                (matriz[1][0]*matriz[2][3]*matriz[0][2])+(matriz[2][0]*matriz[0][3]*matriz[1][2])-
                ((matriz[0][2]*matriz[1][3]*matriz[2][0])+(matriz[1][2]*matriz[2][3]*matriz[0][0])+
                (matriz[2][2]*matriz[0][3]*matriz[1][0]));
        
        int determinanteZ = (matriz[0][0]*matriz[1][1]*matriz[2][3])+
                (matriz[0][1]*matriz[1][3]*matriz[2][0])+(matriz[0][3]*matriz[1][0]*matriz[2][1])-
                ((matriz[0][3]*matriz[1][1]*matriz[2][0])+(matriz[0][0]*matriz[1][3]*matriz[2][1])+
                (matriz[0][1]*matriz[1][0]*matriz[2][3]));
        
        double x = determinanteX/determinanteS;
        double y = determinanteY/determinanteS;
        double z = determinanteZ/determinanteS;
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Crammer</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Solución</h1>");
        out.println("<h3>x = "+x+"</h3>");
        out.println("<h3>y = "+y+"</h3>");
        out.println("<h3>z = "+z+"</h3>");
        out.println("</body>");
        out.println("</html>");
    }
}
