package eu.senla.andyavd.ems.service.impl;

import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.api.dao.IGradeDao;
import eu.senla.andyavd.ems.api.service.IGradeService;
import eu.senla.andyavd.ems.model.entities.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GradeService implements IGradeService {

	@Autowired
	private IGradeDao gradeDao;
	
	private IGenericDao<Grade> getDao() {
		return gradeDao;
	}
	
	@Override
	public Grade create(Grade grade) {
		return getDao().create(grade);
	}

	@Override
	public Grade get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(Grade grade) {
		getDao().update(grade);
	}

	@Override
	public void delete(Grade grade) {
		getDao().delete(grade);
	}

	@Override
	public List<Grade> getAll() {
		return getDao().getAll();
	}

	@Override
	public List<Grade> getStudentGrades(Long studentId) {
		return gradeDao.getStudentGrades(studentId);
	}

	@Override
	public List<Grade> getGradesByTimetable(Long timetableId) {
		return gradeDao.getGradesByTimetable(timetableId);
	}

}
