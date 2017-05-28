/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lord-destruction
 */
public class ControlActor {
    
    Persistencia per = new Persistencia();
    
    
    public boolean insertarActor(String idactor,String nombre){
    boolean inserto =false;
    String sql="insert into actores(idactor,nombre) values ('"+idactor+"','"+nombre+"')"; 
    inserto=per.ejecutarDML(sql);
    return inserto;
    }
    
     
      public boolean eliminarActor(int actorid) {

        boolean elimino = false;
        String sql = "Delete from actor where idactor = "
                + actorid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
     
      
    public boolean actualizarActor(String actorid, String nombrea) {

        boolean actualizo = false;

        String sql = "update actores set nombre= " + nombrea + "where idactor= "
                + actorid;
        actualizo = per.ejecutarDML(sql);

        return actualizo;
    }
      
    public String consultarActorPorNombre(String nombrea){
    String codigo ="";
    ResultSet res = null;
    String sql="select idactor from actor where nombre = "+nombrea ;
    res=per.ejecutarConsulta(sql);
    
    try{
            while(res.next()){
                codigo = res.getString(1);
            }
    }catch(SQLException ex){
        Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
    }
            
    return codigo;
    }  
    
    
public Object[][] consultarActor(int idactor) {
        Object data[][] = new Object[10][2];
        ResultSet datos = null;
        String sql = "select idactor, nombre from actores where actorid =" + idactor;
        datos = per.ejecutarConsulta(sql);
        try {

            while (datos.next()) {
                data[0][0] = datos.getString("idactor");
                data[0][1] = datos.getString("nombre");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
   
    



    
    public static void main(String[] args) {
       ControlActor ca = new ControlActor();
       ca.insertarActor("A01", "carlos");
              
    }
   
    
    
}
