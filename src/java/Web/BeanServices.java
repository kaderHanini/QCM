/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import DAO.EnseignantFacadeLocal;
import DAO.EtudiantFacadeLocal;
import DAO.ExamenEtudiantFacade;
import DAO.ExamenEtudiantFacadeLocal;
import DAO.ExamenFacadeLocal;
import DAO.ParametrageQcmFacade;
import DAO.ParametrageQcmFacadeLocal;
import DAO.PersonneFacadeLocal;
import DAO.QuestionExamenFacadeLocal;
import DAO.QuestionFacade;
import DAO.QuestionFacadeLocal;
import DAO.ReponseFacade;
import DAO.ReponseFacadeLocal;
import Entities.*;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kader
 */
@ManagedBean
@ApplicationScoped
//ou RequestScoped
public class BeanServices {

    /**
     * Creates a new instance of BeanServices
     */
    
    
    @EJB
    private QuestionFacadeLocal DAOQuestion;
    
     @EJB
    private PersonneFacadeLocal DAOPersonne;
    
    @EJB
    private ParametrageQcmFacadeLocal DAOParametrage;
    
    @EJB
    private ReponseFacadeLocal DAOReponse;
    
    @EJB
    private ExamenFacadeLocal DAOExamen;
    
    @EJB
    private EnseignantFacadeLocal DAOEnseignant;
    
    @EJB
    private ExamenEtudiantFacadeLocal DAOExaEtu;
   
   
    @EJB
    private EtudiantFacadeLocal DAOEtudiant;
    
    
    @EJB
    private QuestionExamenFacadeLocal DAOQuestionExamen;

    public QuestionExamenFacadeLocal getDAOQuestionExamen() {
        return DAOQuestionExamen;
    }

    public void setDAOQuestionExamen(QuestionExamenFacadeLocal DAOQuestionExamen) {
        this.DAOQuestionExamen = DAOQuestionExamen;
    }
    
       public EnseignantFacadeLocal getDAOEnseignant() {
        return DAOEnseignant;
    }

    public void setDAOEnseignant(EnseignantFacadeLocal DAOEnseignant) {
        this.DAOEnseignant = DAOEnseignant;
    }
    
    
    private Question question = new Question();
    private Reponse reponse = new Reponse();
    private ParametrageQcm parametrage = new ParametrageQcm();
    private Examen  examen = new Examen();
    private List<Question> ListQuestions;
    private List<Reponse> ListReponse;
     private int nbrQuestionAjouter;
     private ExamenEtudiant ExaEtu = new ExamenEtudiant();
   
     
      private List<Question> ListQuestionsExamen;

    public List<Question> getListQuestionsExamen() {
        return ListQuestionsExamen;
    }

    public void setListQuestionsExamen(List<Question> ListQuestionsExamen) {
        this.ListQuestionsExamen = ListQuestionsExamen;
    }
     
     
    public int getNbrQuestionAjouter() {
        return nbrQuestionAjouter;
    }

    public void setNbrQuestionAjouter(int nbrQuestionAjouter) {
        this.nbrQuestionAjouter = nbrQuestionAjouter;
    }
    private Question selectedQuestion;

    public Question getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(Question selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }
    
    public List<Question> getListQuestions() {
        return ListQuestions;
    }

    public void setListQuestions(List<Question> ListQuestions) {
        this.ListQuestions = ListQuestions;
    }
    //<editor-fold defaultstate="collapsed" desc="comment">
    private Enseignant  enseignant = new Enseignant();
    //</editor-fold>
    private Etudiant etudiant = new Etudiant();

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
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
    
    
    
      public String ajouterParametrageExamen()
    {
      
     //Ajouter DAOEnseignant 
        
        DAOParametrage.create(parametrage);
        examen.setParametrage(parametrage);
        DAOExamen.create(examen);
        listeQuestion(question.getTheme(),"vrai");
    
    return "ChoixQuestion";
    
     }
      
      
        public void ajouterEtudiant()
    {
     
              
                DAOEtudiant.create(etudiant);
      
     }
    
    
    
    public void ajouterEnseignant()
    {
        
       DAOEnseignant.create(enseignant);
           
       
    }
    
    
    
   public List<Question> listeQuestion(String theme,String typeQuestion)
   {
       

      nbrQuestion = getParametrage().getNbrQuestion();
         
      ListQuestions =  DAOQuestion.ListeQuestions(theme,nbrQuestion,typeQuestion);
     
       return ListQuestions;
  }
    
 
   
     public List<Reponse> listeReponses(Long idQuestion)
   {
      
       Question qes= DAOQuestion.find(idQuestion);
       ListReponse =  DAOReponse.RechercheReponse(qes);
      
       return ListReponse;
      
  }
      
     public void  ajouterQuestionExamen()
     {
           
         
      QuestionExamen questionExamen = new QuestionExamen();
         
      questionExamen.setQuestion(selectedQuestion);
      Examen e = DAOExamen.find(examen.getId());
      questionExamen.setExamen(e);
  
      
      nbrQuestionAjouter+=1;
     
      DAOQuestionExamen.create(questionExamen);
  
      
       ListQuestions.remove(selectedQuestion);
     
       
     }
     
     
     public void  SupprimerQuestionExamen()
     {
        // System.out.println(");
         
         List<Question> list; 
         
         list =  DAOQuestion.ListeQuestions(question.getTheme(),1,""); 
         
        for (Question q : list)
        {
        ListQuestions.add(q);
        }
         
        ListQuestions.remove(selectedQuestion);
     }
     
     

  
     
     
     public String AfficherQuestionExamen()
     {
         
        ListQuestionsExamen = DAOQuestion.ListeQuestionsExamen(examen);
        
        return "AfficherExamen";
         
     }
     
     
     public void AffecterExamen()
     {
         
         List<Etudiant> listE; 
        
         listE=   DAOEtudiant.ListeEtudiants(etudiant.getNiveau(), etudiant.getSpecialite());
     
           for (Etudiant e : listE )
           {
          
            ExaEtu.setExamen(getExamen());
            ExaEtu.setEtudiant(e);
            
            DAOExaEtu.create(ExaEtu);
               
           }
           
     }
     
     
     
     
     
     
     
     
     
    public void preRenderView() {  
      HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true ); 
    }
}
