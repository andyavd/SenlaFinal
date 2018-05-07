package eu.senla.andyavd.ems.service.impl;

import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.api.dao.ITeacherDao;
import eu.senla.andyavd.ems.api.service.ITeacherService;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TeacherService implements ITeacherService {

	@Autowired
	private ITeacherDao teacherDao;

	private IGenericDao<Teacher> getDao() {
		return teacherDao;
	}

	@Override
	public Teacher create(Teacher teacher) {
		return getDao().create(teacher);
	}

	@Override
	public Teacher get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(Teacher teacher) {
		getDao().update(teacher);
	}

	@Override
	public void delete(Teacher teacher) {
		getDao().delete(teacher);
	}

	@Override
	public List<Teacher> getAll() {
		return getDao().getAll();
	}

	@Override
	public void addCourseToTeacher(Long courseId, Long teacherId) {
		teacherDao.addCourseToTeacher(courseId, teacherId);
	}

	@Override
	public List<Course> getCoursesByTeacherId(Long teacherId) {
		return teacherDao.getCoursesByTeacherId(teacherId);
	}
}