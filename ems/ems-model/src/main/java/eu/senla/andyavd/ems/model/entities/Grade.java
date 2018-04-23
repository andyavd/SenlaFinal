package eu.senla.andyavd.ems.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grade")
public class Grade extends AEntity {
	
	private int grade;

	@ManyToOne
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "timetable_id")
	private Timetable timetable;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
}