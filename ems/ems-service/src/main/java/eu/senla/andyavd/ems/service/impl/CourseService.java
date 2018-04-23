package eu.senla.andyavd.ems.service.impl;

import eu.senla.andyavd.ems.dao.api.ICourseDao;
import eu.senla.andyavd.ems.dao.api.IGenericDao;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;
import eu.senla.andyavd.ems.service.api.ICourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CourseService implements ICourseService {
	
	@Autowired
	ICourseDao courseDao;

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
	public void addLessonToCourse(Long idLesson, Long idCourse) {
		courseDao.addLessonToCourse(idLesson, idCourse);
	}

	@Override
	public void removeLessonFromCourse(Long idLesson) {
		courseDao.removeLessonFromCourse(idLesson);
	}

	@Override
	public List<Lesson> getLessonsByCourseId(Long idCourse) {
		return courseDao.getLessonsByCourseId(idCourse);
	}
}