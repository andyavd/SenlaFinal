package eu.senla.andyavd.ems.web.dto.user;

import eu.senla.andyavd.ems.model.entities.User;

import javax.validation.constraints.Size;

import java.util.Date;

public class UserDetailsDto {

	@Size(max = 45)
	private String firstName;
	@Size(max = 45)
	private String lastName;
	@Size(max = 45)
	private String email;
	@Size(max = 45)
	private String city;
	private Date birthday;

	public UserDetailsDto() {

	}

	public UserDetailsDto(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.city = user.getCity();
		this.birthday = user.getBirthday();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
