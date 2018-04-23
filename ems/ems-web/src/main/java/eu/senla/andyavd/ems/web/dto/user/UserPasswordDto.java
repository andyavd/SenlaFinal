package eu.senla.andyavd.ems.web.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserPasswordDto {

	@NotBlank
	@Size(min=8)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
