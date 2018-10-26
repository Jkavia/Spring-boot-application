package io.javabrains.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//data access layer, methods defined are 
//getAlltopics, gettopic(id), Updatetopic(Topic),deletetopic(topic)/
//we use an inbuild spring interface crudrepository for all these functions

public interface CourseRepository extends CrudRepository<Course, String> {

//Spring data JPA uses format findBy"Property"  to retrive all the records in that table matching that property
	//property here refers to the column of that table
	//if property is an Object, try findBy"Object""Object'sProperty"
	
	public List<Course> findByTopicId(String topicId);

}
