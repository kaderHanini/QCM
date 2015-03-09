package Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-09T15:29:55")
@StaticMetamodel(Personne.class)
public class Personne_ { 

    public static volatile SingularAttribute<Personne, Long> id;
    public static volatile SingularAttribute<Personne, String> prenom;
    public static volatile SingularAttribute<Personne, String> email;
    public static volatile SingularAttribute<Personne, Integer> tel;
    public static volatile SingularAttribute<Personne, String> sexe;
    public static volatile SingularAttribute<Personne, Date> dateNasi;
    public static volatile SingularAttribute<Personne, String> nom;

}