package eu.senla.andyavd.ems.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "course")
public class Course extends AEntity {

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Group> groupps;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Lesson> lessons;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Group> getGroups() {
		return groupps;
	}

	public void setGroups(List<Group> groupps) {
		this.groupps = groupps;
	}
}
