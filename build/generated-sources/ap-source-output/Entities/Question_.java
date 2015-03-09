package Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-07T18:36:07")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, Long> id;
    public static volatile SingularAttribute<Question, String> sousTheme;
    public static volatile SingularAttribute<Question, String> theme;
    public static volatile SingularAttribute<Question, String> typeQuestion;
    public static volatile SingularAttribute<Question, String> question;

}