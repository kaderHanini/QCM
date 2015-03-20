/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etudiant;
import Entities.Examen;
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
public class ExamenFacade extends AbstractFacade<Examen> implements ExamenFacadeLocal {
    @PersistenceContext(unitName = "GenerateurQcmProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamenFacade() {
        super(Examen.class);
    }
    
    
    @Override
    public  List<Examen> RechercheExamensEtudiant(Etudiant e)
     {
        List<Examen> ListExam;
        
        
           Query q = em.createNativeQuery("select * from Examen q where q.id in (select r.EXAMEN_ID from EXAMENETUDIANT r where r.ETUDIANT_ID="+e.getId()+")",Examen.class);
        // System.out.println("select * from Examen q where q.ID in (select r.EXAMEN_ID from EXAMENETUDIANT r where r.ETUDIANT_ID="+e.getId()+")");
  
   try
    {
    ListExam =q.getResultList();
      return ListExam;
    }
    catch(Exception exp )
    {
        System.out.println(exp.getMessage());
        return null;
    }   
 
    }
    
    
    
}
