package eu.senla.andyavd.ems.web.dto.group;

import eu.senla.andyavd.ems.model.entities.Group;

public class GetDto {

	private Long id;
	private String name;

	public GetDto() {

	}

	public GetDto(Group group) {
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
