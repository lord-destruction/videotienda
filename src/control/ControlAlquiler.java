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
public class ControlAlquiler {
    
    Persistencia per = new Persistencia();
    

      public boolean eliminarAlquiler(int alquilerid) {

        boolean elimino = false;
        String sql = "Delete from alquiler where idAlquiler = "
                + alquilerid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
      
    public Object[][] consultarAlquiler(int alquilerid) {
        Object data[][] = new Object[10][2];  //cambiar a  busqueda en toda la base de datos 
        ResultSet datos = null;
        String sql = "select idalquiler,fechaA,fechaE,valor,cantidad,pelicula_idpelicula,pelicula_formato_idformato,"
                + "pelicula_director_iddirector,pelicula_genero_idgenero,cliente_idcliente,"
                + " from alquiler where idalquiler =" + alquilerid;
        datos = per.ejecutarConsulta(sql);
        try {

            while (datos.next()) {
                data[0][1] = datos.getString("idalquiler");
                data[0][2] = datos.getString("fechaA");
                data[0][3] = datos.getString("fechaE");
                data[0][4] = datos.getString("valor");
                data[0][5] = datos.getString("cantidad");
                data[0][6] = datos.getString("pelicula_idpelicula");
                data[0][7] = datos.getString("pelicula_formato_idformato");
                data[0][8] = datos.getString("pelicula_director_iddirector");
                data[0][9] = datos.getString("pelicula_genero_idgenero");
                data[0][10] = datos.getString("cliente_idcliente");
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }  
     
      
    
    
    
    
}
