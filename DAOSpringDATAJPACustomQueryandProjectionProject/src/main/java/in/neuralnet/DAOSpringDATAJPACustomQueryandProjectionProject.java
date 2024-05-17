package in.neuralnet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.neuralnet.bo.CovidVaccine;
import in.neuralnet.service.ICovidService;
import type.ResultView;
import type.ResultView3;

@SpringBootApplication
public class DAOSpringDATAJPACustomQueryandProjectionProject {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(DAOSpringDATAJPACustomQueryandProjectionProject.class, args);
		
		ICovidService service = context.getBean(ICovidService.class);
		
        //service.fetchVaccineByCompany("Pfizer & Bion tech").forEach(System.out::println);
		
//		service.fetchVaccineByDosageAndLocation(2, "USA").forEach(System.out::println);
		
	    List<String>list = new ArrayList<String>();
	    list.add("USA");
		
		service.fetchVaccineByLocationNotIn(list).forEach(System.out::println);
		
		System.out.println("************************************************");
		
		List<ResultView> listvaccines = service.fetchVaccineByLocationOrderByName("USA");
		
		listvaccines.forEach(vaccine->{System.out.println("Name is "+vaccine.getName()+" & country is "+vaccine.getLocation());});
		
		System.out.println("************************************************");
		
		service.fetchVaccineByLocation("INDIA", ResultView3.class).forEach(view->{System.out.println(view.getregno()+" "+view.getDosage());});;
		
		context.close();
		
		
	}

}
