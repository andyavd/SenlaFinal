package eu.senla.andyavd.ems.web.dto.timetable;

import javax.validation.constraints.Size;

public class UpdateDto {

	private Long id;
	@Size(max = 45)
	private String name;
	private String date;
	private Long group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getGroup() {
		return group;
	}

	public void setGroup(Long group) {
		this.group = group;
	}
}
