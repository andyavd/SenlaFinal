package eu.senla.andyavd.ems.web.dto.timetable;

import java.util.Date;

import eu.senla.andyavd.ems.model.entities.Timetable;

public class TimetableLessonDto {

	private Long id;
	private Date date;
	private Long group;

	public TimetableLessonDto() {

	}

	public TimetableLessonDto(Timetable timetable) {
		this.id = timetable.getId();
		this.date = timetable.getDate();
		this.group = timetable.getGroup().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getGroup() {
		return group;
	}

	public void setGroup(Long group) {
		this.group = group;
	}
}
