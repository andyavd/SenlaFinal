package eu.senla.andyavd.ems.dao.impl;

import eu.senla.andyavd.ems.dao.api.ILessonDao;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.model.entities.Lesson;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonDao extends GenericDao<Lesson> implements ILessonDao {

	private static final String ADD_LESSON_TO_TIMETABLE_QUERY = "update Lesson set timetable.id = :timetableId where id= :lessonId";
	private static final String REMOVE_LESSON_FROM_TIMETABLE_QUERY = "update Lesson set timetable.id = null where id= :lessonId";
	private static final String LESSON_ID = "lessonId";
	private static final String TIMETABLE_ID = "timetableId";
	
	@Override
	public Class<Lesson> getGenericClass() {
		return Lesson.class;
	}
	
	@Override
	public List<Lesson> getLessonsByCourse(Course course) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Lesson> query = builder.createQuery(getGenericClass());
		Root<Lesson> root = query.from(getGenericClass());
		query.select(root).where(builder.equal(root.get("course"), course));
		TypedQuery<Lesson> result = session.createQuery(query);
		return result.getResultList();
	}
	
	@Override
	public void addLessonToTimetable(Long lessonId, Long timetableId) {
		Session session = getSession();
		Query query = session.createQuery(ADD_LESSON_TO_TIMETABLE_QUERY);
		query.setParameter(LESSON_ID, lessonId);
		query.setParameter(TIMETABLE_ID, timetableId);
		query.executeUpdate();
	}
	
	@Override
	public void removeLessonFromTimetable(Long lessonId) {
		Session session = getSession();
		Query query = session.createQuery(REMOVE_LESSON_FROM_TIMETABLE_QUERY);
		query.setParameter(LESSON_ID, lessonId);
		query.executeUpdate();
	}
}