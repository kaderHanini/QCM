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
        
        
    
       
    Query q =  getEntityManager().createQuery("Select p from ExamenEtudiant p where p.etudiant=:e");
    q.setParameter("e",e);
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
