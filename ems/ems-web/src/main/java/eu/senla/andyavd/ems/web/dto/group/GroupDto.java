package eu.senla.andyavd.ems.web.dto.group;

import eu.senla.andyavd.ems.model.entities.Group;

import javax.validation.constraints.Size;

public class GroupDto {

	@Size(max = 45)
	private String name;

	public GroupDto() {

	}

	public GroupDto(Group group) {
		this.name = group.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}