package eu.senla.andyavd.ems.api.dao;

import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;

import java.util.List;

public interface ILessonDao extends IGenericDao<Lesson>{

	List<Lesson> getLessonsByCourse(Course course);

	void addLessonToTimetable(Long lessonId, Long timetableId);
	
	void removeLessonFromTimetable(Long lessonId);
}