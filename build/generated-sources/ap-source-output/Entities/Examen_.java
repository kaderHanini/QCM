package Entities;

import Entities.Enseignant;
import Entities.Etudiant;
import Entities.ParametrageQcm;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-09T15:29:55")
@StaticMetamodel(Examen.class)
public class Examen_ { 

    public static volatile SingularAttribute<Examen, Long> id;
    public static volatile SingularAttribute<Examen, String> typeExamen;
    public static volatile SingularAttribute<Examen, Enseignant> enseignant;
    public static volatile ListAttribute<Examen, Etudiant> etudiant;
    public static volatile SingularAttribute<Examen, ParametrageQcm> Parametrage;
    public static volatile SingularAttribute<Examen, Date> dateExamen;

}