/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class MyConnection {
      String url="jdbc:mysql://localhost:3306/projetpi";
      String login="root";
      String password="";
      Connection myconnex;
static MyConnection moncnx;
    public MyConnection() {
        try{
        myconnex= DriverManager.getConnection(url,login,password);
       System.out.println("reussi!!");
            
        }
        catch(SQLException ex){
                 System.out.println(ex.getMessage());
                    }
    }
    public static MyConnection getInstance(){
    if(moncnx==null)
       moncnx= new MyConnection();
    return moncnx;
    }   
    public Connection getConnection(){
        return myconnex;
    }
  
}
