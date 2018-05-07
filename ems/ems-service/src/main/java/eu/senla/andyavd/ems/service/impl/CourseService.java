package eu.senla.andyavd.ems.service.impl;

import eu.senla.andyavd.ems.api.dao.ICourseDao;
import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.api.service.ICourseService;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CourseService implements ICourseService {
	
	@Autowired
	private ICourseDao courseDao;

	private IGenericDao<Course> getDao() {
		return courseDao;
	}
	
	@Override
	public Course create(Course course) {
		return getDao().create(course);
	}

	@Override
	public Course get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(Course course) {
		getDao().update(course);
	}

	@Override
	public void delete(Course course) {
		getDao().delete(course);
	}

	@Override
	public List<Course> getAll() {
		return getDao().getAll();
	}

	@Override
	public void addLessonToCourse(Long lessonId, Long courseId) {
		courseDao.addLessonToCourse(lessonId, courseId);
	}

	@Override
	public void removeLessonFromCourse(Long lessonId) {
		courseDao.removeLessonFromCourse(lessonId);
	}

	@Override
	public List<Lesson> getLessonsByCourseId(Long courseId) {
		return courseDao.getLessonsByCourseId(courseId);
	}
}