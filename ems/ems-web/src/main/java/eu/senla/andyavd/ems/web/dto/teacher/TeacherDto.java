package eu.senla.andyavd.ems.web.dto.teacher;

import java.util.List;

import eu.senla.andyavd.ems.model.entities.Teacher;

public class TeacherDto {

	private Long id;
	private String password;
	private String degree;
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private List<Long> courses;
	
	public TeacherDto() {

	}

	public TeacherDto(Teacher teacher) {
		this.id = teacher.getId();
		this.degree = teacher.getDegree();
		this.firstName = teacher.getFirstName();
		this.lastName = teacher.getLastName();
		this.email = teacher.getEmail();
		this.city = teacher.getCity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
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
	
	public List<Long> getCourses() {
		return courses;
	}
	public void setCourses(List<Long> courses) {
		this.courses = courses;
	}
}
