package eu.senla.andyavd.ems.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Teacher.class)
public abstract class Teacher_ extends eu.senla.andyavd.ems.model.entities.User_ {

	public static volatile ListAttribute<Teacher, Course> courses;
	public static volatile SingularAttribute<Teacher, String> degree;

}
