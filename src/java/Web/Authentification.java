/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import DAO.PersonneFacadeLocal;
import Entities.Enseignant;
import Entities.Etudiant;
import Entities.Personne;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.component.messages.Messages;

/**
 *
 * @author kader
 */
@ManagedBean
@SessionScoped
public class Authentification {

    /**
     * Creates a new instance of Authentification
     */
    
    
    @EJB
    private PersonneFacadeLocal DAOPersonne;
 
    
    
  
     private String pswd;
     private String login;
     private Etudiant etudiant = new Etudiant();
     private Enseignant  enseignant = new Enseignant();
    
     public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
    
    
    
    
    
    
     public String Authentification()
       
    {
        Personne p = DAOPersonne.RecherchePersonne(login, pswd);
        
        if (p instanceof Etudiant )
        {
            this.etudiant = (Etudiant) p;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("etudiant", p);
            return "ExamensEtudiant";
         
        }       
       
        if(p instanceof Enseignant)
        {
            this.enseignant = (Enseignant) p;
            return "GenererQcm";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nom d'utilisateur ou mot de passe incorrrecte!", "Contact admin."));
        return    null;
        }
    }

     
     
     
         
    public String Deconnexion()
       
    {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.invalidateSession();
   
        return   "Authentification";
        
    }

    
    

    
    
    
    

}
