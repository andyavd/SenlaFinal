package eu.senla.andyavd.ems.api.service;

import eu.senla.andyavd.ems.model.entities.Lesson;

import java.util.List;

public interface ILessonService {

	Lesson create(Lesson lesson);

	Lesson get(Long id);

	void update(Lesson lesson);

	void delete(Lesson lesson);

	List<Lesson> getAll();

	void addLessonToTimetable(Long lessonId, Long timetableId);

	void removeLessonFromTimetable(Long lessonId);

	List<Lesson> getLessonsByCourseId(Long courseId);

	List<Lesson> getLessonsWithoutCourse();
}
