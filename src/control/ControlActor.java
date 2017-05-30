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
 
    public boolean insertarActor(String idactor, String nombre, String apellido, String paisO) {
        boolean inserto = false;
        String sql = "insert into actores(idactores,nombreactor,apellidoactor,paisorigen) values ('" + idactor + "','" + nombre + "','" + apellido + "','" + paisO + "')";
        inserto = per.ejecutarDML(sql);
        return inserto;
    }

    public boolean eliminarActor(int actorid) {

        boolean elimino = false;
        String sql = "Delete from actores where idactores = "
                + actorid;
        elimino = per.ejecutarDML(sql);
        return elimino;
    }

    public boolean actualizarActor(String actorid, String nombrea) {

        boolean actualizo = false;

        String sql = "update actores set nombre= " + nombrea + "where idactores= "
                + actorid;
        actualizo = per.ejecutarDML(sql);

        return actualizo;
    }

    public int contarActor() {
        int numero = 0;
        String sql = "select count(idactores) num from actores";
        ResultSet res = per.ejecutarConsulta(sql);
        try {
            while (res.next()) {
                numero = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }

    public Object[][] mostrarActores() {
        Object data[][] = new Object[contarActor()][4];
        ResultSet res = null;
        String sql = "Select idactores, nombreactor from actores";
        res = per.ejecutarConsulta(sql);
        try {
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString(1);
                data[i][1] = res.getString(2);
                data[i][1] = res.getString(3);
                data[i][1] = res.getString(4);
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] consultarActorId(int idactor) {
        Object data[][] = new Object[contarActor()][2];
        ResultSet datos = null;
        String sql = "select idactores, nombreactor,apellidoactor,paisorigen from actores where idactores =" + idactor;
        datos = per.ejecutarConsulta(sql);
        try {
            int i = 0;
            while (datos.next()) {
                data[i][0] = datos.getString("idactores");
                data[i][1] = datos.getString("nombreactor");
                data[i][2] = datos.getString("nombreactor");
                data[i][3] = datos.getString("paisorigen");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public String consultarActorPorNombre(String nombrea) {
        String codigo = "";
        ResultSet res = null;
        String sql = "select idactores from actores where nombreactor = " + nombrea;
        res = per.ejecutarConsulta(sql);

        try {
            while (res.next()) {
                codigo = res.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigo;
    }

    public Object[] mostrarNombresActores() {
        Object[] data = new Object[contarActor()];
        ResultSet res = null;
        String sql = "select nombreactor,apellidoactor from actores";
        res = per.ejecutarConsulta(sql);
        int i = 0;
        try {
            while (res.next()) {
                data[i] = res.getString(1);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlActor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }


    
    public static void main(String[] args) {
       ControlActor ca = new ControlActor();
       ca.insertarActor("A01", "carlos","valderrama","mosul");
              
    }
   
    
    
}
