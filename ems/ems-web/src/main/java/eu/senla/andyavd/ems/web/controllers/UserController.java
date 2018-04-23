package eu.senla.andyavd.ems.web.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.senla.andyavd.ems.model.entities.User;
import eu.senla.andyavd.ems.service.api.IUserService;
import eu.senla.andyavd.ems.utils.supporters.ICurrentUserSupporter;
import eu.senla.andyavd.ems.web.dto.user.UserDetailsDto;

@RestController
@RequestMapping("/user/")
public class UserController implements ICurrentUserSupporter {

	@Autowired
	IUserService userService;

	@RequestMapping(value = "profile/details/", method = RequestMethod.GET)
	public UserDetailsDto getUserDetails() {
		return new UserDetailsDto(getCurrentUser());
	}

	@RequestMapping(value = "name", method = RequestMethod.GET)
	public String getUserName() {
		return "{\"name\" : \"" + getCurrentUser().getFirstName() + "_" + getCurrentUser().getLastName() + "\"}";
	}

	@RequestMapping(value = "role", method = RequestMethod.GET)
	public String getUserRole() {
		return "{\"role\" : \"" + getCurrentUser().getRole().getValue() + "\"}";
	}

	@RequestMapping(value = "profile/details/", method = RequestMethod.POST)
	private UserDetailsDto updateUserDetails(@Valid @RequestBody UserDetailsDto dto) {
		User user = userService.get(getCurrentUser().getId());

		String firstName = dto.getFirstName();
		if (!StringUtils.isEmpty(firstName)) {
			user.setFirstName(firstName);
		}

		String lastName = dto.getLastName();
		if (!StringUtils.isEmpty(lastName)) {
			user.setLastName(lastName);
		}

		String email = dto.getEmail();
		if (!StringUtils.isEmpty(email)) {
			user.setEmail(email);
		}

		String city = dto.getCity();
		if (!StringUtils.isEmpty(city)) {
			user.setCity(city);
		}

		Date birthday = dto.getBirthday();
		if (!StringUtils.isEmpty(birthday)) {
			user.setBirthday(birthday);
		}
		
		userService.update(user);
		return new UserDetailsDto(user);
	}
}
