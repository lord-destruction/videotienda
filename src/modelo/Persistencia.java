/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lord-destruction
 */
public class Persistencia {
    ConexionDB CDB=null;
    
    public boolean ejecutarDML(String sql){
    boolean ejecuto=false;
    CDB=new ConexionDB();
    
    try{
        PreparedStatement PS=CDB.getConnection().prepareStatement(sql);
        int recive =PS.executeUpdate();
        if(recive>0){
            ejecuto=true;
        
        }
        
    }catch(Exception e){
        System.out.println("ERROR: "+ e.toString());
    }
    CDB.desconectar();
    return ejecuto;
    
    
    }
    
    public ResultSet ejecutarConsulta(String sql){
        ResultSet datos=null;
        CDB =new ConexionDB();
        
        try{
        PreparedStatement PS=CDB.getConnection().prepareStatement(sql);
        datos=PS.executeQuery();
        
        } catch(Exception e){
            System.out.println("Erro "+e.toString());
        }
    
    return datos;
    }
    
    
    public static void main(String[] args) {
        Persistencia p = new Persistencia();
        String sql = "Insert into director values ('D12','DAGO GARCIA',38)";
        
        boolean inserto = p.ejecutarDML(sql);
        if(inserto){
            System.out.println("Insertado correctamente !!!!");
        }
    
    }
}
