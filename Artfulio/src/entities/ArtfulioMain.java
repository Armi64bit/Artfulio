/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.SQLException;
import services.RoleService;
import services.UserService;

/**
 *
 * @author WINDOWS 10
 */
public class ArtfulioMain {

    public static void main(String[] args) throws SQLException {
       /* Role r1 = new Role("admin");
        RoleService role_service1 = new RoleService();
        role_service1.ajouterRole(r1);
        Role r2 = new Role("artiste");
        RoleService role_service2 = new RoleService();
        role_service2.ajouterRole(r2); 
        Role r3 = new Role("client"); */
        RoleService role_service3 = new RoleService();
        //role_service3.ajouterRole(r3);
        role_service3.afficherRole();
       /* User u1 = new User("imen", "07895648", "mourouj", "0000", "imen.abassi@esprit.tn", "admin", false,"C:\\Users\\WINDOWS 10\\Documents\\GitHub\\Artfulio\\Artfulio\\src\\img\\imen.jpg");
        UserService user_service1 = new UserService();
        user_service1.ajouterUtilisateur(u1);
        user_service1.afficherUtilisateur();*/

     

    }

}
