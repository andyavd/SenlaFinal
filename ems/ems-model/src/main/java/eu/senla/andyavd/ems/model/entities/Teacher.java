package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
@DiscriminatorValue(value = Role.Values.TEACHER)
public class Teacher extends User {
	{
		this.role = Role.TEACHER;
	}

	@Column(name = "academic_degree")
	private String degree;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<Course>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
}
