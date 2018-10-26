package io.javabrains.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	

	public List<Course> getAll(String topicId){
	
		List<Course> lst = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(lst::add);
		return lst;
	}
	
	public Course getCourse(String id) {
		
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course tp) {
		
		courseRepository.save(tp);
	}

	public void updateCourse(Course topic) {
		
		courseRepository.save(topic);

		
	}

	public void deleteCourse(String id) {
	
	
	
		courseRepository.delete(id);	
		
	}
}
