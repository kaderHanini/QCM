/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import DAO.ExamenEtudiantFacadeLocal;
import DAO.ExamenFacadeLocal;
import Entities.Etudiant;
import Entities.Examen;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kader
 */
@ManagedBean
@RequestScoped
public class ServiceEtudiant {


  
   @EJB
  private ExamenFacadeLocal DaoExamEtu;

   
  private  List<Examen> ListeExamens;

    public List<Examen> getListeExamens() {
        return ListeExamens;
    }

    public void setListeExamens(List<Examen> ListeExamens) {
        this.ListeExamens = ListeExamens;
    }
  
    
    public void ExamenEtudiant()
    {
        
        Etudiant e = (Etudiant) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("etudiant");
        
        
        List<Examen> listExam =  DaoExamEtu.RechercheExamensEtudiant(e);
        
        
        if  (listExam != null)
        {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vous avez des Examen a Passer .", "Contact admin."));
            this.ListeExamens = listExam;
            System.out.println(ListeExamens.size());
            
        }
        else
        {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vous n'avez pas des Examen a Passer .", "Contact admin."));
        }
        
    
    }
    
   








}
