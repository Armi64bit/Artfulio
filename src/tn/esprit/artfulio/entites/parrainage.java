/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.entites;

/**
 *
 * @author 21652
 */
public class parrainage {
    
    private int id_parrainage, is_pro;
    private String username, email, type_role;

    public parrainage(int is_pro, String username, String email, String type_role) {
        this.is_pro = is_pro;
        this.username = username;
        this.email = email;
        this.type_role = type_role;
    }

    public parrainage(int id_parrainage) {
        this.id_parrainage = id_parrainage;
    }

    public parrainage(int id_parrainage, String username) {
        this.id_parrainage = id_parrainage;
        this.username = username;
    }

    
    
    public parrainage() {
    }
    

    public parrainage(int id_parrainage, int is_pro, String username, String email, String type_role) {
        this.id_parrainage = id_parrainage;
        this.is_pro = is_pro;
        this.username = username;
        this.email = email;
        this.type_role=type_role;
        
    }

    public String getType_role() {
        return type_role;
    }

    public void setType_role(String type_role) {
        this.type_role = type_role;
    }

    public int getId_parrainage() {
        return id_parrainage;
    }

    public void setId_parrainage(int id_parrainage) {
        this.id_parrainage = id_parrainage;
    }

    public int getIs_pro() {
        return is_pro;
    }

    public void setIs_pro(int is_pro) {
        this.is_pro = is_pro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
