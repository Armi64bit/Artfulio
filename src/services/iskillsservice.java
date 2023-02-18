package services;

import entites.skills;
import java.util.List;

/**
 *
 * @author msi
 */
public interface iskillsservice {
    public int ajouterskills(skills s);
    public boolean modifierskills(skills s);
    public boolean supprimerskills(skills s);
    public List<skills> afficherskills();
}
