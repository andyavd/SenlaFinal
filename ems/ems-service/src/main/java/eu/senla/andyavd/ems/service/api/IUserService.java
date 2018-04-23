package eu.senla.andyavd.ems.service.api;

import eu.senla.andyavd.ems.model.entities.User;
import eu.senla.andyavd.ems.model.entities.enums.LoginCode;

import java.util.List;

public interface IUserService {

	User create(User user);

	User get(Long id);

	void update(User user);

	void delete(User user);

	List<User> getAll();

	User getUserByLogin(String login);

	LoginCode checkUser(String login, String password);

	boolean isExistingUser(String login);
}
