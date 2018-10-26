package io.javabrains.tpcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	//arrays.aslist is immutable
/*	List <Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","lel","spring fmwk"),
			new Topic("java","lol","jdk"),
			new Topic("javascript","huehue","ecma script")
			));*/
	
	public List<Topic> getAll(){
		//return topics;
		//topicRepository.findAll() fetches all the rows from the table
		
		List<Topic> lst = new ArrayList<>();
		topicRepository.findAll().forEach(lst::add);
		return lst;
	}
	
	public Topic getTopic(String id) {
		//Topic tp=topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		//return tp;
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic tp) {
		//topics.add(tp);
		topicRepository.save(tp);
	}

	public void updateTopic(Topic topic, String id) {
		//spring boot JPA looks for similar id for this topic instance and tehn updates it, if non
		//existing then it adds a new row.
		
		topicRepository.save(topic);
		
		/*for(int i=0;i<topics.size();i++) {
			if(id.equals(topics.get(i).getId())) {
				topics.set(i,topic);
			}
		}*/
		
	}

	public void deleteTopic(String id) {
	
	//topics.removeIf(t->t.getId().equals(id));
	
		topicRepository.delete(id);	
		
	}
}
