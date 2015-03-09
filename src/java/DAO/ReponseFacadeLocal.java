/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Reponse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface ReponseFacadeLocal {

    void create(Reponse reponse);

    void edit(Reponse reponse);

    void remove(Reponse reponse);

    Reponse find(Object id);

    List<Reponse> findAll();

    List<Reponse> findRange(int[] range);

    int count();
    
}
