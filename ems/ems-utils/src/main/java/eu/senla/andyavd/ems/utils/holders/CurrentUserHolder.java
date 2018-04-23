package eu.senla.andyavd.ems.utils.holders;

import eu.senla.andyavd.ems.model.entities.User;

public class CurrentUserHolder {

	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}