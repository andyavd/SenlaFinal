package eu.senla.andyavd.ems.api.service;

import eu.senla.andyavd.ems.model.entities.Student;

import java.util.List;

public interface IStudentService {

	Student create(Student student);

	Student get(Long id);

	void update(Student student);

	void delete(Student student);

	List<Student> getAll();

	List<Student> getStudentsByGroupId(Long groupId);

	List<Student> getStudentsWithoutGroup();
}
