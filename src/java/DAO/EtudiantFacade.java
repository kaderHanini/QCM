/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etudiant;
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
public class EtudiantFacade extends AbstractFacade<Etudiant> implements EtudiantFacadeLocal {
    @PersistenceContext(unitName = "GenerateurQcmProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtudiantFacade() {
        super(Etudiant.class);
    }
    
    
    
       @Override
    public List<Etudiant> ListeEtudiants(String niveau, String specialite) {
   
        
        
               List<Etudiant> listeEtudiants ;
       
       
         Query r = getEntityManager().createQuery("select q from Etudiant as q where q.specialite=:specialite and q.niveau=:niveau");
          r.setParameter("specialite", specialite);
           r.setParameter("niveau", niveau);
         
         listeEtudiants=  r.getResultList();
         
        
        
         return  listeEtudiants;
       
       
        
        
    }
    
    
    
    
    
}
