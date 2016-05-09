package models;

import java.sql.*;


public class database_con {

    Connection con = null;
    String server,db,user,pass = "";
    
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;
    
    
    public database_con(){
        
        server = "localhost";
        db = "memoria";
        user = "root";
        pass = "";
        
        /*
        server = "localhost:3306";
        db = "xspacein_memoria";
        user = "xspacein_user";
        pass = "Test2020";
        */
    }
    
    public void con() throws SQLException {        
        try {  
            Class.forName("com.mysql.jdbc.Driver");            
            con = DriverManager.getConnection("jdbc:mysql://"+this.server+"/"+this.db,this.user,this.pass);
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    } 
    
    public void dis() throws SQLException {
        con.close();
    }
    
    
    
    
}
