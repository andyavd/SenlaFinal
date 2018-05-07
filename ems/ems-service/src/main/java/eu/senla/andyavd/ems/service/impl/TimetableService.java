package eu.senla.andyavd.ems.service.impl;

import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.api.dao.ITimetableDao;
import eu.senla.andyavd.ems.api.service.ITimetableService;
import eu.senla.andyavd.ems.model.entities.Timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TimetableService implements ITimetableService {

	@Autowired
	private ITimetableDao timetableDao;

	private IGenericDao<Timetable> getDao() {
		return timetableDao;
	}

	@Override
	public Timetable create(Timetable timetable) {
		return getDao().create(timetable);
	}

	@Override
	public Timetable get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(Timetable timetable) {
		getDao().update(timetable);
	}

	@Override
	public void delete(Timetable timetable) {
		getDao().delete(timetable);
	}

	@Override
	public List<Timetable> getAll() {
		return getDao().getAll();
	}

	@Override
	public List<Timetable> getTimetablesByGroupId(Long groupId) {
		return timetableDao.getTimetablesByGroupId(groupId);
	}
}
