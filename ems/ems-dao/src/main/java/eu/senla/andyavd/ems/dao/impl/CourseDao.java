package eu.senla.andyavd.ems.dao.impl;

import eu.senla.andyavd.ems.api.dao.ICourseDao;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Course_;
import eu.senla.andyavd.ems.model.entities.Lesson;
import eu.senla.andyavd.ems.model.entities.Lesson_;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao extends GenericDao<Course> implements ICourseDao {

	private static final String ADD_LESSON_TO_COURSE_QUERY = "update Lesson set course.id = :courseId where id= :lessonId";
	private static final String REMOVE_LESSON_FROM_COURSE_QUERY = "update Lesson set course.id = null where id= :lessonId";
	private static final String LESSON_ID = "lessonId";
	private static final String COURSE_ID = "courseId";

	@Override
	public Class<Course> getGenericClass() {
		return Course.class;
	}

	@Override
	public void addLessonToCourse(Long lessonId, Long courseId) {
		Session session = getSession();
		Query query = session.createQuery(ADD_LESSON_TO_COURSE_QUERY);
		query.setParameter(LESSON_ID, lessonId);
		query.setParameter(COURSE_ID, courseId);
		query.executeUpdate();
	}

	@Override
	public void removeLessonFromCourse(Long lessonId) {
		Session session = getSession();
		Query query = session.createQuery(REMOVE_LESSON_FROM_COURSE_QUERY);
		query.setParameter(COURSE_ID, lessonId);
		query.executeUpdate();
	}

	@Override
	public List<Lesson> getLessonsByCourseId(Long courseId) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Lesson> query = builder.createQuery(Lesson.class);
		Root<Lesson> root = query.from(Lesson.class);
		query.select(root).where(builder.equal(root.join(Lesson_.course).get(Course_.id), courseId));
		TypedQuery<Lesson> result = session.createQuery(query);
		return result.getResultList();
	}
}