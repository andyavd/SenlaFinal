package eu.senla.andyavd.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.senla.andyavd.ems.api.dao.ICourseDao;
import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.api.dao.ILessonDao;
import eu.senla.andyavd.ems.api.service.ILessonService;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;

@Transactional
@Service
public class LessonService implements ILessonService {

	@Autowired
	private ILessonDao lessonDao;
	
	@Autowired
	private ICourseDao courseDao;

	private IGenericDao<Lesson> getDao() {
		return lessonDao;
	}

	@Override
	public Lesson create(Lesson lesson) {
		return getDao().create(lesson);
	}

	@Override
	public Lesson get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(Lesson lesson) {
		getDao().update(lesson);
	}

	@Override
	public void delete(Lesson lesson) {
		getDao().delete(lesson);
	}

	@Override
	public List<Lesson> getAll() {
		return getDao().getAll();
	}

	@Override
	public void addLessonToTimetable(Long lessonId, Long timetableId) {
		lessonDao.addLessonToTimetable(lessonId, timetableId);
	}

	@Override
	public void removeLessonFromTimetable(Long lessonId) {
		lessonDao.removeLessonFromTimetable(lessonId);
	}
	
	@Override
	public List<Lesson> getLessonsByCourseId(Long courseId) {
		Course course = courseDao.get(courseId);
		return lessonDao.getLessonsByCourse(course);
	}

	@Override
	public List<Lesson> getLessonsWithoutCourse() {
		List<Lesson> withoutCourse = new ArrayList<Lesson>();
		List<Lesson> lessons = getDao().getAll();
		for(Lesson lesson : lessons) {
			if(lesson.getCourse()==null) {
				withoutCourse.add(lesson);
			}
		}
		return withoutCourse;
	}
}
