<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>                       
        <meta charset=UTF-8"/>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" type="text/css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/newcss.css">        
        <title>Juego de Memoria</title>
       
    </head>
    <body>
    <div id="warp">    
        <h1>Juego de Memoria</h1>               
        
        <h3>Juega Gratis :)</h3>
        
        <h3>Ingresa Con tu Nombre de Usuario :D</h3>
        <br />
        <form class="form-group" name="form1" method="post" action="<%=request.getContextPath()%>/sessioncontroller">
            <div class="form-group">
              <label for="exampleInputName2">Nombre de Usuario</label>
              <input type="text" class="form-control" placeholder="Ejemplo: Christian1990" required="required" name="nom">
            </div>
            
            <button type="submit" class="btn btn-primary">Ingresa al Juego </button>
        </form>
            <br />
            
            <%         
                    if (request.getAttribute("incpass")==null) {
                    
                    } else {
                    out.print("<br />");
                    out.println("<p>"+request.getAttribute("incpass")+"</p>");
                    out.print("<br />");                                                                     
                    }    
            %>
        
        <br />
                       
            
        
        <h3>Crea tu Nombre De Usuario: </h3>
        <br />
        <form class="form-group" name="form2" method="post" action="<%=request.getContextPath()%>/add_user">
            <div class="form-group">
              <label for="exampleInputName2">Nombre o Nombre Nick</label>
              <input type="text" class="form-control" placeholder="Ejemplo: Carlitos07" required="required" name="nom">
            </div>
            
            
            <button type="submit" class="btn btn-success">Crear Usuario</button>
        </form>
            
        <br />
            <% if(request.getAttribute("responseAddUser")==null){
            
                }else { out.println("<p>"+request.getAttribute("responseAddUser")+"</p>"); }
            %>
     
    </div>         
    </body>
</html>
