package eu.senla.andyavd.ems.web.dto.group;

import eu.senla.andyavd.ems.model.entities.Group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GroupDto {

	private Long id;
	@NotBlank
	@Size(max = 45)
	private String name;

	public GroupDto() {

	}

	public GroupDto(Group group) {
		this.id = group.getId();
		this.name = group.getName();
	}

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
}