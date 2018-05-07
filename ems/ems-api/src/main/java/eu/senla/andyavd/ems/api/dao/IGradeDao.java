package eu.senla.andyavd.ems.api.dao;

import eu.senla.andyavd.ems.model.entities.Grade;

import java.util.List;

public interface IGradeDao extends IGenericDao<Grade>{

	List<Grade> getStudentGrades(Long studentId);

	List<Grade> getGradesByTimetable(Long timetableId);
}
