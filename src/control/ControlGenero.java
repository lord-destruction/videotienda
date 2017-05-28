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
public class ControlGenero {
 
    Persistencia per = new Persistencia();
    

      public boolean eliminarGenero(int generoid) {

        boolean elimino = false;
        String sql = "Delete from genero where idgenero = "
                + generoid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
      
      public boolean insertarGenero(int generoid,String gener){
    boolean inserto =false;
    String sql="insert into genero(idgenero,genero) "
            + "values ("+generoid+",'"+gener+"')"; 
    inserto=per.ejecutarDML(sql);
    return inserto;
    } 
    
}
