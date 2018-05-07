package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.Role;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ extends eu.senla.andyavd.ems.model.entities.AEntity_ {

	public static volatile SingularAttribute<Person, Date> birthday;
	public static volatile SingularAttribute<Person, String> firstName;
	public static volatile SingularAttribute<Person, String> lastName;
	public static volatile SingularAttribute<Person, String> password;
	public static volatile SingularAttribute<Person, String> education;
	public static volatile SingularAttribute<Person, Role> role;
	public static volatile SingularAttribute<Person, String> city;
	public static volatile SingularAttribute<Person, String> degree;
	public static volatile SingularAttribute<Person, String> login;
	public static volatile SingularAttribute<Person, String> email;

}

