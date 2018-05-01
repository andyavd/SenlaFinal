package eu.senla.andyavd.ems.dao.api;

import eu.senla.andyavd.ems.model.entities.Group;
import eu.senla.andyavd.ems.model.entities.Student;

import java.util.List;

public interface IStudentDao extends IGenericDao<Student> {
	
	List<Student> getStudentsByGroup(Group group);
}
