package eu.senla.andyavd.ems.web.dto.course;

import eu.senla.andyavd.ems.model.entities.Course;

public class GetDto {
	
	private Long id;
	private String title;

	public GetDto(Course course) {
		this.id = course.getId();
		this.title = course.getTitle();
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
}
