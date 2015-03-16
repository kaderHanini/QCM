/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etudiant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface EtudiantFacadeLocal {

    void create(Etudiant etudiant);

    void edit(Etudiant etudiant);

    void remove(Etudiant etudiant);

    Etudiant find(Object id);

    List<Etudiant> findAll();

    List<Etudiant> findRange(int[] range);
     List<Etudiant> ListeEtudiants(String niveau, String specialite);
    int count();
    
}
