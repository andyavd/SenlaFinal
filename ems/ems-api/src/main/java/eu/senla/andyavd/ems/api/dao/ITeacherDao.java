package eu.senla.andyavd.ems.api.dao;

import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Teacher;

import java.util.List;

public interface ITeacherDao extends IGenericDao<Teacher>{

	void addCourseToTeacher(Long courseId, Long teacherId);

	List<Course> getCoursesByTeacherId(Long teacherId);
}