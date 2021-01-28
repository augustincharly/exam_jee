package augustin_charly_jee.jee.services;

import java.util.List;

import augustin_charly_jee.jee.dao.UserDAO;
import augustin_charly_jee.jee.model.User;

public class UserService {

	private UserDAO dao;

	public UserService() {
		dao = new UserDAO();
	}

	public List<User> getAll() {
		return dao.findAll();
	}

	public User getById(int id) {
		return dao.getById(id);
	}

	public User getByLogin(String login) {
		return dao.getByLogin(login);
	}

	public void create(User u) {
		dao.create(u);
	}

	public void update(User u) {
		dao.update(u);
	}

	public void delete(User u) {
		dao.delete(u);
	}

}
