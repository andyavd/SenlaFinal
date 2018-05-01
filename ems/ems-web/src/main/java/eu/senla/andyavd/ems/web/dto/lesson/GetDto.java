package eu.senla.andyavd.ems.web.dto.lesson;

import eu.senla.andyavd.ems.model.entities.Lesson;

public class GetDto {

	private Long id;
	private String title;
	private String type;
	private String course;

	public GetDto() {

	}

	public GetDto(Lesson lesson) {
		this.id = lesson.getId();
		this.title = lesson.getTitle();
		this.type = lesson.getLessonType().getValue();
		if (lesson.getCourse() != null) {
			this.course = lesson.getCourse().getTitle();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
