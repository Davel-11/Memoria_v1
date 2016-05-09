package models;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


public class model_all_data extends database_con {        
    
   
    public void add_data(String nom, int nivel, int punteo, int intentos_permitidos, int intentos_realizados,int jugadas, Date fecha) throws SQLException {
    
        con();
        String sql = "INSERT INTO table_data (nom, nivel, punteo, intentos_permitidos, intentos_realizados, jugadas, fecha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        pst = con.prepareStatement(sql);
        pst.setString(1, nom);
        pst.setInt(2, nivel);
        pst.setInt(3, punteo);
        pst.setInt(4,intentos_permitidos);
        pst.setInt(5,intentos_realizados);
        pst.setInt(6,jugadas);
        pst.setDate(7,fecha);        
                
        pst.executeUpdate(); 
               
        pst.close();
        dis();
        
    }
        
    public ArrayList<Object>filtroUsuario() throws SQLException {
       con();
       String sql = "SELECT nom FROM table_data GROUP BY nom";
       
       st = con.createStatement();
       rs = st.executeQuery(sql);
       
       ArrayList<Object> currentTaskL = new ArrayList<Object>();
       
       while (rs.next()){
         currentTaskL.add(rs.getString(1));
       }
       
       dis();
       return currentTaskL;
   }
    
}
