package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.model_all_data;

/**
 *
 * @author Davel-11
 */
public class next_level_2 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {                                
            
            String nom = request.getParameter("nom");
            //out.println("nom: "+nom);
            
            int nivel = Integer.parseInt(request.getParameter("nivel"));
            //out.println("nivel: "+nivel);
            
            int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
            //out.println("puntuacion: "+puntuacion);
            
            int intentos_permitidos = Integer.parseInt(request.getParameter("intentos_permitidos"));
            //out.println("intentos_permitidos: "+intentos_permitidos);                      
            
            int intentos_realizados = Integer.parseInt(request.getParameter("intentos_realizados"));
           // out.println("intentos_realizados: "+intentos_realizados);
            
            int veces_judadas = Integer.parseInt(request.getParameter("veces_judadas"));            //out.println("veces_judadas: "+veces_judadas);
            
            
            Date edate = new Date();          
                       
            java.sql.Date sqlDate = new java.sql.Date(edate.getTime()); 
            out.println(sqlDate);
            
            model_all_data op = new model_all_data();
            
            op.add_data(nom, nivel, puntuacion, intentos_permitidos, intentos_realizados, veces_judadas, sqlDate);
            response.sendRedirect(request.getContextPath()+"/index03.jsp");
            
        } catch(SQLException e) {
            e.printStackTrace();
       }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
