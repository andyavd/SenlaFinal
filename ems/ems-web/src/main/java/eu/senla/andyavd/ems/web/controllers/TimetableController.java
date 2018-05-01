package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.model.entities.Timetable;
import eu.senla.andyavd.ems.service.api.IGroupService;
import eu.senla.andyavd.ems.service.api.ILessonService;
import eu.senla.andyavd.ems.service.api.ITimetableService;
import eu.senla.andyavd.ems.utils.DateFormatterUtil;
import eu.senla.andyavd.ems.web.dto.timetable.CreateDto;
import eu.senla.andyavd.ems.web.dto.timetable.GetDto;
import eu.senla.andyavd.ems.web.dto.timetable.UpdateDto;

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
	ITimetableService timetableService;
	@Autowired
	IGroupService groupService;
	@Autowired
	ILessonService lessonService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public GetDto getTimetable(@PathVariable("id") Long id) {
		return new GetDto(timetableService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public GetDto createTimetable(@Valid @RequestBody CreateDto dto) {
		Timetable timetable = new Timetable();
		timetable.setDate(DateFormatterUtil.dateFromString(dto.getDate()));
		timetable.setGroup(groupService.get(dto.getGroup()));
		return new GetDto(timetableService.create(timetable));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteTimetable(@PathVariable("id") Long id) {
		Timetable timetable = new Timetable();
		timetable.setId(id);
		timetableService.delete(timetable);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateTimetable(@Valid @RequestBody UpdateDto dto, @PathVariable("id") Long id) {
		Timetable timetable = timetableService.get(id);
		Date date = DateFormatterUtil.dateFromString(dto.getDate());
		if (date != null) {
			timetable.setDate(date);
		}
		Long groupId = dto.getGroup();
		if (groupId != null && groupId != 0) {
			timetable.setGroup(groupService.get(groupId));
		}
		timetableService.update(timetable);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
	public List<GetDto> getAllTimetables() {
		return timetableService.getAll().stream().map(GetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "group/{group}", method = RequestMethod.GET)
	public List<GetDto> getTimetablesByGroupId(@PathVariable("group") Long groupId) {
		List<GetDto> result = timetableService.getTimetablesByGroupId(groupId).stream().map(GetDto::new)
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