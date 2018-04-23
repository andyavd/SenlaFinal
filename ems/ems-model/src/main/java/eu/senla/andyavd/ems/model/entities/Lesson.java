package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.LessonType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson extends AEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "lessonType")
	@Enumerated(value = EnumType.STRING)
	protected LessonType lessonType;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
	private List<Grade> grades;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "lesson_timetable", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = @JoinColumn(name = "timetable_id"))
	private List<Timetable> timetables;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LessonType getLessonType() {
		return lessonType;
	}

	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Timetable> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}
}