package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.Role;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Student extends User {

	{
		this.role = Role.TEACHER;
	}

	@Column(name = "education")
	private String education;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupp_id")
	private Group groupp;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Grade> grades;

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Group getGroup() {
		return groupp;
	}

	public void setGroup(Group groupp) {
		this.groupp = groupp;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
}