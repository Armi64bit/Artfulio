package services;

import entites.skills;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author msi
 */
public class skillsservice implements iskillsservice{
Connection myconnex
            = MyConnection.getInstance().getConnection();
    @Override
    public int ajouterskills(skills s) {
        
int id=-1;
        try {
           String req1 ="INSERT INTO `skills` (`id_skill`, `titre_skill`, `desc_skill`) VALUES (NULL, '"+s.getTitre_skill()+"', '"+s.getDesc_skill()+"');";
           
           Statement ste = myconnex.createStatement();
          id= ste.executeUpdate(req1);
       } catch (SQLException ex) {
           System.out.println(ex);
       }
       return id;    }

    @Override
    public boolean modifierskills(skills s) {
 try  {                 String titre_skill="salwa";
                        String desc_skill="salwa";
                       
String req = "UPDATE `skills` SET `titre_skill` = ?, `desc_skill` = ? WHERE `skills`.`titre_skill` = '"+s.getTitre_skill()+"';";
			 PreparedStatement ps = myconnex
                   .prepareStatement(req);
			ps.setString(1, titre_skill);
			ps.setString(2, desc_skill);
                        
			ps.executeUpdate();

			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			
                        }

return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
                   return false;    
		}
     }

    @Override
    public boolean supprimerskills(skills s) {
try {
           String req="delete from skills where id_skill= ? ";
           PreparedStatement ps = myconnex
                   .prepareStatement(req);
           ps.setInt(1, 1);
           ps.executeUpdate();
       return true;
       
       
       } catch (SQLException ex) {
           System.out.println(ex); return false;
       }    }

    @Override
    public List<skills> afficherskills() {
 List<skills> list = new ArrayList<>();
        try {
            String req = "select * from skills";
            Statement ste = myconnex.createStatement();
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                skills s = new skills();
                s.setTitre_skill(res.getString("titre_skill"));
                s.setDesc_skill(res.getString("desc_skill"));
                

                list.add(s);
            }
        } catch (SQLException ex) {
        }
        return list;    }
    
}
