package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.IUserService;
import eu.senla.andyavd.ems.model.entities.User;
import eu.senla.andyavd.ems.utils.supporters.ICurrentUserSupporter;
import eu.senla.andyavd.ems.web.dto.user.DetailsDto;
import eu.senla.andyavd.ems.web.dto.user.UserDto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/user/")
public class UserController implements ICurrentUserSupporter {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET)
	public UserDto getUserById(@PathVariable("id") Long id) {
		return new UserDto(userService.get(id));
	}

	@RequestMapping(value = "profile/details/", method = RequestMethod.GET)
	public DetailsDto getUserDetails() {
		return new DetailsDto(getCurrentUser());
	}

	@RequestMapping(value = "name", method = RequestMethod.GET)
	public String getUserName() {
		return "{\"User name is\" : \"" + getCurrentUser().getFirstName() + "_" + getCurrentUser().getLastName() + "\"}";
	}

	@RequestMapping(value = "role", method = RequestMethod.GET)
	public String getUserRole() {
		return "{\"User role is\" : \"" + getCurrentUser().getRole().getValue() + "\"}";
	}

	@RequestMapping(value = "profile/details/", method = RequestMethod.POST)
	private DetailsDto updateUserDetails(@Valid @RequestBody DetailsDto dto) {
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

		String degree = dto.getDegree();
		if (!StringUtils.isEmpty(degree)) {
			user.setDegree(degree);
		}

		String education = dto.getDegree();
		if (!StringUtils.isEmpty(education)) {
			user.setDegree(education);
		}

		userService.update(user);
		return new DetailsDto(user);
	}
}
