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
public class ControlFormato {
    Persistencia per = new Persistencia();
    

      public boolean eliminarFormato(int formatoid) {

        boolean elimino = false;
        String sql = "Delete from formato where idformator = "
                + formatoid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
    
   public boolean insertarFormato(int formatoid,String format){
    boolean inserto =false;
    String sql="insert into formato(idformato,formato) "
            + "values ("+formatoid+",'"+format+"')"; 
    inserto=per.ejecutarDML(sql);
    return inserto;
    }  
      
      
    
}
