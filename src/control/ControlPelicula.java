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
public class ControlPelicula {
    Persistencia per = new Persistencia();
    

      public boolean eliminarPelicula(int peliculaid) {

        boolean elimino = false;
        String sql = "Delete from pelicula where idpelicula = "
                + peliculaid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
    
}
