package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.Role;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends eu.senla.andyavd.ems.model.entities.AEntity_ {

	public static volatile SingularAttribute<User, Date> birthday;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> education;
	public static volatile SingularAttribute<User, Role> role;
	public static volatile SingularAttribute<User, String> city;
	public static volatile SingularAttribute<User, String> degree;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> email;

}

