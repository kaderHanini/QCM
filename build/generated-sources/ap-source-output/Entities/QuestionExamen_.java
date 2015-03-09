package Entities;

import Entities.Examen;
import Entities.Question;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-09T15:29:55")
@StaticMetamodel(QuestionExamen.class)
public class QuestionExamen_ { 

    public static volatile SingularAttribute<QuestionExamen, Long> id;
    public static volatile SingularAttribute<QuestionExamen, Examen> examen;
    public static volatile SingularAttribute<QuestionExamen, Question> question;

}