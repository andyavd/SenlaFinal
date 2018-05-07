package eu.senla.andyavd.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.api.dao.IGroupDao;
import eu.senla.andyavd.ems.api.dao.IStudentDao;
import eu.senla.andyavd.ems.api.dao.ITimetableDao;
import eu.senla.andyavd.ems.api.service.IGroupService;
import eu.senla.andyavd.ems.model.entities.Group;
import eu.senla.andyavd.ems.model.entities.Student;
import eu.senla.andyavd.ems.model.entities.Timetable;

@Transactional
@Service
public class GroupService implements IGroupService {

	@Autowired
	private IGroupDao groupDao;
	@Autowired
	private IStudentDao studentDao;
	@Autowired
	private ITimetableDao timetableDao;
	
	private IGenericDao<Group> getDao(){
		return groupDao;
	}
	
	@Override
	public Group create(Group group) {
		return getDao().create(group);
	}

	@Override
	public Group get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(Group group) {
		getDao().update(group);
	}

	@Override
	public void delete(Group group) {
		getDao().delete(group);
	}

	@Override
	public List<Group> getAll() {
		return getDao().getAll();
	}

	@Override
	public void addStudentToGroup(Long studentId, Long groupId) {
		Group group = groupDao.get(groupId);
		Student student = studentDao.get(studentId);
		student.setGroup(group);
		studentDao.update(student);
	}

	@Override
	public void removeStudentFromGroup(Long studentId) {
		Student student = studentDao.get(studentId);
		student.setGroup(null);
		studentDao.update(student);
	}
	
	@Override
	public void addTimetableToGroup(Long timetableId, Long groupId) {
		Group group = groupDao.get(groupId);
		Timetable timetable = timetableDao.get(timetableId);
		group.getTimetables().add(timetable);
		groupDao.update(group);
	}
	
	@Override
	public void removeTimetableFromGroup(Long timetableId, Long groupId) {
		Group group = groupDao.get(groupId);
		Timetable timetable = timetableDao.get(timetableId);
		group.getTimetables().remove(timetable);
		groupDao.update(group);
	}
}
