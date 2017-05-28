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
public class ControlCliente {
    Persistencia per = new Persistencia();
    
    public boolean eliminarCliente(int clienteid) {

        boolean elimino = false;
        String sql = "Delete from cliente where idcliente = "
                + clienteid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }
    
    public boolean insertarCliente(int clienteid,String telefo,String direc,String corr,String nom,String ape){
    boolean inserto =false;
    String sql="insert into cliente(idcliente,telefono,direccion,correo,nombre,apellido) "
            + "values ("+clienteid+",'"+telefo+"','"+direc+"','"+corr+"','"+nom+"','"+ape+"')"; 
    inserto=per.ejecutarDML(sql);
    return inserto;
    }
    
    
}
