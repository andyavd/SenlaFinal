package eu.senla.andyavd.ems.web.dto.course;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateDto {

	@NotBlank
	@Size(max = 45)
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
