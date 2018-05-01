package eu.senla.andyavd.ems.web.dto.group;

import eu.senla.andyavd.ems.model.entities.Student;

import java.util.Date;

public class GroupStudentDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private Date birthday;
	private String education;
	private String login;

	public GroupStudentDto() {

	}

	public GroupStudentDto(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.city = student.getCity();
		this.birthday = student.getBirthday();
		this.education = student.getEducation();
		this.login = student.getLogin();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}