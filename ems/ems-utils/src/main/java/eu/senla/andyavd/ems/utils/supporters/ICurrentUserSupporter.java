package eu.senla.andyavd.ems.utils.supporters;

import eu.senla.andyavd.ems.model.entities.User;
import eu.senla.andyavd.ems.utils.holders.CurrentUserHolder;
import eu.senla.andyavd.ems.utils.providers.ApplicationContextProvider;

public interface ICurrentUserSupporter {
	public default User getCurrentUser() {
		return ApplicationContextProvider.getApplicationContext().getBean(CurrentUserHolder.class).getCurrentUser();
	}
}