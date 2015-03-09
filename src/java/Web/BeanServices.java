/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import DAO.EnseignantFacadeLocal;
import DAO.QuestionFacade;
import DAO.QuestionFacadeLocal;
import DAO.ReponseFacade;
import DAO.ReponseFacadeLocal;
import Entities.Enseignant;
import Entities.Question;
import Entities.Reponse;
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
    private ReponseFacadeLocal DAOReponse;
    @EJB
    private EnseignantFacadeLocal DAOEnseignant;

    
    
    
    public QuestionFacadeLocal getDAOQuestion() {
        return DAOQuestion;
    }

    public void setDAOQuestion(QuestionFacadeLocal DAOQuestion) {
        this.DAOQuestion = DAOQuestion;
    }

    public ReponseFacadeLocal getDAOReponse() {
        return DAOReponse;
    }

    public void setDAOReponse(ReponseFacadeLocal DAOReponse) {
        this.DAOReponse = DAOReponse;
    }
   
    
    public EnseignantFacadeLocal getDAOEnseignant() {
        return DAOEnseignant;
    }
    
    public void setDAOEnseignant(EnseignantFacadeLocal DAOEnseignant) {
        this.DAOEnseignant = DAOEnseignant;
    }

    
    
    private Question question = new Question();
    private Reponse reponse = new Reponse();
    private Enseignant enseignant = new Enseignant();

    
    

    public void setDAOQuestion(QuestionFacade DAOQuestion) {
        this.DAOQuestion = DAOQuestion;
    }

    public void setDAOReponse(ReponseFacade DAOReponse) {
        this.DAOReponse = DAOReponse;
    }
    
    
    
    public Question getQuestion() {
        return question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    
    public Reponse getReponse() {
        return reponse;
    }
    
    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }
    
    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
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
    
    public void ajouterEnseignant()
    { 
       
       DAOEnseignant.create(enseignant);
    }
    
  
    
    public BeanServices() {
        
      
        
    }
}
