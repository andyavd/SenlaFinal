package eu.senla.andyavd.ems.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "groupp")
public class Group extends AEntity {

	@Column(name = "groupp_name")
	private String name;

	@OneToMany(mappedBy = "groupp", fetch = FetchType.LAZY)
	private List<Student> students;

	@OneToMany(mappedBy = "groupp", fetch = FetchType.LAZY)
	private List<Timetable> timetables;
	
	public String getName() {
		return name;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "groups_course", joinColumns = @JoinColumn(name = "groupp_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Course course;
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
