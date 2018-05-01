package eu.senla.andyavd.ems.web.dto.timetable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateDto {

	@NotBlank
	@Size(max = 45)
	private String name;
	private Long group;
	@NotBlank
	private String date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getGroup() {
		return group;
	}

	public void setGroup(Long group) {
		this.group = group;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
