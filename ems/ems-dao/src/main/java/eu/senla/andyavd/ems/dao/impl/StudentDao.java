package eu.senla.andyavd.ems.dao.impl;

import eu.senla.andyavd.ems.api.dao.IStudentDao;
import eu.senla.andyavd.ems.model.entities.Group;
import eu.senla.andyavd.ems.model.entities.Student;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends GenericDao<Student> implements IStudentDao {

	@Override
	public Class<Student> getGenericClass() {
		return Student.class;
	}

	@Override
	public List<Student> getStudentsByGroup(Group group) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(getGenericClass());
		Root<Student> root = query.from(getGenericClass());
		query.select(root).where(builder.equal(root.get("group"), group));
		TypedQuery<Student> result = session.createQuery(query);
		return result.getResultList();
	}
}