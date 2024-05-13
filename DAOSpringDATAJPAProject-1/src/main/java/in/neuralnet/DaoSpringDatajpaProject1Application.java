package in.neuralnet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.neuralnet.bo.CovidVaccine;
import in.neuralnet.service.ICovidService;

@SpringBootApplication
public class DaoSpringDatajpaProject1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DaoSpringDatajpaProject1Application.class, args);
		
		ICovidService service = context.getBean(ICovidService.class);
		
		/*CovidVaccine vaccine = new CovidVaccine();
	    vaccine.setRegno(12L);
		vaccine.setName("Pfizer ");
		vaccine.setCompany("Pfizer & Bion tech");
		vaccine.setLocation("USA");
		vaccine.setPrice(520.50);
		vaccine.setDosage(2);   */
//		
//		List<CovidVaccine> vaccines = new ArrayList<CovidVaccine>();
//		  vaccines.add(new CovidVaccine(null, "sputnik", "russie", "Russia", 567.8,
//		  2)); vaccines.add(new CovidVaccine(null, "pyzer", "pyzwer", "USA", 678.8,
//		  2)); vaccines.add(new CovidVaccine(null, "moderena", "moderena", "USA",
//		  455.8, 2)); 
//		  Iterable<CovidVaccine> listVaccines = service.registerInBatch(vaccines); 
//		  System.out.println(listVaccines);

		
		System.out.println("No of total registered vaccines are : "+service.getVaccineCount());
		System.out.println("The registered vaccines are : ");
		service.getAllVaccinesDetails().forEach(System.out::println);
		
		context.close();
	}

}
