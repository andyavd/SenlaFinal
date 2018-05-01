package eu.senla.andyavd.ems.dao.api;

import eu.senla.andyavd.ems.model.entities.Timetable;

import java.util.List;

public interface ITimetableDao extends IGenericDao<Timetable> {
	
	List<Timetable> getTimetablesByGroupId(Long groupId);
}
