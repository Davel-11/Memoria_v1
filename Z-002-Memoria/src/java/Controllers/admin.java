package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.model_all_data;
import models.model_get_all_data;
import models.model_set_get;


public class admin extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                            
                            HttpSession mySession = request.getSession();
                                                        
                            //get dropdown menu filter
                            model_all_data op = new  model_all_data();                       
                            ArrayList<Object> CurrentTaskL = op.filtroUsuario();
                            request.setAttribute("CurrentTaskL", CurrentTaskL);                                   
                            
                            
                            model_get_all_data op2 = new model_get_all_data();                            
                           
                            // get all data
                            LinkedList<model_set_get> data = op2.getalldata();                                                        
                            mySession.setAttribute("data", data);

                            // get filtered data
                            Boolean FilterFinder = (Boolean)mySession.getAttribute("FilterFinder");
                            String UserInfo =  (String)mySession.getAttribute("Ftask");
                            
                            if (FilterFinder == null || FilterFinder == false ) {                                
                                                            
                            } else {
                                LinkedList<model_set_get> filter_data = op2.filtrado(UserInfo);                                                        
                                mySession.setAttribute("filter_data", filter_data);                                
                                mySession.setAttribute("FilterFinder", FilterFinder);
                            }
                            
                            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/administrador.jsp");
                            dispatch.forward(request,response);                                                                                                               
                            
            
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
