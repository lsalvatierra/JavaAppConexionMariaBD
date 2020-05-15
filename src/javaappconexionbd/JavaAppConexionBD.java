/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappconexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luis_
 */
public class JavaAppConexionBD {

    /**
     * @param args the command line arguments
     */
    Connection cnx;
    String bd = "bdnotas";
    String url ="jdbc:mysql://localhost:3306/"+bd;
    String user = "root";
    String password = "admin";
    
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection)DriverManager.getConnection(url, user, password);
            System.out.println("Se conectó");            
        }catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
        }
        return cnx;
    }
    
    public void desconectar(){
        try{
            cnx.close();
        }catch(SQLException ex){
            System.err.println("No se pudo cerrar conexión");
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        JavaAppConexionBD c = new JavaAppConexionBD();
        c.conectar();
    }
    
}
