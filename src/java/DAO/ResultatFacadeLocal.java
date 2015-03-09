/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Resultat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface ResultatFacadeLocal {

    void create(Resultat resultat);

    void edit(Resultat resultat);

    void remove(Resultat resultat);

    Resultat find(Object id);

    List<Resultat> findAll();

    List<Resultat> findRange(int[] range);

    int count();
    
}
