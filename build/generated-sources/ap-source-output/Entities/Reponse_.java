package Entities;

import Entities.Question;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-07T18:36:07")
@StaticMetamodel(Reponse.class)
public class Reponse_ { 

    public static volatile SingularAttribute<Reponse, Long> id;
    public static volatile SingularAttribute<Reponse, String> reponse;
    public static volatile SingularAttribute<Reponse, String> typeReponse;
    public static volatile SingularAttribute<Reponse, Question> question;

}