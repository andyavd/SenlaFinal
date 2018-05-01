package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.service.api.ICourseService;
import eu.senla.andyavd.ems.model.entities.Course;
import eu.senla.andyavd.ems.web.dto.course.CreateDto;
import eu.senla.andyavd.ems.web.dto.course.GetDto;
import eu.senla.andyavd.ems.web.dto.course.UpdateDto;

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
	ICourseService courseService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET)
	public GetDto getCourse(@PathVariable("id") Long id) {
		return new GetDto(courseService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public GetDto createCourse(@Valid @RequestBody CreateDto dto) {
		Course course = new Course();
		course.setTitle(dto.getTitle());
		return new GetDto(courseService.create(course));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") Long id) {
		Course course = new Course();
		course.setId(id);
		courseService.delete(course);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateCourse(@Valid @RequestBody UpdateDto dto, @PathVariable("id") Long id) {
		Course course = courseService.get(id);
		String name = dto.getTitle();
		if (!StringUtils.isEmpty(name)) {
			course.setTitle(name);
		}
		courseService.update(course);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<GetDto> getAllCourses() {
		return courseService.getAll().stream().map(GetDto::new).collect(Collectors.toList());
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
