package eu.senla.andyavd.ems.web.controllers;

import eu.senla.andyavd.ems.api.service.IGroupService;
import eu.senla.andyavd.ems.model.entities.Group;
import eu.senla.andyavd.ems.web.dto.group.GroupDto;

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
@RequestMapping(value = "/group/")
public class GroupController {

	@Autowired
	private IGroupService groupService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public GroupDto getGroup(@PathVariable("id") Long id) {
		return new GroupDto(groupService.get(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public GroupDto createGroup(@Valid @RequestBody GroupDto dto) {
		Group group = new Group();
		group.setName(dto.getName());
		return new GroupDto(groupService.create(group));
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteGroup(@PathVariable("id") Long id) {
		Group group = new Group();
		group.setId(id);
		groupService.delete(group);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateGroup(@PathVariable("id") Long id, @Valid @RequestBody GroupDto dto) {
		Group group = groupService.get(id);
		String name = dto.getName();
		if (!StringUtils.isEmpty(name)) {
			group.setName(name);
		}
		groupService.update(group);
	}

	@RequestMapping(value="all", method = RequestMethod.GET, produces = "application/json")
	public List<GroupDto> getAllGroups() {
		return groupService.getAll().stream().map(GroupDto::new).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "{group}/add/timetable/{timetable}", method = RequestMethod.GET)
	public void addTimetableToGroup(@PathVariable("timetable") Long timetableId, @PathVariable("group") Long groupId) {
		groupService.addTimetableToGroup(timetableId, groupId);
	}

	@RequestMapping(value = "{group}/remove/timetable/{timetable}", method = RequestMethod.GET)
	public void removeTimetableFromGroup(@PathVariable("timetable") Long timetableId, @PathVariable("group") Long groupId) {
		groupService.removeTimetableFromGroup(timetableId, groupId);
	}

	@RequestMapping(value = "{group}/add/student/{student}", method = RequestMethod.GET)
	public void addStudentToGroup(@PathVariable("student") Long studentId, @PathVariable("group") Long groupId) {
		groupService.addStudentToGroup(studentId, groupId);
	}

	@RequestMapping(value = "{group}/remove/student/{student}", method = RequestMethod.GET)
	public void removeStudentFromGroup(@PathVariable("student") Long studentId) {
		groupService.removeStudentFromGroup(studentId);
	}
}
