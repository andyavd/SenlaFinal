package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.IGradeService;
import eu.senla.andyavd.ems.api.service.IStudentService;
import eu.senla.andyavd.ems.api.service.ITimetableService;
import eu.senla.andyavd.ems.model.entities.Grade;
import eu.senla.andyavd.ems.web.dto.grade.GradeDto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grade/")
public class GradeController {

	@Autowired
	private IGradeService gradeService;
	
	@Autowired
	private ITimetableService timetableService;
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value = "{id}/", method = RequestMethod.GET)
	public GradeDto getGrade(@PathVariable("id") Long id) {
		return new GradeDto(gradeService.get(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void createGrade(@Valid @RequestBody GradeDto dto) {
		Grade grade = new Grade();
		grade.setTimetable(timetableService.get(dto.getTimetable()));
		grade.setStudent(studentService.get(dto.getStudent()));
		grade.setGrade(dto.getGrade());
		gradeService.create(grade);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteGrade(@PathVariable("id") Long id) {
		Grade grade = new Grade();
		grade.setId(id);
		gradeService.delete(grade);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateGrade(@Valid @RequestBody GradeDto dto, @PathVariable("id") Long id) {
		Grade grade = gradeService.get(id);
		Integer grade1 = dto.getGrade();
		if (grade1 != null && grade1 != 0) {
			grade.setGrade(grade1);
		}
		Long timetableId = dto.getTimetable();
		if (timetableId != null && timetableId != 0) {
			grade.setTimetable(timetableService.get(timetableId));
		}
		Long studentId = dto.getStudent();
		if (studentId != null && studentId != 0) {
			grade.setStudent(studentService.get(studentId));
		}
		gradeService.update(grade);
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public List<GradeDto> getAllGrades() {
		return gradeService.getAll().stream().map(GradeDto::new).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "timetable/{timetable}", method = RequestMethod.GET)
	public List<GradeDto> getGradesByTimetable(@PathVariable("timetable") Long timetableId) {
		return gradeService.getGradesByTimetable(timetableId).stream().map(GradeDto::new).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "student/{student}", method = RequestMethod.GET)
	public List<GradeDto> getStudentGrades(@PathVariable("student") Long studentId) {
		return gradeService.getStudentGrades(studentId).stream().map(GradeDto::new).collect(Collectors.toList());
	}
}
