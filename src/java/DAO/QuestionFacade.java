/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Examen;
import Entities.Question;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kader
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> implements QuestionFacadeLocal {
    @PersistenceContext(unitName = "GenerateurQcmProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }

    
    
    
    @Override
    public List<Question> ListeQuestions(String theme, int nbrQuestion, String typeQuestion) {
   
        
        
               List<Question> listeQuestion ;
       
       
         Query r = getEntityManager().createQuery("select q from Question as q where q.theme=:theme");
          r.setParameter("theme", theme);
          r.setMaxResults(nbrQuestion);
         listeQuestion =  r.getResultList();
         
         System.out.println("nnnnnnnnnnnnnbr"+ nbrQuestion);
        
         return  listeQuestion;
       
       
        
        
    }
    
    
    
    
        @Override
    public List<Question> ListeQuestionsExamen(Examen ex) {
   
        
        
       List<Question> listeQuestion ;
       
           // System.out.println("select * from Question q where q.id in (select select r.Question_id  from QuestionExamen r where r.EXAMEN_ID="+ex.getId()+")");
       Query r = em.createNativeQuery("select * from Question q where q.id in (select r.Question_id from QuestionExamen r where r.EXAMEN_ID="+ex.getId()+")",Question.class);
       
      
       listeQuestion = (List<Question>)r.getResultList();
       
      
      //   System.out.println("Facade output"+ listeQuestion.size());
        
         return  listeQuestion;
       
       
        
        
    }
    
    
    
    
    
    
    
    
    
}
