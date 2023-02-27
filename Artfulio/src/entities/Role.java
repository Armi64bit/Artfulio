/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author WINDOWS 10
 */
public class Role {

    private int id_role;
    public String type_role;

    public Role() {
    }

    public Role( String type_role) {
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Role other = (Role) obj;
        if (!Objects.equals(this.type_role, other.type_role)) {
            return false;
        }
        return true;
    }

}
