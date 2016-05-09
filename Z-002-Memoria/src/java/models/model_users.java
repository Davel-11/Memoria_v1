package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class model_users extends database_con {
        
    public String addNewUser(String nom)throws SQLException {
        
        con();
        String sql = "INSERT INTO table_users (nom) VALUES (?)";
        String sql2 = "SELECT nom FROM table_users";
        
        st = con.createStatement();
        rs = st.executeQuery(sql2);
        
        Boolean boo = null;
        Boolean boo2 = true;
        
        ArrayList<Object> list1 = new ArrayList<Object>();
        
        while(rs.next()){
            list1.add(rs.getString(1));
        }
        
        Iterator it = list1.iterator();
        
        while(it.hasNext()){
            Object element = it.next();
            if(element.equals(nom)){
                boo = true;
            }             
        }
        
        if ( boo == boo2 ) {
             String Existing = "Intenta Un Nombre Diferente este ya existe! :("; 
             return Existing;
        } else {
            pst = con.prepareStatement(sql);
            pst.setString(1, nom);                
            pst.executeUpdate();
            
            pst.close();
            dis();
            
            st.close();
            rs.close();
            dis();
            
            String Existing = "Tu Usuario fue Creado Exitosamente!"; 
            return Existing;
            
        }                      
    }
    
    public Boolean Loggin(String nom) throws SQLException {
        
        Boolean accessing=null;
        con();
        String sql = "SELECT nom FROM table_users WHERE nom='"+nom+"' ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        
       if(rs.next()){
            accessing = true;  
        } else {
            accessing = false;
        }
        
        rs.close();
        st.close();
        dis();
        return accessing;
    }
    
}

