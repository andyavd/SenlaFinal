package eu.senla.andyavd.ems.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "groupp")
public class Group extends AEntity {

	@Column(name = "groupp_name")
	private String name;

	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<Student> students;

	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<Timetable> timetables;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;
	
	public String getName() {
		return name;
	}
	
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
	
	public List<Timetable> getTimetables() {
		return timetables;
	}
	
	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}
}
