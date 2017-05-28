/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;



/**
 *
 * @author lord-destruction
 */
public class ConexionDB {
    
    static String db = "alquilerpelis";
    static String login= "root";
    static String password = "root";         
    static String url="jdbc:mysql://localhost/"+db;
    
    Connection con=null;
    
    public ConexionDB(){
    
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection(url,login,password);
            if(con!=null){
            System.out.println("conexion extablecda");
            }
 
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
        catch(ClassNotFoundException e){
            System.out.println(e.toString());
        
        }
    
    }
    
    
    public Connection getConnection(){
    return con;
    }
    public void desconectar(){
    con=null;
    }
    
//    public static void main (String args[]){
//      ConexionDB cBD = new ConexionDB();
//        cBD.getConnection();
//    }
    
    
}
