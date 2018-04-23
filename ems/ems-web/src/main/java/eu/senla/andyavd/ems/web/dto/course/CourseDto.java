package eu.senla.andyavd.ems.web.dto.course;

import eu.senla.andyavd.ems.model.entities.Course;

public class CourseDto {

	private String title;

	public CourseDto() {
	}

	public CourseDto(Course course) {
		this.title = course.getTitle();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
