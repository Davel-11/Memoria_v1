package models;

public class model_set_get {

    private int id;
    private String nom;
    private int nivel;
    private int punteo;
    private int intentos_permitidos;
    private int intentos_realizados;
    private int jugadas;
    private String fecha;
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
     public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
    
    
     public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getFecha(){
        return fecha;
    }
    
     public void setJugadas(int jugadas){
        this.jugadas = jugadas;
    }
    public int getJugadas(){
        return jugadas;
    }
    
    
    public void setIntentos_realizados(int intentos_realizados){
        this.intentos_realizados = intentos_realizados;
    }
    public int getIntentos_realizados(){
        return intentos_realizados;
    }
    
    
    
    public void setIntentos_permitidos(int intentos_permitidos){
        this.intentos_permitidos = intentos_permitidos;
    }
    public int getIntentos_permitidos(){
        return intentos_permitidos;
    }
    
    public void setPunteo(int punteo){
        this.punteo = punteo;
    }
    public int getPunteo(){
        return punteo;
    }
    
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public int getNivel(){
        return nivel;
    }
    
    
    
}
   