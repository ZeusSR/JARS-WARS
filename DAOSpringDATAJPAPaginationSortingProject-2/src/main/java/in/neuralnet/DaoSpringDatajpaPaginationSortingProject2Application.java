package in.neuralnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.neuralnet.bo.CovidVaccine;
import in.neuralnet.service.ICovidService;

@SpringBootApplication
public class DaoSpringDatajpaPaginationSortingProject2Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(DaoSpringDatajpaPaginationSortingProject2Application.class, args);
		
		ICovidService service = context.getBean(ICovidService.class);
		
//		CovidVaccine vaccine = new CovidVaccine();
		
//		service.fetchDetails(false, "regno").forEach(System.out::println);
		
		service.fetchDetailsByPageNo(4, 4, false, "regno") .forEach((vaccine)
				  -> System.out.println(vaccine.getRegno()+" "+vaccine.getName()+" "+vaccine.getPrice() + " " +
				  vaccine.getLocation()));
		
		context.close();
		
		
	}

}
