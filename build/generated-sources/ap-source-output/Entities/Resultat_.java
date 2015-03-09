package Entities;

import Entities.Etudiant;
import Entities.Examen;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-09T15:29:55")
@StaticMetamodel(Resultat.class)
public class Resultat_ { 

    public static volatile SingularAttribute<Resultat, Long> id;
    public static volatile SingularAttribute<Resultat, Etudiant> etudiant;
    public static volatile SingularAttribute<Resultat, Examen> examen;
    public static volatile SingularAttribute<Resultat, Float> score;

}