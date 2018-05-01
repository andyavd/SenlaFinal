package eu.senla.andyavd.ems.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "timetable")
public class Timetable extends AEntity {

	@Column(name = "timetable_date")
	private Date date;

	@OneToMany(mappedBy = "timetable", fetch = FetchType.LAZY)
	private List<Grade> grades;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupp_id")
	private Group group;

	@ManyToMany(mappedBy = "timetables")
	private List<Lesson> lessons;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}