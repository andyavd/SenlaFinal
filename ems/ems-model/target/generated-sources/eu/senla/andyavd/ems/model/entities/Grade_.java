package eu.senla.andyavd.ems.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Grade.class)
public abstract class Grade_ extends eu.senla.andyavd.ems.model.entities.AEntity_ {

	public static volatile SingularAttribute<Grade, Student> student;
	public static volatile SingularAttribute<Grade, Integer> grade;
	public static volatile SingularAttribute<Grade, Lesson> lesson;
	public static volatile SingularAttribute<Grade, Timetable> timetable;

}

