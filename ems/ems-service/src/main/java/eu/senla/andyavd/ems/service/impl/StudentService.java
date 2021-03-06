package eu.senla.andyavd.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.api.dao.IGroupDao;
import eu.senla.andyavd.ems.api.dao.IStudentDao;
import eu.senla.andyavd.ems.api.service.IStudentService;
import eu.senla.andyavd.ems.model.entities.Group;
import eu.senla.andyavd.ems.model.entities.Student;

@Transactional
@Service
public class StudentService implements IStudentService{

	@Autowired
	private IStudentDao studentDao;
	@Autowired
	private IGroupDao groupDao;

	private IGenericDao<Student> getDao() {
		return studentDao;
	}
	
	@Override
	public Student create(Student student) {
		return getDao().create(student);
	}

	@Override
	public Student get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(Student student) {
		getDao().update(student);
	}

	@Override
	public void delete(Student student) {
		getDao().delete(student);
	}

	@Override
	public List<Student> getAll() {
		return getDao().getAll();
	}

	@Override
	public List<Student> getStudentsByGroupId(Long groupId) {
		Group group = groupDao.get(groupId);
		return studentDao.getStudentsByGroup(group);
	}

	@Override
	public List<Student> getStudentsWithoutGroup() {
		List<Student> withoutGroup = new ArrayList<Student>();
		List<Student> students = getDao().getAll();
		for(Student student : students) {
			if(student.getGroup()==null) {
				withoutGroup.add(student);
			}
		}
		return withoutGroup;
	}
}