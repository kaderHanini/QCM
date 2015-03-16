/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Examen;
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
    
   public List<Question> ListeQuestions(String theme, int nbrQuestion, String typeQuestion);
    
   public List<Question> ListeQuestionsExamen(Examen ex);
    

    List<Question> findRange(int[] range);

    int count();
    
}
