package eu.senla.andyavd.ems.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Group.class)
public abstract class Group_ extends eu.senla.andyavd.ems.model.entities.AEntity_ {

	public static volatile ListAttribute<Group, Timetable> timetables;
	public static volatile SingularAttribute<Group, String> name;
	public static volatile ListAttribute<Group, Student> students;
	public static volatile SingularAttribute<Group, Course> course;

}

