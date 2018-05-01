package eu.senla.andyavd.ems.web.dto.group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateDto {

	@NotBlank
	@Size(max = 45)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
