/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Examen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface ExamenFacadeLocal {

    void create(Examen examen);

    void edit(Examen examen);

    void remove(Examen examen);

    Examen find(Object id);

    List<Examen> findAll();

    List<Examen> findRange(int[] range);

    int count();
    
}
