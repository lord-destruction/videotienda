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
    
    public boolean insertarAlquiler(String idalq,String peliidpel,String pelgeidge,String peldiriddir,String pelforidfor,String cliidcli,String feA,String feE,int val,int cant,int tot){
    boolean inserto =false;
    String sql= "insert into actores (idalquiler,pelicula_idpelicula,pelicula_genero_idgenero,pelicula_director_iddirector,pelicula_formato_idformato,cliente_idcliente,fechaA,fechaE,valor,cantidad,total)values "
            + "('"+idalq+"','"+peliidpel+"','"+pelgeidge+"','"+peldiriddir+"','"+pelforidfor+"','"+cliidcli+"','"+feA+"','"+feE+"',"+val+","+cant+","+tot+")";
            
    inserto=per.ejecutarDML(sql);
    return inserto;
    }
    
    public boolean eliminarAlquiler(String alquilerid) {

        boolean elimino = false;
        String sql = "Delete from alquiler where idAlquiler = "
                + alquilerid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
    
    public boolean ActualizarAlquiler(String idalq,String peliidpel,String pelgeidge,String peldiriddir,String pelforidfor,String cliidcli,String feA,String feE,int val,int cant,int tot){
     boolean actualizo=false;  
     String sql="Update alquiler set idalquiler = '"+idalq+"' where alquilerid="+idalq;
      actualizo = per.ejecutarDML(sql);
    return actualizo;
    }
    
    
    public Object[][] consultarAlquiler(String alquilerid) {
        Object data[][] = new Object[10][2];  //cambiar a  busqueda en toda la base de datos 
        ResultSet datos = null;
        String sql = "select idalquiler,pelicula_idpelicula,pelicula_genero_idgenero,"
                + "pelicula_director_iddirector,pelicula_formato_idformato,cliente_idcliente,fechaA,fechaE,valor,cantidad,total"
                + " from alquiler where idalquiler =" + alquilerid;
        datos = per.ejecutarConsulta(sql);
        try {

            while (datos.next()) {
                data[0][1] = datos.getString("idalquiler");
                data[0][2] = datos.getString("pelicula_idpelicula");
                data[0][3] = datos.getString("pelicula_genero_idgenero");
                data[0][4] = datos.getString("pelicula_director_iddirector");
                data[0][5] = datos.getString("pelicula_formato_idformato");
                data[0][6] = datos.getString("cliente_idcliente");
                data[0][7] = datos.getString("fechaA");
                data[0][8] = datos.getString("fechaE");
                data[0][9] = datos.getString("valor");
                data[0][10] = datos.getString("cantidad");
                data[0][11]= datos.getInt("total");
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }  
     
      
    
    
    
    
}
