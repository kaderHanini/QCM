package Entities;

import Entities.Question;
import Entities.Resultat;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-09T15:29:55")
@StaticMetamodel(ReponseEtudiant.class)
public class ReponseEtudiant_ { 

    public static volatile SingularAttribute<ReponseEtudiant, Long> id;
    public static volatile SingularAttribute<ReponseEtudiant, String> reponse;
    public static volatile SingularAttribute<ReponseEtudiant, Question> question;
    public static volatile SingularAttribute<ReponseEtudiant, Resultat> resultat;

}