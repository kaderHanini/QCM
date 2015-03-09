/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Enseignant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface EnseignantFacadeLocal {

    void create(Enseignant enseignant);

    void edit(Enseignant enseignant);

    void remove(Enseignant enseignant);

    Enseignant find(Object id);

    List<Enseignant> findAll();

    List<Enseignant> findRange(int[] range);

    int count();
    
}
