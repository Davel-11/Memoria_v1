package models;

import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;


public class model_get_all_data extends database_con {

   
     public LinkedList<model_set_get> getalldata() throws SQLException {
         
         LinkedList<model_set_get> ltasks = new LinkedList<model_set_get>();
         
         try {
                con();                
                st = con.createStatement();                
                rs  = st.executeQuery("select * from table_data");

                while (rs.next()){
                    model_set_get datos = new model_set_get();
                    datos.setId(rs.getInt("id"));
                    datos.setNom(rs.getString("nom"));
                    datos.setNivel(rs.getInt("nivel"));
                    datos.setPunteo(rs.getInt("punteo"));
                    datos.setIntentos_permitidos(rs.getInt("intentos_permitidos"));
                    datos.setIntentos_realizados(rs.getInt("intentos_realizados"));
                    datos.setJugadas(rs.getInt("jugadas"));
                    datos.setFecha(rs.getString("fecha"));
                    
                    ltasks.add(datos);
                }
                
                rs.close();
                st.close();
                con.close();
         }catch (Exception e){
            e.printStackTrace();
         }         
         return ltasks;
      }  
     
     public LinkedList<model_set_get> filtrado(String nom) throws SQLException  {
         
         LinkedList<model_set_get> ltasks = new LinkedList<model_set_get>();
         
         try {          
                con();
                st = con.createStatement();                
                rs  = st.executeQuery("select * from table_data WHERE nom='"+nom+"' ");

                while (rs.next()){
                    model_set_get datos = new model_set_get();
                    datos.setId(rs.getInt("id"));
                    datos.setNom(rs.getString("nom"));
                    datos.setNivel(rs.getInt("nivel"));
                    datos.setPunteo(rs.getInt("punteo"));
                    datos.setIntentos_permitidos(rs.getInt("intentos_permitidos"));
                    datos.setIntentos_realizados(rs.getInt("intentos_realizados"));
                    datos.setJugadas(rs.getInt("jugadas"));
                    datos.setFecha(rs.getString("fecha"));                    
                    ltasks.add(datos);
                }
                
                rs.close();
                st.close();
                con.close();
         }catch (Exception e){
            e.printStackTrace();
         }         
         return ltasks;
      }        
          
}
