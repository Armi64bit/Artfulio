/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.entites;

import java.util.Objects;

/**
 *
 * @author WINDOWS 10
 */
public class User {

    private int id_user;
    private int is_pro;
    private String username;
    private String cin_user;
    private String adresse_user;
    private String password_user;
    private String email_user;
    private String img_user;
    private String type_role;
public static User Current_User;
    public User() {
    }

    public User(int id_user, String username, String cin_user, String adresse_user, String password_user, String email_user, String type_role) {
        this.id_user = id_user;
        this.username = username;
        this.cin_user = cin_user;
        this.adresse_user = adresse_user;
        this.password_user = password_user;
        this.email_user = email_user;
        this.type_role = type_role;
    }

    public User(String username, String cin_user, String adresse_user, String password_user, String email_user, String img_user, String type_role) {
        this.username = username;
        this.cin_user = cin_user;
        this.adresse_user = adresse_user;
        this.password_user = password_user;
        this.email_user = email_user;
        this.img_user = img_user;
        this.type_role = type_role;
    }

    public User(int is_pro, String username, String cin_user, String adresse_user, String password_user, String email_user, String img_user, String type_role) {
        this.is_pro = is_pro;
        this.username = username;
        this.cin_user = cin_user;
        this.adresse_user = adresse_user;
        this.password_user = password_user;
        this.email_user = email_user;
        this.img_user = img_user;
        this.type_role = type_role;
    }

    public User(int id_user, int is_pro, String username, String cin_user, String adresse_user, String password_user, String email_user, String img_user, String type_role) {
        this.id_user = id_user;
        this.is_pro = is_pro;
        this.username = username;
        this.cin_user = cin_user;
        this.adresse_user = adresse_user;
        this.password_user = password_user;
        this.email_user = email_user;
        this.img_user = img_user;
        this.type_role = type_role;
    }

    public User(int id_user, String username, String img_user) {
        this.id_user = id_user;
        this.username = username;
        this.img_user = img_user;
    }

    public User(String username, String img_user) {
        this.username = username;
        this.img_user = img_user;
    }

    public String getType_role() {
        return type_role;
    }

    public void setType_role(String type_role) {
        this.type_role = type_role;
    }

    public static User getCurrent_User() {
        return Current_User;
    }

    public static void setCurrent_User(User Current_User) {
        User.Current_User = Current_User;
    }
    

    public int getIs_pro() {
        return is_pro;
    }

    public void setIs_pro(int is_pro) {
        this.is_pro = is_pro;
    }
    

    public String getImg_user() {
        return img_user;
    }

    public void setImg_user(String img_user) {
        this.img_user = img_user;
    }

  

    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getCin_user() {
        return cin_user;
    }

    public String getAdresse_user() {
        return adresse_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public String getEmail_user() {
        return email_user;
    }

   
    public String getRole() {
        return type_role;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCin_user(String cin_user) {
        this.cin_user = cin_user;
    }

    public void setAdresse_user(String adresse_user) {
        this.adresse_user = adresse_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

  
    public void setRole(String role) {
        this.type_role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", is_pro=" + is_pro + ", username=" + username + ", cin_user=" + cin_user + ", adresse_user=" + adresse_user + ", password_user=" + password_user + ", email_user=" + email_user + ", img_user=" + img_user + ", type_role=" + type_role + '}';
    }

    
  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.cin_user, other.cin_user);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cin_user);
        return hash;
    }

}
