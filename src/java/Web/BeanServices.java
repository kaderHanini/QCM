/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import DAO.EnseignantFacadeLocal;
import DAO.EtudiantFacadeLocal;
import DAO.ExamenFacadeLocal;
import DAO.ParametrageQcmFacade;
import DAO.QuestionFacade;
import DAO.QuestionFacadeLocal;
import DAO.ReponseFacade;
import DAO.ReponseFacadeLocal;
import Entities.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kader
 */
@ManagedBean
@RequestScoped
public class BeanServices {

    /**
     * Creates a new instance of BeanServices
     */
    
    
    @EJB
    private QuestionFacadeLocal DAOQuestion;
    
    @EJB
    private ParametrageQcmFacade DAOParametrage;
    
    @EJB
    private ReponseFacadeLocal DAOReponse;
    
    @EJB
    private ExamenFacadeLocal DAOExamen;
    
   @EJB
    private EnseignantFacadeLocal DAOEnseignant;
   
 
     @EJB
    private EtudiantFacadeLocal DAOEtudiant;
    
    
    
    private Question question = new Question();
    private Reponse reponse = new Reponse();
    private ParametrageQcm parametrage = new ParametrageQcm();
    private Examen  examen = new Examen();
    private Enseignant  enseignant = new Enseignant();
    private Etudiant etudian = new Etudiant();

    public Etudiant getEtudian() {
        return etudian;
    }

    public void setEtudian(Etudiant etudian) {
        this.etudian = etudian;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
    
    
    private int nbrQuestion ;

    public int getNbrQuestion() {
        return nbrQuestion;
    }

    public void setNbrQuestion(int nbrQuestion) {
        this.nbrQuestion = nbrQuestion;
    }
    
    
    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    
    

    public ParametrageQcm getParametrage() {
        return parametrage;
    }

    public void setParametrage(ParametrageQcm parametrage) {
        this.parametrage = parametrage;
    }
    
    
    
    

    public void setDAOQuestion(QuestionFacade DAOQuestion) {
        this.DAOQuestion = DAOQuestion;
    }

    public void setDAOReponse(ReponseFacade DAOReponse) {
        this.DAOReponse = DAOReponse;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

 

    public Question getQuestion() {
        return question;
    }

    public Reponse getReponse() {
        return reponse;
    }
    
   
    
    public String ajouterQuestion()
    {
     DAOQuestion.create(question);
     return "AjouterReponse";
    }  
    
   
    public void ajouterReponse()
    {
      reponse.setQuestion(question);
      DAOReponse.create(reponse);
        
    }
    
    
    
    
    public void ajouterParametrageExamen()
    {
     
        DAOParametrage.create(parametrage);
        DAOExamen.create(examen);
     }
    
    
    
    
}
