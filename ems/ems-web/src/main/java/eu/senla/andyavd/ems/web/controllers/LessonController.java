package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.ICourseService;
import eu.senla.andyavd.ems.api.service.ILessonService;
import eu.senla.andyavd.ems.model.entities.Lesson;
import eu.senla.andyavd.ems.model.entities.enums.LessonType;
import eu.senla.andyavd.ems.web.dto.lesson.LessonDto;

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
@RequestMapping("/lesson/")
public class LessonController {

	@Autowired
	private ILessonService lessonService;
	@Autowired
	private ICourseService courseService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public LessonDto getLesson(@PathVariable("id") Long id) {
		return new LessonDto(lessonService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public LessonDto createLesson(@Valid @RequestBody LessonDto dto) {
		Lesson lesson = new Lesson();
		lesson.setTitle(dto.getTitle());
		String type = dto.getType();
		if (type.equals("LECTURE")) {
			lesson.setLessonType(LessonType.LECTURE);
		} else if (type.equals("SEMINAR")) {
			lesson.setLessonType(LessonType.SEMINAR);
		} else if (type.equals("TEST")) {
			lesson.setLessonType(LessonType.TEST);
		}
		return new LessonDto(lessonService.create(lesson));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteLesson(@PathVariable("id") Long id) {
		Lesson lesson = new Lesson();
		lesson.setId(id);
		lessonService.delete(lesson);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateLection(@Valid @RequestBody LessonDto dto, @PathVariable("id") Long id) {
		Lesson lesson = lessonService.get(id);
		String name = dto.getTitle();
		if (!StringUtils.isEmpty(name)) {
			lesson.setTitle(name);
		}
		Long courseId = dto.getCourseId();
		if (courseId != null && courseId != 0) {
			lesson.setCourse(courseService.get(courseId));
		}
		lessonService.update(lesson);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
	public List<LessonDto> getAllLections() {
		return lessonService.getAll().stream().map(LessonDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "course/{course}", method = RequestMethod.GET)
	public List<LessonDto> getLessonsByCourseId(@PathVariable("course") Long courseId) {
		List<LessonDto> result = lessonService.getLessonsByCourseId(courseId).stream().map(LessonDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "course/null", method = RequestMethod.GET)
	public List<LessonDto> getLessonsWithoutCourse() {
		List<LessonDto> result = lessonService.getLessonsWithoutCourse().stream().map(LessonDto::new)
				.collect(Collectors.toList());
		return result;
	}
}
