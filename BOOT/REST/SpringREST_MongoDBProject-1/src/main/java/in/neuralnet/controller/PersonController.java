package in.neuralnet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.neuralnet.collections.Person;
import in.neuralnet.service.IPersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	IPersonService service;
	
	  @PostMapping
	    public String save(@RequestBody Person person) {
	        return service.save(person);
	    }
	 
	  @GetMapping
	  public List<Person> getPersonStartwith(@RequestParam("name") String name)
		{
			return service.getPersonStartWith(name);
			
		}
	  
	  @DeleteMapping("{/id}")
	  public void delete(@RequestParam String id)
	  {
		  service.delete(id);
	  }
	  
	  @GetMapping("/between")
	  public List<Person> getPersonAgeBetween(@RequestParam("min") Integer min,@RequestParam("max")Integer max)
	  {
		  return service.getPersonAgeBetween(min, max);
		  
	  }
	  
	  @GetMapping("/all")
	  public List<Person> findAllPersons()
	  {
		  return service.findAllPersons();
	  }
	  
	  @GetMapping("{/id}")
	  public Optional<Person> findPersonById(String id)
	  {
		  return service.findPersonById(id);
	  }
	  
	  @PostMapping("/update")
	    public String updatePersonById(@RequestBody Person person) {
	        return service.updatePersonById(person);
	    }
	
}
