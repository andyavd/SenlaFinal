package eu.senla.andyavd.ems.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ extends eu.senla.andyavd.ems.model.entities.AEntity_ {

	public static volatile SingularAttribute<Course, Teacher> teacher;
	public static volatile ListAttribute<Course, Group> groups;
	public static volatile SingularAttribute<Course, String> title;
	public static volatile ListAttribute<Course, Lesson> lessons;

}

