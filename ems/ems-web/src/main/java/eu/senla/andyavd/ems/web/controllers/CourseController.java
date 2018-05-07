package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.ICourseService;
import eu.senla.andyavd.ems.api.service.ITeacherService;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.web.dto.course.CourseDto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/course/")
public class CourseController {

	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private ITeacherService teacherService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET)
	public CourseDto getCourse(@PathVariable("id") Long id) {
		return new CourseDto(courseService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public CourseDto createCourse(@Valid @RequestBody CourseDto dto) {
		Course course = new Course();
		course.setTitle(dto.getTitle());
		return new CourseDto(courseService.create(course));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") Long id) {
		Course course = new Course();
		course.setId(id);
		courseService.delete(course);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateCourse(@Valid @RequestBody CourseDto dto, @PathVariable("id") Long id) {
		Course course = courseService.get(id);
		String name = dto.getTitle();
		if (!StringUtils.isEmpty(name)) {
			course.setTitle(name);
		}
		Long teacher = dto.getTeacher();
		if(teacher != null && teacher != 0) {
			course.setTeacher(teacherService.get(teacher));
		}
		courseService.update(course);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<CourseDto> getAllCourses() {
		return courseService.getAll().stream().map(CourseDto::new).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "{course}/add/lesson/{lesson}", method = RequestMethod.POST)
	public void addLessonToCourse(@PathVariable("lesson") Long lessonId, @PathVariable("course") Long courseId) {
		courseService.addLessonToCourse(lessonId, courseId);
	}

	@RequestMapping(value = "{course}/remove/lesson/{lesson}", method = RequestMethod.POST)
	public void removeLessonFromCourse(@PathVariable("lesson") Long lessonId) {
		courseService.removeLessonFromCourse(lessonId);
	}
}
