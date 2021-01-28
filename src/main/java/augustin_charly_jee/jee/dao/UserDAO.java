package augustin_charly_jee.jee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import augustin_charly_jee.jee.utils.DAO;
import augustin_charly_jee.jee.utils.DataConnect;
import augustin_charly_jee.jee.model.User;

public class UserDAO implements DAO<User, Integer> {

	private Connection c;

	public UserDAO() {
		c = DataConnect.getInstance().getConnection();
	}

	public List<User> findAll() {
		String querry = "select * from user;";
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = c.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String login = rs.getString("login");
				String password = rs.getString("password");
				String lastname = rs.getString("lastname");
				String firstname = rs.getString("firstname");
				Date enteredAt = rs.getDate("entered_at");
				String number = rs.getString("number");
				String role = rs.getString("role");
				String image_url = rs.getString("image_url");
				User user = new User(id, login, password, lastname, firstname, enteredAt, number, role, image_url);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getById(Integer id) {
		String querry = "select * from user where id = ?;";
		User user = null;
		try {
			PreparedStatement ps = c.prepareStatement(querry);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String login = rs.getString("login");
				String password = rs.getString("password");
				String lastname = rs.getString("lastname");
				String firstname = rs.getString("firstname");
				Date enteredAt = rs.getDate("entered_at");
				String number = rs.getString("number");
				String role = rs.getString("role");
				String image_url = rs.getString("image_url");
				user = new User(id, login, password, lastname, firstname, enteredAt, number, role, image_url);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public User getByLogin(String login) {
		String querry = "select * from user where login = ?;";
		User user = null;
		try {
			PreparedStatement ps = c.prepareStatement(querry);
			ps.setString(1, login);
			;
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String lastname = rs.getString("lastname");
				String firstname = rs.getString("firstname");
				Date enteredAt = rs.getDate("entered_at");
				String number = rs.getString("number");
				String role = rs.getString("role");
				String image_url = rs.getString("image_url");
				user = new User(id, login, password, lastname, firstname, enteredAt, number, role, image_url);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public Integer create(User t) {
		String querry = "insert into user (login,password,lastname,firstname,entered_at,number,role,image_url) values (?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps = c.prepareStatement(querry, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getLogin());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getLastname());
			ps.setString(4, t.getFirstname());
			ps.setDate(5, t.getEnteredAt());
			ps.setString(6, t.getNumber());
			ps.setString(7, t.getRole());
			ps.setString(8, t.getImage_url());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			Integer generatedId = null;

			if (rs.next()) {
				generatedId = rs.getInt(1);
			}
			return generatedId;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Integer update(User t) {
		String querry = "update annonce set login = ?, password = ?, lastname = ?, firstname = ?, entered_at = ?, number = ?, role = ?, image_url = ?  where id = ?;";
		try {
			PreparedStatement ps = c.prepareStatement(querry);
			ps.setString(1, t.getLogin());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getLastname());
			ps.setString(4, t.getFirstname());
			ps.setDate(5, t.getEnteredAt());
			ps.setString(6, t.getNumber());
			ps.setString(7, t.getRole());
			ps.setString(8, t.getImage_url());
			ps.setInt(9, t.getId());
			ps.executeUpdate();

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void delete(User t) {
		deleteById(t.getId());
	}

	public void deleteById(Integer id) {
		String querry = "delete from user where id = ?;";
		try {
			PreparedStatement ps = c.prepareStatement(querry);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
