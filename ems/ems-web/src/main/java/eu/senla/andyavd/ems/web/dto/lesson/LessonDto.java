package eu.senla.andyavd.ems.web.dto.lesson;

import eu.senla.andyavd.ems.model.entities.Lesson;

import javax.validation.constraints.Size;

public class LessonDto {

	@Size(max = 45)
	private String title;
	private String type;
	private Long course;
	
	public LessonDto() {
		
	}

	public LessonDto(Lesson lesson) {
		this.title = lesson.getTitle();
		this.type = lesson.getLessonType().getValue();
		if (lesson.getCourse() != null) {
			this.course = lesson.getCourse().getId();
		}
	}
	
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

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
	}
}
