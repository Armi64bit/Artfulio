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
public class Role {

    private int id_role;
    public String type_role;

    public Role() {
    }

    public Role(int id_role, String type_role) {
        this.id_role = id_role;
        this.type_role = type_role;
    }

    public int getId_role() {
        return id_role;
    }

    public String getType_role() {
        return type_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public void setType_role(String type_role) {
        this.type_role = type_role;
    }

    @Override
    public String toString() {
        return "Role{" + "id_role=" + id_role + ", type_role=" + type_role + '}';
    }

}
