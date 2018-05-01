package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.model.entities.Student;
import eu.senla.andyavd.ems.service.api.IGroupService;
import eu.senla.andyavd.ems.service.api.IStudentService;
import eu.senla.andyavd.ems.web.dto.student.GetDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student/")
public class StudentController {

	@Autowired
	IStudentService studentService;
	@Autowired
	IGroupService groupService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public GetDto getStudent(@PathVariable("id") Long id) {
		return new GetDto(studentService.get(id));
	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
	public List<GetDto> getAllStudents() {
		return studentService.getAll().stream().map(GetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") Long id) {
		Student student = new Student();
		student.setId(id);
		studentService.delete(student);
	}

	@RequestMapping(value = "group/{group}", method = RequestMethod.GET)
	public List<GetDto> getStudentsByGroupId(@PathVariable("group") Long groupId) {
		List<GetDto> result = studentService.getStudentsByGroupId(groupId).stream().map(GetDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "group/null", method = RequestMethod.GET)
	public List<GetDto> getStudentsWithoutGroup() {
		List<GetDto> result = studentService.getStudentsWithoutGroup().stream().map(GetDto::new)
				.collect(Collectors.toList());
		return result;
	}
}