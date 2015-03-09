/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.ReponseEtudiant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface ReponseEtudiantFacadeLocal {

    void create(ReponseEtudiant reponseEtudiant);

    void edit(ReponseEtudiant reponseEtudiant);

    void remove(ReponseEtudiant reponseEtudiant);

    ReponseEtudiant find(Object id);

    List<ReponseEtudiant> findAll();

    List<ReponseEtudiant> findRange(int[] range);

    int count();
    
}
