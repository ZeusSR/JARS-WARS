package in.neuralnet.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import in.neuralnet.collections.Person;

@Repository
public interface IPersonRepository extends MongoRepository<Person, String>{
	
	public List<Person> findByFirstNameStartsWith(String name);
	
	// public List<Person> findByAgeBetween(Integer min,Integer max);

	  @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}",
	           fields = "{firstName:  1}")
	  List<Person> findPersonByAgeBetween(Integer min, Integer max);
	 
	  
	 
	  
	 
	
	 
}
