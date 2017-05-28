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
public class ControlDirector {
   Persistencia per = new Persistencia();
   
   
   public boolean eliminarDirector(int directorid) {
        boolean elimino = false;
        String sql = "Delete from director where iddirector = "
                + directorid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
   
   public boolean insertarDirector(int directorid,String nom,String ape,int eda){
    boolean inserto =false;
    String sql="insert into director(iddirecor,nombre,apellido,edad) "
            + "values ("+directorid+",'"+nom+"','"+ape+"',"+eda+")"; 
    inserto=per.ejecutarDML(sql);
    return inserto;
    }
   
   
}
