package eu.senla.andyavd.ems.api.service;

import java.util.List;

import eu.senla.andyavd.ems.model.entities.Group;

public interface IGroupService {
	
	Group create(Group group);

	Group get(Long id);

	void update(Group group);

	void delete(Group group);

	List<Group> getAll();
	
	void addStudentToGroup(Long studentId, Long groupId);

	void removeStudentFromGroup(Long studentId);

	void addTimetableToGroup(Long timetableId, Long groupId);

	void removeTimetableFromGroup(Long timetableId, Long groupId);
}