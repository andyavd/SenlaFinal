package eu.senla.andyavd.ems.service.api;

import java.util.List;

import eu.senla.andyavd.ems.model.entities.Timetable;

public interface ITimetableService {

	Timetable create(Timetable timetable);

	Timetable get(Long id);

	void update(Timetable timetable);

	void delete(Timetable timetable);

	List<Timetable> getAll();

	List<Timetable> getTimetablesByGroupId(Long groupId);
}
