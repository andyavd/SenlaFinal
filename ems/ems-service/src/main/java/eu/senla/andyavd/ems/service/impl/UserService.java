package eu.senla.andyavd.ems.service.impl;

import eu.senla.andyavd.ems.dao.api.IGenericDao;
import eu.senla.andyavd.ems.dao.api.IUserDao;
import eu.senla.andyavd.ems.model.entities.User;
import eu.senla.andyavd.ems.model.entities.enums.LoginCode;
import eu.senla.andyavd.ems.service.api.IUserService;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;

	private IGenericDao<User> getDao() {
		return userDao;
	}

	@Override
	public User create(User user) {
		return getDao().create(user);
	}

	@Override
	public User get(Long id) {
		return getDao().get(id);
	}

	@Override
	public void update(User user) {
		getDao().update(user);
	}

	@Override
	public void delete(User user) {
		getDao().delete(user);
	}

	@Override
	public List<User> getAll() {
		return getDao().getAll();
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Override
	public LoginCode checkUser(String login, String password) {
		try {
			User user = userDao.getUserByLogin(login);
			return user.getPassword().equals(password) ? LoginCode.SUCCESSFULL_AUTHENTIFICATION : LoginCode.WRONG_PASSWORD;
		} catch (NoResultException e) {
			return LoginCode.LOGIN_DOESNOT_EXIST;
		}
	}

	@Override
	public boolean isExistingUser(String login) {
		try {
			getUserByLogin(login);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

}
