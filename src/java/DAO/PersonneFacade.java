/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Personne;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kader
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {
    @PersistenceContext(unitName = "GenerateurQcmProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
    
    @Override
    public Personne RecherchePersonne(String Login, String Pswd)
    
    
    
    {
        Personne p;
    
       
    Query q =  getEntityManager().createQuery("Select p from Personne p where p.login=:login and p.pswd=:pswd");
    q.setParameter("login",Login);
    q.setParameter("pswd", Pswd);
    
    
    try
    {
    p =(Personne)q.getSingleResult();
      return p;
    }
    catch(Exception e )
    {
   
      return null;
    }   
 
    }
    
}
