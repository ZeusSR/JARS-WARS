package in.neuralnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.neuralnet.dto.EmployeeDTO;
import in.neuralnet.service.IEmployeeService;

@SpringBootApplication
public class DaoSpringJdbcNamedJdbcTemplateProject2Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(DaoSpringJdbcNamedJdbcTemplateProject2Application.class, args);
		
		
		IEmployeeService service = context.getBean(IEmployeeService.class);
		
		System.out.println(service.fetchEmployeesByDesg("CSK", "MI", "IND"));
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setS_name("KL Rahul");
		dto.setS_address("LSG");
		dto.setD_salary(3390.45);
		System.out.println(service.registerEmployee(dto));
		
	}

}
