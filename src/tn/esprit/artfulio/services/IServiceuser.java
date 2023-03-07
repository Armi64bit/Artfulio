package tn.esprit.artfulio.services;

import java.util.List;
import tn.esprit.artfulio.entites.User;

/**
 *
 * @author msi
 */
public interface IServiceuser {
    
    public int ajouteruser(User p);
    public boolean modifieruser(User p);
    public boolean supprimeruser(User p);
    public List<User> afficheruser();
    
    
}
