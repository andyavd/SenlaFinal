package eu.senla.andyavd.ems.api.service;

import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Teacher;

import java.util.List;

public interface ITeacherService {

	Teacher create(Teacher teacher);

	Teacher get(Long id);

	void update(Teacher teacher);

	void delete(Teacher teacher);

	List<Teacher> getAll();

	void addCourseToTeacher(Long courseId, Long teacherId);

	List<Course> getCoursesByTeacherId(Long teacherId);
}
