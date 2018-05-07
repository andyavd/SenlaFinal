package eu.senla.andyavd.ems.web.dto.course;

import eu.senla.andyavd.ems.model.entities.Course;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CourseDto {

	private Long id;
	@NotBlank
	@Size(max = 45)
	private String title;
	private Long teacher;

	public CourseDto() {
	}

	public CourseDto(Course course) {
		this.id = course.getId();
		this.title = course.getTitle();
		if(course.getTeacher() !=null) {
			this.teacher = course.getTeacher().getId();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTeacher() {
		return teacher;
	}

	public void setTeacher(Long teacher) {
		this.teacher = teacher;
	}
}
