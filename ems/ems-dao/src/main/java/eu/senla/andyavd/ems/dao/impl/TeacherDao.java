package eu.senla.andyavd.ems.dao.impl;

import eu.senla.andyavd.ems.api.dao.ITeacherDao;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Course_;
import eu.senla.andyavd.ems.model.entities.Teacher;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao extends GenericDao<Teacher> implements ITeacherDao {

	private static final String ADD_COURSE_TO_TEACHER_QUERY = "update Course set teacher.id = :teacherId where id= :courseId";
	private static final String TEACHER_ID = "teacherId";
	private static final String COURSE_ID = "courseId";

	@Override
	public Class<Teacher> getGenericClass() {
		return Teacher.class;
	}

	@Override
	public void addCourseToTeacher(Long courseId, Long teacherId) {
		Session session = getSession();
		Query query = session.createQuery(ADD_COURSE_TO_TEACHER_QUERY);
		query.setParameter(TEACHER_ID, teacherId);
		query.setParameter(COURSE_ID, courseId);
		query.executeUpdate();
	}

	@Override
	public List<Course> getCoursesByTeacherId(Long teacherId) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Course> query = builder.createQuery(Course.class);
		Root<Course> root = query.from(Course.class);
		query.select(root).where(builder.equal(root.get(Course_.teacher), teacherId));
		TypedQuery<Course> result = session.createQuery(query);
		return result.getResultList();
	}
}