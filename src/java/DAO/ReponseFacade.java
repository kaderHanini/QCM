/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Question;
import Entities.Reponse;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kader
 */
@Stateless
@LocalBean
public class ReponseFacade extends AbstractFacade<Reponse> implements ReponseFacadeLocal {
    @PersistenceContext(unitName = "GenerateurQcmProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReponseFacade() {
        super(Reponse.class);
    }

    @Override
    public List<Reponse> RechercheReponse(Question question) {
        
               List<Reponse> listReponses ;
       
      
         Query r = getEntityManager().createQuery("select r from Reponse as r where r.question=:id");
       r.setParameter("id", question);
         listReponses =  r.getResultList();
         System.out.println("s:"+listReponses.size());
      
         return  listReponses;
    }
    
}
