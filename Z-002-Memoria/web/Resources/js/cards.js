
var Jugando = 0;

var encon1 = 0;
var encon2 = 0;

var acerto = null;

var x1 = null;
var x2 = null;

var x3 = null;
var x4 = null;

var x5 = null;
var x6 = null;

var x7 = null;
var x8 = null;

var x9 = null;
var x10 = null;

var x11 = null;
var x12 = null;


var puntos =0;
var intentosinfo =0;
var veces_judadas = 0;


function datoUsuario(a){
            var nom = a; 
            document.getElementById("datousuario").innerHTML = nom;                       
        }
        
function nivel(a){
            var nivel = a; 
            document.getElementById("nivel").innerHTML = nivel;                       
}

function intentos_permitidosf(a){
        var intentos_permitidosf = a;
        document.getElementById("intentos_permitidosf").innerHTML = intentos_permitidosf; 
}


/* Para SAber si Perdio */ 
/* no se necesita accion al agregar mas tarjetas de memoria */
function ContadorIntentos(){
    
    
    var intentos_permitidos = parseInt(document.getElementById("intentos_permitidosf").innerHTML);
    
        
    if (intentosinfo === intentos_permitidos ) 
    
    {
        
        alert("Has Alcanzado El Limite de Intentos Permitidos, Intenta Nuevamente!");    
        
        veces_judadas++;        
        document.getElementById("veces_judadas").innerHTML = veces_judadas;        
        Limpiar();   
        
       }
}

/* si ganaste */
/* al agregar mas tarjetas solo modificar el if con las x */
function Ganaste(puntos,intentosinfo){
   
        if  (x1 === true && x3=== true && x5 === true && x7 === true && x9 === true && x11 === true )  {
        
        var intentos_permitidos = parseInt(document.getElementById("intentos_permitidosf").innerHTML);
        var nom = document.getElementById("datousuario").innerHTML;
        var nivel = parseInt(document.getElementById("nivel").innerHTML);
        
        veces_judadas++;
        document.getElementById("veces_judadas").innerHTML = veces_judadas;               
         
        if(nivel !== 3) {
            alert("Has Ganado El Nivel "+nivel+", Con una putuacion de "+puntos+",  Presiona Ok para ir al Proximo Nivel");
        }
        
        if ( nivel === 1) {
        window.location.href ="next_level_1?nivel="+nivel+"&&puntuacion="+puntos+"&&intentos_permitidos="+intentos_permitidos+"&&veces_judadas="+veces_judadas+"&&intentos_realizados="+intentosinfo+"&&nom="+nom+"";
        }
        if (nivel === 2 ) {
       window.location.href ="next_level_2?nivel="+nivel+"&&puntuacion="+puntos+"&&intentos_permitidos="+intentos_permitidos+"&&veces_judadas="+veces_judadas+"&&intentos_realizados="+intentosinfo+"&&nom="+nom+"";     
            
        } if (nivel === 3 ) {
            alert("Has Completado todos Los Niveles Felicitaciones!");   
            window.location.href ="index.jsp";
        }                                     
        //Limpiar();        
    }
}

function Limpiar()
{
    x1 = null;
    x2 = null;
    x3 = null;
    x4 = null;
    x5 = null;
    x6 = null; 
    x7 = null;
    x8 = null;
    x9 = null;
    x10 = null;
    x11 = null;
    x12 = null;
    
    changeImage1Close();
    changeImage2Close();
    changeImage3Close();
    changeImage4Close();
    changeImage5Close();
    changeImage6Close();
    
    changeImage7Close();
    changeImage8Close();
    changeImage9Close();
    changeImage10Close();
    changeImage11Close();
    changeImage12Close();
    
    
    intentosinfo = 0;
    document.getElementById("intentos_realizados").innerHTML = intentosinfo;
    
    puntos = 0;
    document.getElementById("puntuacion").innerHTML = puntos;
    
    document.getElementById("alerta").innerHTML = "Presiona Una Carta";
    
}

/* accion realizada para terminar juego o ganarlo */
/* no se necesita accion al agregar mas tarjetas de memoria */
function Comparar(){
    
            puntos =puntos+10;
            document.getElementById("puntuacion").innerHTML = puntos; 
            document.getElementById("intentos_realizados").innerHTML = intentosinfo;            
            Ganaste(puntos,intentosinfo);
            
            Jugando = 0;
            encon1 = 0;
            encon2 = 0;                        
            acerto = true;      
            
            setTimeout(ContadorIntentos,250);
    
}


