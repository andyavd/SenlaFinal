package eu.senla.andyavd.ems.dao.impl;

import eu.senla.andyavd.ems.api.dao.IGradeDao;
import eu.senla.andyavd.ems.model.entities.Grade;
import eu.senla.andyavd.ems.model.entities.Grade_;
import eu.senla.andyavd.ems.model.entities.Student_;
import eu.senla.andyavd.ems.model.entities.Timetable_;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeDao extends GenericDao<Grade> implements IGradeDao {

	@Override
	public Class<Grade> getGenericClass() {
		return Grade.class;
	}

	@Override
	public List<Grade> getStudentGrades(Long studentId) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Grade> query = builder.createQuery(getGenericClass());
		Root<Grade> root = query.from(getGenericClass());
		query.select(root).where(builder.equal(root.join(Grade_.student).get(Student_.id), studentId));
		TypedQuery<Grade> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	public List<Grade> getGradesByTimetable(Long timetableId) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Grade> query = builder.createQuery(getGenericClass());
		Root<Grade> root = query.from(getGenericClass());
		query.select(root).where(builder.equal(root.join(Grade_.timetable).get(Timetable_.id), timetableId));
		TypedQuery<Grade> result = session.createQuery(query);
		return result.getResultList();
	}
}
