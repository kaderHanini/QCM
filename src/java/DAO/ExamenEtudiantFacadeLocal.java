/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.ExamenEtudiant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface ExamenEtudiantFacadeLocal {

    void create(ExamenEtudiant examenEtudiant);

    void edit(ExamenEtudiant examenEtudiant);

    void remove(ExamenEtudiant examenEtudiant);

    ExamenEtudiant find(Object id);

    List<ExamenEtudiant> findAll();

    List<ExamenEtudiant> findRange(int[] range);

    int count();
    
}
