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
public class ControlUsuario {
   
    
    Persistencia per = new Persistencia();
    
    

      public boolean eliminarUsusario(int usuarioid) {

        boolean elimino = false;
        String sql = "Delete from usuario where idusuario = "
                + usuarioid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
      
    public boolean insertarUsuario(int usuarioid,String tipou,String log,String pass ){
    boolean inserto =false;
    String sql="insert into usuariosistema(idusuariosistema,tipo_usuario,login,pasword) "
            + "values ("+usuarioid+",'"+tipou+"','"+log+"','"+pass+"')"; 
    inserto=per.ejecutarDML(sql);
    return inserto;
    }  
    
    
}
