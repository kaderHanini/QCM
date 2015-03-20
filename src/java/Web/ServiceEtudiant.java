/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import DAO.ExamenEtudiantFacadeLocal;
import DAO.ExamenFacadeLocal;
import DAO.QuestionFacadeLocal;
import DAO.ReponseEtudiantFacadeLocal;
import DAO.ReponseFacadeLocal;
import DAO.ResultatFacadeLocal;
import Entities.Etudiant;
import Entities.Examen;
import Entities.ExamenEtudiant;
import Entities.Question;
import Entities.Reponse;
import Entities.ReponseEtudiant;
import Entities.Resultat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.panel.Panel;

/**
 *
 * @author kader
 */
@ManagedBean
@SessionScoped
public class ServiceEtudiant {

    @EJB
    private ExamenFacadeLocal DaoExamen;

    @EJB
    private ExamenEtudiantFacadeLocal DaoExamenEtudiant;

    @EJB
    private ResultatFacadeLocal DaoResultat;

    @EJB
    private ReponseEtudiantFacadeLocal DaoReponseEtudiant;

    @EJB
    private QuestionFacadeLocal DaoQuestion;

    @EJB
    private ReponseFacadeLocal DaoReponse;
    
   

    private Panel PanelQestionExamen;
    private DataTable datatable;
    private Question question;
    private Reponse reponse = new Reponse();
    
    private Examen examen;
        private List<Examen> ListeExamens;

    private List<Question> ListQuestion;

    private List<Reponse> ListReponse;

    private String selectedReponse;

    private ReponseEtudiant reponseEtudiant;
    
    private List<Resultat> listResultat = new  ArrayList<Resultat>();

    public List<Resultat> getListResultat() {
        return listResultat;
    }

    public void setListResultat(List<Resultat> listResultat) {
        this.listResultat = listResultat;
    }
    

    public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public DataTable getDatatable() {
        return datatable;
    }

    public void setDatatable(DataTable datatable) {
        this.datatable = datatable;
    }

    public Panel getPanelQestionExamen() {
        return PanelQestionExamen;
    }

    public void setPanelQestionExamen(Panel PanelQestionExamen) {
        this.PanelQestionExamen = PanelQestionExamen;
    }



    public String getSelectedReponse() {
        return selectedReponse;
    }

    public void setSelectedReponse(String selectedReponse) {
        this.selectedReponse = selectedReponse;
    }

    public List<Question> getListQuestion() {
        return ListQuestion;
    }

    public void setListQuestion(List<Question> ListQuestion) {
        this.ListQuestion = ListQuestion;
    }

    public List<Examen> getListeExamens() {
        return ListeExamens;
    }

    public void setListeExamens(List<Examen> ListeExamens) {
        this.ListeExamens = ListeExamens;
    }


    public ReponseEtudiant getReponseEtudiant() {
        return reponseEtudiant;
    }

    public void setReponseEtudiant(ReponseEtudiant reponseEtudiant) {
        this.reponseEtudiant = reponseEtudiant;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public void ExamenEtudiant() {

        Etudiant e = (Etudiant) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("etudiant");

        List<Examen> listExam = DaoExamen.RechercheExamensEtudiant(e);

        if (listExam.size() > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vous avez des examens a passer .", "Contact admin."));
            this.ListeExamens = listExam;
            PanelQestionExamen.setVisible(true);
        }
        if (listExam.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vous n'avez pas des Examen a Passer .", "Contact admin."));
            // PanelQestionExamen.setVisible(true);
        }

    }

    public String PasserExamen() {

        Etudiant e = (Etudiant) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("etudiant");
        ListQuestion = DaoQuestion.ListeQuestionsExamen(examen);

        List<ExamenEtudiant> listEE = DaoExamenEtudiant.findAll();
        for (ExamenEtudiant ee : listEE) {

            if (ee.getExamen().equals(examen) && ee.getEtudiant().equals(e)) {
                DaoExamenEtudiant.remove(ee);
            }

        }

        return "PasserExamen";
    }

    public List<Reponse> listeReponses(Long idQuestion) {
        Question qes = DaoQuestion.find(idQuestion);
        ListReponse = DaoReponse.RechercheReponse(qes);
        return ListReponse;
    }

    public void EnregistrerReponse(Question q) {

        Etudiant e = (Etudiant) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("etudiant");
        reponse = DaoReponse.find(reponse.getId());
        reponseEtudiant = new ReponseEtudiant();
        reponseEtudiant.setReponse(reponse.getReponse());
        reponseEtudiant.setReponseJuste(reponse.getTypeReponse());
        reponseEtudiant.setEtudiant(e);
        reponseEtudiant.setExamen(examen);
        reponseEtudiant.setQuestion(q);

        List<ReponseEtudiant> listRep = DaoReponseEtudiant.findAll();

        for (ReponseEtudiant re : listRep) {
            if ((re.getQuestion().equals(q)) && (re.getExamen().equals(examen))) {
                DaoReponseEtudiant.remove(re);
            }
        }

        DaoReponseEtudiant.create(reponseEtudiant);

    }

    public void CalculerResultat() {

        Etudiant e = (Etudiant) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("etudiant");

        List<ReponseEtudiant> listRep = DaoReponseEtudiant.findAll();

        float sum = 0;
        int nbrPos = examen.getParametrage().getPtsReponseCorrecte();
        int nbrNeg = examen.getParametrage().getPtsReponseIncorrecte();
        int nbrAbs = examen.getParametrage().getPtsAbsenceReponse();
        int nbrQuestion = listRep.size();

        for (ReponseEtudiant re : listRep) {

            if ((re.getEtudiant().equals(e)) && (re.getExamen().equals(examen))) {

                System.out.println(re.getReponseJuste());

                if (re.getReponseJuste().equals("vrai")) {
                    sum = nbrPos + sum;
                    System.out.println("som" + sum);
                } else {
                    sum = sum + nbrNeg;
                    System.out.println("som" + sum);
                }

            }
        }

        float score = (sum * 20) / (nbrQuestion * nbrPos);

        Resultat res = new Resultat();
        res.setExamen(examen);
        res.setEtudiant(e);
        res.setScore(score);
        DaoResultat.create(res);

    }

    public List<Resultat> getConsulterNote() 
    {
        
        listResultat.clear();
        
        List<Resultat> Listresultat;
        
        Listresultat = DaoResultat.findAll();
        
         Etudiant e = (Etudiant) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("etudiant");
        
        for(Resultat r : Listresultat)
        {
        
            if(r.getEtudiant().equals(e))
            {
            listResultat.add(r);
            }
        
        
        }
        
           return  listResultat;
    }

   
}
