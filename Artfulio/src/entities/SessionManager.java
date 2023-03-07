/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author WINDOWS 10
 */
public final class SessionManager {
    private static SessionManager instance;
 
     private static int id_user;
    private static String cin_user;
    private static String username;
    private static String img_user;
     private static int is_pro;
    private static String email_user;
    private static String adresse_user;
    private static String type_role;

    //private String password_user;
   

   
  //SessionManager.getInstace(rs.getInt("id"),rs.getInt("cin"),rs.getString("user_name"),rs.getInt("numero"),rs.getString("email"),rs.getString("adresse"),rs.getString("roles"));
    private SessionManager(int id , String cin , String user_name , String img_user , String email ,String address,String role ,int is_pro) {
    SessionManager.id_user=id;
    SessionManager.cin_user=cin;
    SessionManager.username=user_name;
    SessionManager.img_user=img_user;
    SessionManager.email_user=email;
    SessionManager.adresse_user=address;
    SessionManager.type_role=role;
    SessionManager.is_pro=is_pro;
    
    }
 
    /**
    *
    * @param username
    * @param cin_user
    * //@param privileges
    * @return
    */
    public static SessionManager getInstace(int id , String cin , String user_name , String img_user , String email ,String address,String role,int is_pro) {
        if(instance == null) {
            instance = new SessionManager( id , cin ,  user_name ,   img_user ,  email ,address, role,is_pro);
        }
        return instance;
    }

    public static SessionManager getInstance() {
        return instance;
    }

    public static void setInstance(SessionManager instance) {
        SessionManager.instance = instance;
    }

    public static int getId() {
        return id_user;
    }

    public static void setId(int id) {
        SessionManager.id_user = id;
    }

    public static String getCIN() {
        return cin_user;
    }

    public static void setCIN(String CIN) {
        SessionManager.cin_user = CIN;
    }

    public static String getUserName() {
        return username;
    }

    public static void setUserName(String UserName) {
        SessionManager.username = UserName;
    }

    public static String  getNumero() {
        return  img_user;
    }

    public static void setNumero(String img_user) {
        SessionManager.img_user = img_user;
    }

    public static String getEmail() {
        return email_user;
    }

    public static void setEmail(String Email) {
        SessionManager.email_user = Email;
    }

    public static String getAdresse() {
        return adresse_user;
    }

    public static void setAdresse(String Adresse) {
        SessionManager.adresse_user = Adresse;
    }

    public static String getRoles() {
        return type_role;
    }

    public static int getIs_pro() {
        return is_pro;
    }

    public static void setIs_pro(int is_pro) {
        SessionManager.is_pro = is_pro;
    }

    public static void setRoles(String roles) {
        SessionManager.type_role = roles;
    }

   
    
    public static void cleanUserSession() {
    id_user=0;
    cin_user="";
     username="";
     img_user="";
     email_user="";
     adresse_user="";
     type_role="";
      is_pro=0;
    }
 
    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + username + '\'' +
                "email='" + email_user + '\'' +
                "img_user='" + img_user + '\'' +
               
                "id = '" + id_user + '\'' +
           
                ", privileges=" + type_role +
                
            '}';
    }
 
    
    static class cleanUserSession {
 
        public cleanUserSession() {
         id_user=0;
    cin_user="";
     username="";
     img_user="";
     email_user="";
     adresse_user="";
     type_role="";
     is_pro=0;
        }
    }
}
    

