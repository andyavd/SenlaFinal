package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.IStudentService;
import eu.senla.andyavd.ems.api.service.ITeacherService;
import eu.senla.andyavd.ems.api.service.IUserService;
import eu.senla.andyavd.ems.model.entities.Person;
import eu.senla.andyavd.ems.model.entities.Student;
import eu.senla.andyavd.ems.model.entities.Teacher;
import eu.senla.andyavd.ems.model.entities.enums.LoginCode;
import eu.senla.andyavd.ems.web.dto.user.CodeResponseDto;
import eu.senla.andyavd.ems.web.dto.user.CredentialsDto;
import eu.senla.andyavd.ems.web.dto.user.RegistrationDto;
import eu.senla.andyavd.ems.web.permissions.JWTManager;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private IUserService userService;
	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public CodeResponseDto registerUser(@Valid @RequestBody RegistrationDto dto) {
		if (!userService.isExistingUser(dto.getLogin())) {
			String role = dto.getRole();
			Person person = role.equals("STUDENT") ? new Student() : new Teacher();
			person.setLogin(dto.getLogin());
			person.setPassword(dto.getPassword());
			person.setFirstName(dto.getFirstName());
			person.setLastName(dto.getLastName());
			person.setEmail(dto.getEmail());
			person.setCity(dto.getCity());
			person.setBirthday(dto.getBirthday());
			if (role.equals("STUDENT")) {
				person.setEducation(dto.getEducation());
				studentService.create((Student) person);
			} else {
				person.setDegree(dto.getDegree());
				teacherService.create((Teacher) person);
			}
			return new CodeResponseDto(LoginCode.LOGIN_DOESNOT_EXIST);
		} else {
			return new CodeResponseDto(LoginCode.LOGIN_EXISTS);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CodeResponseDto login(@Valid @RequestBody CredentialsDto dto) {
		LoginCode code = userService.checkUser(dto.getLogin(), dto.getPassword());
		if (code == LoginCode.SUCCESSFULL_AUTHENTIFICATION) {
			return new CodeResponseDto(LoginCode.SUCCESSFULL_AUTHENTIFICATION,
					JWTManager.createToken(userService.getUserByLogin(dto.getLogin())));
		} else {
			return new CodeResponseDto(code);
		}
	}
}
