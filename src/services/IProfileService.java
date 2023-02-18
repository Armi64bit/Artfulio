/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entites.Profile;
import java.util.List;

/**
 *
 * @author msi
 */
public interface IProfileService {
  public int ajouterProfile(Profile p);
    public boolean modifierProfile(Profile p);
    public boolean supprimerProfile(Profile p);
    public List<Profile> afficherProfile();
   
}