function Encontrado() {
    
    Jugando=Jugando+1;
    
    
    if (Jugando === 2) {        
        
        intentosinfo++;
    
        if (encon1 === 1 && encon2 === 2) {                       
            
            
            x1 = true;
            x2 = true;
            document.getElementById("alerta").innerHTML = "Pareja 1 correcta";
            Comparar();
         } 
        
        if (encon1 === 3 && encon2 === 4) {                         
                       
            x3 = true;
            x4 = true;
            document.getElementById("alerta").innerHTML = "Pareja 2 correcta";
            Comparar();
        }
        
        if (encon1 === 5 && encon2 === 6) {                       
            
            x5 = true;
            x6 = true;
            document.getElementById("alerta").innerHTML = "Pareja 3 correcta";
            Comparar();
        }
        
        
        if (encon1 === 7 && encon2 === 8) {                       
            
            x7 = true;
            x8 = true;
            document.getElementById("alerta").innerHTML = "Pareja 4 correcta";
            Comparar();
        }
        
        if (encon1 === 9 && encon2 === 10) {                       
            
            x9 = true;
            x10 = true;
            document.getElementById("alerta").innerHTML = "Pareja 5 correcta";
            Comparar();
        }
        
        if (encon1 === 11 && encon2 === 12) {                       
            
            x11 = true;
            x12 = true;
            document.getElementById("alerta").innerHTML = "Pareja 6 correcta";
            Comparar();
        }
        
        
        if (acerto === true) 
        { 
            acerto = false;
        } else {
            
            if ( puntos > 0) {
                puntos=puntos-5;
                document.getElementById("puntuacion").innerHTML = puntos;
                }
            
            Jugando = 0;
            encon1 = 0;
            encon2 = 0;
            acerto = false; 
            
            changeImage1Close();
            changeImage2Close();
            
            changeImage3Close();
            changeImage4Close();
            
            changeImage5Close();
            changeImage6Close();
            
            changeImage7Close();
            changeImage8Close();
            
            changeImage9Close();
            changeImage10Close();
            
            changeImage11Close();
            changeImage12Close();
                                               
            document.getElementById("intentos_realizados").innerHTML = intentosinfo;
            document.getElementById("alerta").innerHTML = "Intenta Nuevamente";
            setTimeout(ContadorIntentos,250);
            
            
         }                         
    }

    
}



function changeImage1() {             
           
    var image = document.getElementById('myImage1');         
    image.src = "M-Dog.png"; 
    encon1 = 1;  
    setTimeout(Encontrado,500);                       
}

function changeImage2() {
    
     
     var image = document.getElementById('myImage2');         
     image.src = "M-Dog.png";
     encon2 = 2;
     setTimeout(Encontrado,500);
}

function changeImage3() {
        
    var image = document.getElementById('myImage3');         
     image.src = "M-Cer.png";
     encon1 = 3;
    setTimeout(Encontrado,500);
}

function changeImage4() {
    
    
    var image = document.getElementById('myImage4');         
    image.src = "M-Cer.png";
    encon2 = 4;
   setTimeout(Encontrado,500);
}

function changeImage5() {
       
     var image = document.getElementById('myImage5');         
     image.src = "M-Oso.png";
     encon1 = 5; 
    setTimeout(Encontrado,500);
}

function changeImage6() {        
    var image = document.getElementById('myImage6');         
    image.src = "M-Oso.png";
    encon2 = 6;
   setTimeout(Encontrado,500);
}


function changeImage7() {        
    var image = document.getElementById('myImage7');         
    image.src = "M-Ele.png";
    encon1 = 7;
   setTimeout(Encontrado,500);
} 
   
function changeImage8() {        
    var image = document.getElementById('myImage8');         
    image.src = "M-Ele.png";
    encon2 = 8;
   setTimeout(Encontrado,500);
   }  
   
function changeImage9() {        
    var image = document.getElementById('myImage9');         
    image.src = "M-Gat.png";
    encon1 = 9;
   setTimeout(Encontrado,500);
   }  
   
function changeImage10() {        
    var image = document.getElementById('myImage10');         
    image.src = "M-Gat.png";
    encon2 = 10;
   setTimeout(Encontrado,500);
   }  
   
   
function changeImage11() {        
    var image = document.getElementById('myImage11');         
    image.src = "M-pin.png";
    encon1 = 11;
   setTimeout(Encontrado,500);
   }  
   
function changeImage12() {        
    var image = document.getElementById('myImage12');         
    image.src = "M-pin.png";
    encon2 = 12;
   setTimeout(Encontrado,500);
   } 

/**********/



function changeImage1Close() {
    if (x1 === true) {  } else {
    var image = document.getElementById('myImage1');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}

function changeImage2Close() {
    if (x2 === true) {} else {
    var image = document.getElementById('myImage2');         
    image.src = "M-which.png";  
    acerto = false;
    }
}


function changeImage3Close() {
    if (x3 === true) {} else {
    var image = document.getElementById('myImage3');         
    image.src = "M-which.png";
    acerto = false;
    }
}

function changeImage4Close() {
    if (x4 === true) {} else {
    var image = document.getElementById('myImage4');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}


function changeImage5Close() {
    if (x5 === true) {} else {
    var image = document.getElementById('myImage5');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}

function changeImage6Close() {
    if (x6 === true) {} else {
    var image = document.getElementById('myImage6');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}


function changeImage7Close() {
    if (x7 === true) {} else {
    var image = document.getElementById('myImage7');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}

function changeImage8Close() {
    if (x8 === true) {} else {
    var image = document.getElementById('myImage8');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}


function changeImage9Close() {
    if (x9 === true) {} else {
    var image = document.getElementById('myImage9');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}

function changeImage10Close() {
    if (x10 === true) {} else {
    var image = document.getElementById('myImage10');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}


function changeImage11Close() {
    if (x11 === true) {} else {
    var image = document.getElementById('myImage11');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}

function changeImage12Close() {
    if (x12 === true) {} else {
    var image = document.getElementById('myImage12');         
    image.src = "M-which.png"; 
    acerto = false;
    }
}