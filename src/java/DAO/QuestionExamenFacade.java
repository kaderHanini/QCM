/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.QuestionExamen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kader
 */
@Stateless
public class QuestionExamenFacade extends AbstractFacade<QuestionExamen> implements QuestionExamenFacadeLocal {
    @PersistenceContext(unitName = "GenerateurQcmProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionExamenFacade() {
        super(QuestionExamen.class);
    }
    
}
