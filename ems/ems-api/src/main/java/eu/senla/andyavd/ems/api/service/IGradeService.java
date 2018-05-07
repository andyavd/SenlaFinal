package eu.senla.andyavd.ems.api.service;

import eu.senla.andyavd.ems.model.entities.Grade;

import java.util.List;

public interface IGradeService {

	Grade create(Grade grade);

	Grade get(Long id);

	void update(Grade grade);

	void delete(Grade grade);

	List<Grade> getAll();

	List<Grade> getStudentGrades(Long studentId);

	List<Grade> getGradesByTimetable(Long timetableId);
}
