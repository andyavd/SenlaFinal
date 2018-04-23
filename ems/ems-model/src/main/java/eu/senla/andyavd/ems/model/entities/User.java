package eu.senla.andyavd.ems.model.entities;

import eu.senla.andyavd.ems.model.entities.enums.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@SecondaryTables({ @SecondaryTable(name = "user_details"), @SecondaryTable(name = "user_credentials") })
public class User extends AEntity {

	@Column(name = "first_name")
	protected String firstName;

	@Column(name = "last_name")
	protected String lastName;

	@Column(name = "birthday", table = "user_details")
	protected Date birthday;

	@Column(name = "email", table = "user_details")
	protected String email;

	@Column(name = "city", table = "user_details")
	protected String city;

	@Column(name = "role", insertable = false, updatable = false)
	@Enumerated(value = EnumType.STRING)
	protected Role role;

	@Column(name = "login", table = "user_credentials")
	protected String login;

	@Column(name = "password", table = "user_credentials")
	protected String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
}