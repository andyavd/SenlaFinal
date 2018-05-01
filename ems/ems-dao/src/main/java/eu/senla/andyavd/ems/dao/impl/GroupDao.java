package eu.senla.andyavd.ems.dao.impl;

import org.springframework.stereotype.Repository;

import eu.senla.andyavd.ems.dao.api.IGroupDao;
import eu.senla.andyavd.ems.model.entities.Group;

@Repository
public class GroupDao extends GenericDao<Group> implements IGroupDao {

	@Override
	public Class<Group> getGenericClass() {
		return Group.class;
	}
}