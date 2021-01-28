package augustin_charly_jee.jee.model;

import java.util.Date;

public class User {

	private int id;
	private String login;
	private String password;
	private String lastname;
	private String firstname;
	private Date enteredAt;
	private String number;
	private String role;
	private String imageUrl;

	public User(String login, String password, String lastname, String firstname, Date enteredAt, String number,
			String role, String imageUrl) {
		super();
		this.login = login;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.enteredAt = enteredAt;
		this.number = number;
		this.role = role;
		this.imageUrl = imageUrl;
	}

	public User(int id, String login, String password, String lastname, String firstname, Date enteredAt, String number,
			String role, String imageUrl) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.enteredAt = enteredAt;
		this.number = number;
		this.role = role;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public String getFullName() {
		return firstname + " " + lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getEnteredAt() {
		return enteredAt;
	}

	public void setEnteredAt(Date enteredAt) {
		this.enteredAt = enteredAt;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImage_url() {
		return imageUrl;
	}

	public void setImage_url(String image_url) {
		this.imageUrl = image_url;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", enteredAt=" + enteredAt + ", number=" + number + ", role=" + role
				+ "]";
	}

}
