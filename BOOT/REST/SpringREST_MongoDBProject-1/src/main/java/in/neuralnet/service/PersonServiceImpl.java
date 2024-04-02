package in.neuralnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.neuralnet.collections.Person;
import in.neuralnet.repository.IPersonRepository;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepository repository;
	
	@Override
	public String save(Person person) {
		
		return repository.save(person).getPersonId();
		
	}

	@Override
	public List<Person> getPersonStartWith(String name) {
		
		return repository.findByFirstNameStartsWith(name);
	}

	@Override
	public void delete(String id) {
		
		repository.deleteById(id);
		
	}

	@Override
	public List<Person> getPersonAgeBetween(Integer min, Integer max) {
		
		return repository.findPersonByAgeBetween(min, max);
	}

	@Override
	public List<Person> findAllPersons() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Person> findPersonById(String id) {

		return repository.findById(id);
	}

	@Override
	public String updatePersonById(Person person) {
		
		Optional<Person> existingPerson = repository.findById(person.getPersonId());
		
		if(!existingPerson.isEmpty())
		{
			return repository.save(person).toString();
		}
		else
		return "invalid person";
	}


	
	

}
