package io.javabrains.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.tpcs.Topic;

@RestController
public class CourseController {


	
	//injecting the service from springs memory since it was already considered as singleton class.
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllcourses(@PathVariable String id) {
		
		return courseService.getAll(id);
		
	}
	
	@RequestMapping("topics/{topicid}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		
		return courseService.getCourse(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicid}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		System.out.println(course);
		System.out.println("herer "+topicid);
		courseService.addCourse(course);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="topics/{topicid}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id,@PathVariable String topicid) {
		course.setTopic(new Topic( topicid,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	
}
