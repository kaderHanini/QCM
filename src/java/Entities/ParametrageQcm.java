/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kader
 */
@Entity
public class ParametrageQcm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrageQcm)) {
            return false;
        }
        ParametrageQcm other = (ParametrageQcm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ParametrageQcm[ id=" + id + " ]";
    }
    
    
    private int duree;
    private int nbrQuestion;
    private Boolean cacl;
    private int ptsReponseCorrecte;
    private int ptsReponseIncorrecte;
    private int ptsAbsenceReponse;
    private String nomModele;

    public Boolean getCacl() {
        return cacl;
    }

    public void setCacl(Boolean cacl) {
        this.cacl = cacl;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNbrQuestion() {
        return nbrQuestion;
    }

    public void setNbrQuestion(int nbrQuestion) {
        this.nbrQuestion = nbrQuestion;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public int getPtsAbsenceReponse() {
        return ptsAbsenceReponse;
    }

    public void setPtsAbsenceReponse(int ptsAbsenceReponse) {
        this.ptsAbsenceReponse = ptsAbsenceReponse;
    }

    public int getPtsReponseCorrecte() {
        return ptsReponseCorrecte;
    }

    public void setPtsReponseCorrecte(int ptsReponseCorrecte) {
        this.ptsReponseCorrecte = ptsReponseCorrecte;
    }

    public int getPtsReponseIncorrecte() {
        return ptsReponseIncorrecte;
    }

    public void setPtsReponseIncorrecte(int ptsReponseIncorrecte) {
        this.ptsReponseIncorrecte = ptsReponseIncorrecte;
    }


    
    
    

    
    
    
}
