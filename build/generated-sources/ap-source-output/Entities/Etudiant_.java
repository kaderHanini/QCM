package Entities;

import Entities.Examen;
import Entities.Resultat;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2015-03-07T18:36:07")
@StaticMetamodel(Etudiant.class)
public class Etudiant_ extends Personne_ {

    public static volatile SingularAttribute<Etudiant, String> specialite;
    public static volatile ListAttribute<Etudiant, Examen> Examens;
    public static volatile SingularAttribute<Etudiant, String> niveau;
    public static volatile ListAttribute<Etudiant, Resultat> reponseEtudiants;
    public static volatile SingularAttribute<Etudiant, Integer> numEtu;

}