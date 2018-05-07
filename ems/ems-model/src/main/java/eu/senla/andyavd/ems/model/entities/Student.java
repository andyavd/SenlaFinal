package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.Role;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;


@Entity
@Table(name = "student")
@DiscriminatorValue(value = Role.Values.STUDENT)
public class Student extends Person {

	{
		this.role = Role.STUDENT;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupp_id")
	private Group group;

	@OneToMany(mappedBy = "timetable", fetch = FetchType.LAZY)
	private List<Grade> grades;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
}