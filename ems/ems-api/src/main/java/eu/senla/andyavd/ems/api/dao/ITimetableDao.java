package eu.senla.andyavd.ems.api.dao;

import eu.senla.andyavd.ems.model.entities.Timetable;

import java.util.List;

public interface ITimetableDao extends IGenericDao<Timetable> {
	
	List<Timetable> getTimetablesByGroupId(Long groupId);
}
