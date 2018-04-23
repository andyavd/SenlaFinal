package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.LessonType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lesson.class)
public abstract class Lesson_ extends eu.senla.andyavd.ems.model.entities.AEntity_ {

	public static volatile ListAttribute<Lesson, Timetable> timetables;
	public static volatile SingularAttribute<Lesson, Course> course;
	public static volatile ListAttribute<Lesson, Grade> grades;
	public static volatile SingularAttribute<Lesson, String> title;
	public static volatile SingularAttribute<Lesson, LessonType> lessonType;

}

