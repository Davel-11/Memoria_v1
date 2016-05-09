<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <%
            
            
            
            if ( (String)session.getAttribute("UserInfo") == null ) {
                    
                       //String incpass = "Usuario invalido de Index Memoria";
                       //request.setAttribute("incpass", incpass);
                       request.getRequestDispatcher("log_in.jsp").forward(request, response);      
                    
                    
        } 
        
        
        %>       
        
        <meta charset=UTF-8"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" type="text/css">
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/cards.js"></script>
         <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/newcss.css">
        
        <title>Juego de Memoria </title>
    </head>
    
    <body  onload="datoUsuario('${UserInfo}'); onload=intentos_permitidosf(8); onload=nivel(3)">
        <div id="warp">
       
        
        <a href="<%= request.getContextPath()%>/log_out" class="btn btn-warning" id="log_out">cerrar sesión</a>
        <h3>Bienvenid@: ${UserInfo}</h3>
        <h1>Juego de Memoria</h1>
        
        <p id="datousuario"></p>
        
        
        <table class="table table-bordered">
            <tr>
                <td >Nivel:</td>                        
                <td ><p id="nivel"></td>
            </tr>            
            <tr>
                <td >Puntuacion: </td>                        
                <td id='puntuacion' >0</td>
            </tr>            
            <tr>
                <td > Intentos Permitidos: </td>                        
                <td id="intentos_permitidosf">0</td>
            </tr>            
            <tr>
                <td > Intentos Realizados: </td>                        
                <td id="intentos_realizados">0</td>
            </tr>
                        
            <tr>
            <td > Haz Jugado Este Nivel: </td>                        
            <td id="veces_judadas">0</td>
            </tr>
            
        </table>
        
        
        
        
           
        <h3 id="alerta" class="btn btn-success"> Escoge Una Carta</h3>
            
        
        
        
            <div id="wrap2">      
            <table class="table table-bordered" id="table_memoria">
                <%
                Date yourdate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(yourdate);
                int seconds = calendar.get(Calendar.SECOND);
                int sec =0;
                if(seconds == 1 || seconds == 2 || seconds == 3 || seconds == 4 || seconds == 5 || seconds == 6 || seconds == 7 || seconds == 8 || seconds == 9 || seconds == 0 ) {
                  sec = 0;              
                }

                if(seconds == 10 || seconds == 11 || seconds == 12 || seconds == 13 || seconds == 14 || seconds == 15 || seconds == 16 || seconds == 17 || seconds == 18 || seconds == 19 ) {
                  sec = 1;              
                }

                if(seconds == 20 || seconds == 21 || seconds == 22 || seconds == 23 || seconds == 24 || seconds == 25 || seconds == 26 || seconds == 27 || seconds == 28 || seconds == 29 ) {
                  sec = 2;              
                }

                if(seconds == 30 || seconds == 31 || seconds == 32 || seconds == 33 || seconds == 34 || seconds == 35 || seconds == 36 || seconds == 37 || seconds == 38 || seconds == 39 ) {
                  sec = 3;              
                }

               if(seconds == 40 || seconds == 41 || seconds == 42 || seconds == 43 || seconds == 44 || seconds == 45 || seconds == 46 || seconds == 47 || seconds == 48 || seconds == 49 ) {
                  sec = 4;              
                }

                if(seconds == 50 || seconds == 51 || seconds == 52 || seconds == 53 || seconds == 54 || seconds == 55 || seconds == 56 || seconds == 57 || seconds == 58 || seconds == 59 || seconds == 60 ) {
                  sec = 5;              
                }



                int[][] orden2 = new int[][] {
                    {0,8,3,5,2,1,7,9,12,10,4,6,11},                
                    {0,6,10,11,3,4,1,9,5,8,2,7,12},                
                    {0,3,6,10,1,4,11,8,7,9,12,2,5},                
                    {0,7,11,9,3,2,1,12,5,4,6,8,10},                
                    {0,3,12,1,6,7,5,2,9,8,11,10,4},                
                    {0,5,7,8,4,10,2,1,6,3,11,10,9},                
                    {0,11,5,2,9,7,6,3,1,4,8,10,12},                
                    {0,10,3,5,9,12,8,6,1,2,11,7,4},                
                    {0,6,11,9,4,1,5,2,8,7,3,12,10},                
                    {0,4,2,9,6,11,7,1,3,10,8,12,5}
                };

                int count = 0;
                for (int i=0 ; i <= 2; i++){

                    out.println("<tr>");
                        for (int j=0 ; j <= 3; j++)
                        {   
                        count++;
                        //out.println("<td><img id='myImage"+count+"' onclick='changeImage"+count+"();' src='M-which.png' width='125' height='150'></td>");                    
                         out.println("<td><img id='myImage"+orden2[sec][count]+"' onclick='changeImage"+orden2[sec][count]+"();' src='M-which.png' width='125' height='150'></td>");
                        }
                    out.println("</tr>");
                    out.println("<br />");


                }

            %>
            </div>
        
        </div>
        </table>
        
            
    </body>
</html>
