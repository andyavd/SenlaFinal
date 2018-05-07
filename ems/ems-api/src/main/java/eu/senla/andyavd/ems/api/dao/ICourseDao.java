package eu.senla.andyavd.ems.api.dao;

import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;

import java.util.List;

public interface ICourseDao extends IGenericDao<Course> {

	void addLessonToCourse(Long lessonId, Long courseId);

	void removeLessonFromCourse(Long lessonId);

	List<Lesson> getLessonsByCourseId(Long courseId);
}