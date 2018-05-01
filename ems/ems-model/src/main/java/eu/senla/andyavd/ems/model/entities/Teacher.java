package eu.senla.andyavd.ems.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import eu.senla.andyavd.ems.model.entities.enums.Role;

@Entity
@Table(name = "teacher")
@DiscriminatorValue(value = Role.Values.TEACHER)
public class Teacher extends User {
	{
		this.role = Role.TEACHER;
	}

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<Course>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}