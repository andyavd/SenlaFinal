package eu.senla.andyavd.ems.web.dto.lesson;

import eu.senla.andyavd.ems.model.entities.Lesson;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LessonDto {

	private Long id;
	@NotBlank
	@Size(max = 45)
	private String title;
	@NotBlank
	@Size(max = 45)
	private String type;
	private Long courseId;
	
	
	public LessonDto() {
		
	}

	public LessonDto(Lesson lesson) {
		this.id = lesson.getId();
		this.title = lesson.getTitle();
		this.type = lesson.getLessonType().getValue();
		if (lesson.getCourse() != null) {
			this.courseId = lesson.getCourse().getId();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourse(Long courseId) {
		this.courseId = courseId;
	}	
}
