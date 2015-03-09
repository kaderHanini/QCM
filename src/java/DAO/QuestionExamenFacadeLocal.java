/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.QuestionExamen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface QuestionExamenFacadeLocal {

    void create(QuestionExamen questionExamen);

    void edit(QuestionExamen questionExamen);

    void remove(QuestionExamen questionExamen);

    QuestionExamen find(Object id);

    List<QuestionExamen> findAll();

    List<QuestionExamen> findRange(int[] range);

    int count();
    
}
