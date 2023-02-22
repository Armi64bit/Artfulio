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
        Role r1 = new Role(1, "admin");
        RoleService role_service1 = new RoleService();
        role_service1.ajouter(r1);
        role_service1.recuperer();
        Role r2 = new Role(2, "artiste");
        RoleService role_service2 = new RoleService();
        role_service2.ajouter(r2);
        role_service2.recuperer();
        Role r3 = new Role(3, "client");
        RoleService role_service3 = new RoleService();
        role_service3.ajouter(r3);
        role_service3.recuperer();
        User u1 = new User(1, "hamza", "07563654", "ariana", "hamzahamza", "hamza@esprit.tn", "client");
        UserService user_service1 = new UserService();
        user_service1.ajouter(u1);
        user_service1.supprimer(u1);

        User u2 = new User(2, "imen", "07230574", "mourouj", "imenimen", "imen@esprit.tn", "admin");
        UserService user_service2 = new UserService();
        user_service2.ajouter(u2);
        user_service2.modifier(u2);
        user_service2.recuperer();

    }

}
