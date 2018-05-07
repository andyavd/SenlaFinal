package eu.senla.andyavd.ems.dao.impl;

import eu.senla.andyavd.ems.api.dao.ITimetableDao;
import eu.senla.andyavd.ems.model.entities.Group_;
import eu.senla.andyavd.ems.model.entities.Timetable;
import eu.senla.andyavd.ems.model.entities.Timetable_;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimetableDao extends GenericDao<Timetable> implements ITimetableDao {

	@Override
	public Class<Timetable> getGenericClass() {
		return Timetable.class;
	}

	@Override
	public List<Timetable> getTimetablesByGroupId(Long groupId) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Timetable> query = builder.createQuery(getGenericClass());
		Root<Timetable> root = query.from(getGenericClass());
		query.select(root).where(builder.equal(root.join(Timetable_.group).get(Group_.id), groupId));
		TypedQuery<Timetable> result = session.createQuery(query);
		return result.getResultList();
	}
}