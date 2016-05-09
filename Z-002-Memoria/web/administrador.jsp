<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="models.model_set_get"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>        
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/func.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/jquery.tablesorter.js"></script>
        <title>Juego de Memoria</title>
    </head>
    <body>
        <h1>Juego de Memoria / Administradores</h1>
        
        <form  name="filtrar" method="post" action="<%= request.getContextPath() %>/filtro">
                    <select name="filtrar">
                            <option value="empty">filtrar/Desfiltrar</option>
                            
                            <%
                                ArrayList<Object> FilterList = (ArrayList)request.getAttribute("CurrentTaskL");
                                Iterator<Object> it3 = FilterList.iterator();                                                                                                       
                                                     
                                    while(it3.hasNext())
                                    {
                                         Object element4 = it3.next();
                                         
                                         out.print("<option value ='"+element4+"'>");
                                         out.print(element4);
                                         out.print("</option>");
                                         out.println("<br />");
                                    }                                           
                             %>   
                    </select>
                    <br /><br />
                    <button type="submit" class="btn btn-primary">Apliar Filtro</button>
           </form>
                    <%
                    Boolean FilterData2 = (Boolean)session.getAttribute("FilterFinder");
                    if (FilterData2==null||FilterData2==false){
                        out.println("<p> </p>");
                     }  else {                       
                       out.println("<p>Filtrado Por --> "+(String)session.getAttribute("Ftask"));
                       out.println("<p> --> "+(Boolean)session.getAttribute("FilterFinder"));
                        out.println("</p>");                        
                    }
                    
                    %>
           <br>         
        
        <table class="table table-striped" id="myTable" class="tablesorter">
            
            <thead class="table table-bordered" id="myTable" class="tablesorter">
                    <th>ID</th>
                    <th>Puntuaciones</th>
                    <th>Intentos Permitidos Por Nivel</th>                    
                    <th>Intentos Realizados Por Nivel</th>
                    <th>Veces Juadas</th>
                    <th>Fecha</th>
                    
                </thead>   
                
          <tbody>      
        <%
            
                
            if (FilterData2==null||FilterData2==false){
                
                               
                                LinkedList<model_set_get> gdatos = (LinkedList)session.getAttribute("data");

                                for (int i=0; i <gdatos.size();i++){
                                    out.println("<tr>");                                                    
                                    out.println("<td>"+gdatos.get(i).getNom()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getPunteo()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getIntentos_permitidos()+"</td>");                                    
                                    out.println("<td>"+gdatos.get(i).getIntentos_realizados()+"</td>");
                                    out.println("<td>"+gdatos.get(i).getJugadas()+"</td>");                          
                                    out.println("<td>"+gdatos.get(i).getFecha()+"</td>"); 
                                    out.println("</tr>");
                                 }
            
            } else {            
                                 
                                LinkedList<model_set_get> gdatos2 = (LinkedList)session.getAttribute("filter_data");

                                for (int i=0; i <gdatos2.size();i++){
                                    out.println("<tr>");                                                    
                                    out.println("<td>"+gdatos2.get(i).getNom()+"</td>");
                                    out.println("<td>"+gdatos2.get(i).getPunteo()+"</td>");
                                    out.println("<td>"+gdatos2.get(i).getIntentos_permitidos()+"</td>");                                    
                                    out.println("<td>"+gdatos2.get(i).getIntentos_realizados()+"</td>");
                                    out.println("<td>"+gdatos2.get(i).getJugadas()+"</td>");                          
                                    out.println("<td>"+gdatos2.get(i).getFecha()+"</td>"); 
                                    out.println("</tr>");
                                 }
            
            }
            
                               
                                
        
        %>
        </tbody>
        </table>
        
    </body>
</html>
