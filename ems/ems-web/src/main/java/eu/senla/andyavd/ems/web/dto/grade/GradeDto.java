package eu.senla.andyavd.ems.web.dto.grade;

import eu.senla.andyavd.ems.model.entities.Grade;

import javax.validation.constraints.Max;

public class GradeDto {

	private Long id;
	private Long timetable;
	private Long student;
	@Max(5)
	private Integer grade;
	
	public GradeDto() {
		
	}
	
	public GradeDto(Grade grade) {
		this.id = grade.getId();
		this.timetable = grade.getTimetable().getId();
		this.student = grade.getStudent().getId();
		this.grade = grade.getGrade();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTimetable() {
		return timetable;
	}
	public void setTimetable(Long timetable) {
		this.timetable = timetable;
	}
	public Long getStudent() {
		return student;
	}
	public void setStudent(Long student) {
		this.student = student;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}
