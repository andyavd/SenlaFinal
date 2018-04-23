package eu.senla.andyavd.ems.dao.api;

import eu.senla.andyavd.ems.model.entities.User;

public interface IUserDao extends IGenericDao<User> {

	User getUserByLogin(String login);
}