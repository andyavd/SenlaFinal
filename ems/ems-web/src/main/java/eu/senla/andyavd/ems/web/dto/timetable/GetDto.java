package eu.senla.andyavd.ems.web.dto.timetable;

import eu.senla.andyavd.ems.model.entities.Timetable;
import eu.senla.andyavd.ems.utils.DateFormatterUtil;

public class GetDto {

	private Long id;
	private String date;
	private String group;

	public GetDto() {

	}

	public GetDto(Timetable timetable) {
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
}
