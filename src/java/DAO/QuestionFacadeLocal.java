/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Question;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface QuestionFacadeLocal {

    void create(Question question);

    void edit(Question question);

    void remove(Question question);

    Question find(Object id);

    List<Question> findAll();

    List<Question> findRange(int[] range);

    int count();
    
}
