package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "teacher")
@DiscriminatorValue(value = Role.Values.TEACHER)
public class Teacher extends Person {
	{
		this.role = Role.TEACHER;
	}

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}