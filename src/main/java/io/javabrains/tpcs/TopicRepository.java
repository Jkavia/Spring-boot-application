package io.javabrains.tpcs;

import org.springframework.data.repository.CrudRepository;

//data access layer, methods defined are 
//getAlltopics, gettopic(id), Updatetopic(Topic),deletetopic(topic)/
//we use an inbuild spring interface crudrepository for all these functions

public interface TopicRepository extends CrudRepository<Topic, String> {


	

}
