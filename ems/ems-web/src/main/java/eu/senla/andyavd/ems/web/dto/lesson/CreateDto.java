package eu.senla.andyavd.ems.web.dto.lesson;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import eu.senla.andyavd.ems.model.entities.Course;

public class CreateDto {

	@NotBlank
	@Size(max = 45)
	private String title;
	
	@NotBlank
	@Size(max = 45)
	private String type;
	
	private Course course;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}	
}
