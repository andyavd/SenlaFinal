package eu.senla.andyavd.ems.dao.impl;

import eu.senla.andyavd.ems.api.dao.IGenericDao;
import eu.senla.andyavd.ems.model.entities.AEntity;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class GenericDao<T extends AEntity> implements IGenericDao<T> {

	@Autowired
	private SessionFactory factory;

	protected Session getSession() {
		try {
			return factory.getCurrentSession();
		} catch (HibernateException e) {
			return factory.openSession();
		}
	}

	@Override
	public T create(T entity) {
		getSession().save(entity);
		return entity;
	}

	@Override
	public T get(Long id) {
		return getSession().get(getGenericClass(), id);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}
	
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public List<T> getAll() {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		query.select(root);
		TypedQuery<T> result = session.createQuery(query);
		return result.getResultList();
	}
}