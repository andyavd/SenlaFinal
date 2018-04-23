package eu.senla.andyavd.ems.service.api;

import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;

import java.util.List;

public interface ICourseService {

	Course create(Course course);

	Course get(Long id);

	void update(Course course);

	void delete(Course course);

	List<Course> getAll();
	
	void addLessonToCourse(Long idLesson, Long idCourse);

	void removeLessonFromCourse(Long idLesson);

	List<Lesson> getLessonsByCourseId(Long idCourse);
}