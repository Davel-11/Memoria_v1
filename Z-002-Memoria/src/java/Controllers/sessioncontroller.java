package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.model_users;


public class sessioncontroller extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             
            HttpSession mySession = request.getSession(false);
            
            if ( mySession == request.getSession() ) {
                                
                 
                 if (request.getParameter("nom")==null){
                 
                    response.sendRedirect(request.getContextPath()+"/log_in.jsp");

                } else {
                    
                    String nom = request.getParameter("nom");
                                       
                    model_users op2 = new model_users();
                    Boolean show = op2.Loggin(nom);
                    Boolean show2 = true;
                                        
                    if (show == show2 ){
                        
                        mySession = request.getSession();                       
                                               
                        String UserInfo = request.getParameter("nom");                        
                        mySession.setAttribute("UserInfo", UserInfo);                                               
                        
                        response.sendRedirect(request.getContextPath()+"/index.jsp");

 		    } else {
                                                                        
                        String incpass = "Este Nombre de Usario No Existe, intenta crear uno :S";
                        request.setAttribute("incpass", incpass);
                        request.getRequestDispatcher("log_in.jsp").forward(request, response);                        
                        
                     }         
                }
            
            
             }   else {                                        
                        
                       response.sendRedirect(request.getContextPath()+"/log_in.jsp");                        
                        
             }
                
            
            
            
        } catch (SQLException e) {
            out.close();
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
