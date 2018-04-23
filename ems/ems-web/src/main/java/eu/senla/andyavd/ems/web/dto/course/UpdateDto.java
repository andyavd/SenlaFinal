package eu.senla.andyavd.ems.web.dto.course;

import eu.senla.andyavd.ems.model.entities.Course;

import javax.validation.constraints.Size;

public class UpdateDto {

	@Size(max = 45)
	private String title;

	public UpdateDto() {

	}

	public UpdateDto(Course course) {
		this.title = course.getTitle();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
