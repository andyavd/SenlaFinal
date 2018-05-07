package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.IGroupService;
import eu.senla.andyavd.ems.api.service.ILessonService;
import eu.senla.andyavd.ems.api.service.ITimetableService;
import eu.senla.andyavd.ems.model.entities.Timetable;
import eu.senla.andyavd.ems.utils.DateFormatterUtil;
import eu.senla.andyavd.ems.web.dto.timetable.TimetableDto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/timetable/")
public class TimetableController {

	@Autowired
	private ITimetableService timetableService;
	@Autowired
	private IGroupService groupService;
	@Autowired
	private ILessonService lessonService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public TimetableDto getTimetable(@PathVariable("id") Long id) {
		return new TimetableDto(timetableService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public TimetableDto createTimetable(@Valid @RequestBody TimetableDto dto) {
		Timetable timetable = new Timetable();
		timetable.setDate(DateFormatterUtil.dateFromString(dto.getDate()));
		timetable.setGroup(groupService.get(dto.getGroupId()));
		return new TimetableDto(timetableService.create(timetable));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteTimetable(@PathVariable("id") Long id) {
		Timetable timetable = new Timetable();
		timetable.setId(id);
		timetableService.delete(timetable);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateTimetable(@Valid @RequestBody TimetableDto dto, @PathVariable("id") Long id) {
		Timetable timetable = timetableService.get(id);
		Date date = DateFormatterUtil.dateFromString(dto.getDate());
		if (date != null) {
			timetable.setDate(date);
		}
		Long groupId = dto.getGroupId();
		if (groupId != null && groupId != 0) {
			timetable.setGroup(groupService.get(groupId));
		}
		timetableService.update(timetable);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
	public List<TimetableDto> getAllTimetables() {
		return timetableService.getAll().stream().map(TimetableDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "group/{group}", method = RequestMethod.GET)
	public List<TimetableDto> getTimetablesByGroupId(@PathVariable("group") Long groupId) {
		List<TimetableDto> result = timetableService.getTimetablesByGroupId(groupId).stream().map(TimetableDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "{timetable}/add/lesson/{lesson}", method = RequestMethod.POST)
	public void addLessonToTimetable(@PathVariable("lesson") Long lessonId,
			@PathVariable("timetable") Long timetableId) {
		lessonService.addLessonToTimetable(lessonId, timetableId);
	}

	@RequestMapping(value = "{timetable}/remove/lesson/{lesson}", method = RequestMethod.POST)
	public void removeLessonFromTimetable(@PathVariable("lesson") Long lessonId) {
		lessonService.removeLessonFromTimetable(lessonId);
	}
}