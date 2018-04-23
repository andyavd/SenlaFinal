package eu.senla.andyavd.ems.dao.api;

import eu.senla.andyavd.ems.model.entities.AEntity;

import java.util.List;

public interface IGenericDao<T extends AEntity> {

	Class<T> getGenericClass();

	T create(T entity);

	T get(Long id);

	void update(T entity);
	
	void delete(T entity);

	List<T> getAll();
}
