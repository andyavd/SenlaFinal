package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.model.entities.Teacher;
import eu.senla.andyavd.ems.service.api.ITeacherService;
import eu.senla.andyavd.ems.web.dto.teacher.TeacherGetDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher/")
public class TeacherController {

	@Autowired
	ITeacherService teacherService;
	
	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public TeacherGetDto getTeacher(@PathVariable("id") Long id) {
		return new TeacherGetDto(teacherService.get(id));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteTeacher(@PathVariable("id") Long id) {
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacherService.delete(teacher);
	}

	@RequestMapping(value="all", method = RequestMethod.GET, produces = "application/json")
	public List<TeacherGetDto> getAllTeachers() {
		return teacherService.getAll().stream().map(TeacherGetDto::new).collect(Collectors.toList());
	}
}
