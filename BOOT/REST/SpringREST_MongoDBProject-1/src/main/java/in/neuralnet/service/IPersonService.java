package in.neuralnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import in.neuralnet.collections.Person;

public interface IPersonService {

	public String save(Person person);
	
	 public List<Person> getPersonStartWith(String name);
	 
	 public void delete(String id);
	 
	 public List<Person> getPersonAgeBetween(Integer min,Integer max);
	 
	 public List<Person> findAllPersons();
	 
	 public Optional<Person> findPersonById(String id);
	 
	 public String updatePersonById( Person person);
	 
	
}
