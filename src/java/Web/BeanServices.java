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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.component.panel.Panel;

/**
 *
 * @author kader
 */
@ManagedBean
@SessionScoped
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

    public ExamenEtudiantFacadeLocal getDAOExaEtu() {
        return DAOExaEtu;
    }

    public void setDAOExaEtu(ExamenEtudiantFacadeLocal DAOExaEtu) {
        this.DAOExaEtu = DAOExaEtu;
    }
   
   
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
    
    
    private Question question1 = new Question();

    public Question getQuestion1() {
        return question1;
    }

    public void setQuestion1(Question question1) {
        this.question1 = question1;
    }
    private Reponse reponse = new Reponse();
    private ParametrageQcm parametrage = new ParametrageQcm();
    private Examen  examen = new Examen();
    private List<Question> ListQuestions;
    private List<Reponse> ListReponse;
     private int nbrQuestionAjouter;
     private ServiceEtudiant ExaEtu = new ServiceEtudiant();
   private Etudiant etudiant = new Etudiant();
  
     
   

   
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
        this.question1 = question;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

 

    public Question getQuestion() {
        return question1;
    }

    public Reponse getReponse() {
        return reponse;
    }
    
   
    
    public String ajouterQuestion()
    {
     DAOQuestion.create(question1);
     return "AjouterReponse";
    }  
    
   
    public void ajouterReponse()
    {
      reponse.setQuestion(question1);
      DAOReponse.create(reponse);
        
    }
    
    
    
      public String ajouterParametrageExamen()
    {
      
     //Ajouter DAOEnseignant 
         Enseignant e = (Enseignant) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("enseignant");
        
        
        DAOParametrage.create(parametrage);
        examen.setParametrage(parametrage);
        examen.setEnseignant(e);
        DAOExamen.create(examen);
        listeQuestion(question1.getTheme(),"vrai");
    
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
       
       
       
      System.out.println(theme);

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
         
         list =  DAOQuestion.ListeQuestions(question1.getTheme(),1,""); 
         
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
     
         
            System.out.println("size List :"+ listE);
           
            for (Etudiant e : listE )
           {
               
              ExamenEtudiant ex = new ExamenEtudiant();
               
              ex.setEtudiant(e);
              ex.setExamen(examen);
              DAOExaEtu.create(ex);
               
           }
           
     }
     
     
    
     
     
     
     
     
     
     
     
    public void preRenderView() {  
      HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession(true); 
    }
    
    
   
    
    
    
    
}
