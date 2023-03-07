/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author WINDOWS 10
 */
public class MyConnection {
     Connection myconnex ;
     static MyConnection macon;
     
     String url="jdbc:mysql://localhost:3306/artfulio";
    String login="root";
    String password="";

    public MyConnection() {
        
  try {
            myconnex = DriverManager.getConnection(url, login, password);
            System.out.println("connexion reussite");
        } catch (SQLException ex) {
            System.out.println("connexion non reussite");
        }
    }
    
    public Connection getConnection(){
        return myconnex;
    }
    
    public static  MyConnection getInstance(){
        if(macon == null){
           macon= new MyConnection();
        }
        return macon;
    }
    
}
