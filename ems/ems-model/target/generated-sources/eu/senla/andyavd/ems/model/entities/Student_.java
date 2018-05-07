package eu.senla.andyavd.ems.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ extends eu.senla.andyavd.ems.model.entities.Person_ {

	public static volatile ListAttribute<Student, Grade> grades;
	public static volatile SingularAttribute<Student, Group> group;

}

