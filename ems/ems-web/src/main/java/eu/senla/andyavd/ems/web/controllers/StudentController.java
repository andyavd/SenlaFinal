package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.IStudentService;
import eu.senla.andyavd.ems.model.entities.Student;
import eu.senla.andyavd.ems.web.dto.student.StudentDto;

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
	private IStudentService studentService;
	
	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public StudentDto getStudent(@PathVariable("id") Long id) {
		return new StudentDto(studentService.get(id));
	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
	public List<StudentDto> getAllStudents() {
		return studentService.getAll().stream().map(StudentDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") Long id) {
		Student student = new Student();
		student.setId(id);
		studentService.delete(student);
	}

	@RequestMapping(value = "group/{group}", method = RequestMethod.GET)
	public List<StudentDto> getStudentsByGroupId(@PathVariable("group") Long groupId) {
		List<StudentDto> result = studentService.getStudentsByGroupId(groupId).stream().map(StudentDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "group/null", method = RequestMethod.GET)
	public List<StudentDto> getStudentsWithoutGroup() {
		List<StudentDto> result = studentService.getStudentsWithoutGroup().stream().map(StudentDto::new)
				.collect(Collectors.toList());
		return result;
	}
}