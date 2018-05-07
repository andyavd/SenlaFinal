package eu.senla.andyavd.ems.web.dto.timetable;

import eu.senla.andyavd.ems.model.entities.Timetable;
import eu.senla.andyavd.ems.utils.DateFormatterUtil;

import javax.validation.constraints.NotBlank;

public class TimetableDto {

	private Long id;
	@NotBlank
	private String date;
	private String group;
	private Long groupId;

	public TimetableDto() {

	}

	public TimetableDto(Timetable timetable) {
		this.id = timetable.getId();
		this.date = DateFormatterUtil.stringFromDate(timetable.getDate());
		this.group = timetable.getGroup().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
