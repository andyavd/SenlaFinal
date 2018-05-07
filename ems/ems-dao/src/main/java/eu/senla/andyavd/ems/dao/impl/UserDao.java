package eu.senla.andyavd.ems.dao.impl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import eu.senla.andyavd.ems.api.dao.IUserDao;
import eu.senla.andyavd.ems.model.entities.User;
import eu.senla.andyavd.ems.model.entities.User_;

@Repository
public class UserDao extends GenericDao<User> implements IUserDao {

	@Override
	public Class<User> getGenericClass() {
		return User.class;
	}

	@Override
	public User getUserByLogin(String login) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get(User_.login), login));
		TypedQuery<User> result = session.createQuery(query);
		User user = result.getSingleResult();
		return user;
	}
}
