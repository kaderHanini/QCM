/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etudiant;
import Entities.Examen;
import Entities.ExamenEtudiant;
import Entities.Personne;
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
public class ExamenEtudiantFacade extends AbstractFacade<ExamenEtudiant> implements ExamenEtudiantFacadeLocal {
    @PersistenceContext(unitName = "GenerateurQcmProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamenEtudiantFacade() {
        super(ExamenEtudiant.class);
    }
    
    
    
    
      
    
}
