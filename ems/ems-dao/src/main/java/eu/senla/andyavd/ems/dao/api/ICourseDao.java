package eu.senla.andyavd.ems.dao.api;

import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;

import java.util.List;

public interface ICourseDao extends IGenericDao<Course> {

	void addLessonToCourse(Long idLesson, Long idCourse);

	void removeLessonFromCourse(Long idLesson);

	List<Lesson> getLessonsByCourseId(Long idCourse);
}