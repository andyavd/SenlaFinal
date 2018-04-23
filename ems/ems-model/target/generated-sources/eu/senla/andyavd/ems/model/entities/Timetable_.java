package eu.senla.andyavd.ems.model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Timetable.class)
public abstract class Timetable_ extends eu.senla.andyavd.ems.model.entities.AEntity_ {

	public static volatile SingularAttribute<Timetable, Date> date;
	public static volatile ListAttribute<Timetable, Grade> grades;
	public static volatile SingularAttribute<Timetable, Group> groupp;
	public static volatile ListAttribute<Timetable, Lesson> lessons;

}

