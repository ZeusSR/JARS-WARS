package in.neuralnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.neuralnet.dto.EmployeeDTO;
import in.neuralnet.service.IEmployeeService;

@SpringBootApplication
public class DaoSpringJdbcSimpleJdbcCall {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(DaoSpringJdbcSimpleJdbcCall.class, args);
		
		
		IEmployeeService service = context.getBean(IEmployeeService.class);
		
//		System.out.println(service.fetchEmployeesByDesg("CSK", "MI", "IND"));
//		
//		EmployeeDTO dto = new EmployeeDTO();
//		dto.setS_name("Y. Jaiswal");
//		dto.setS_address("RR");
//		dto.setD_salary(2990.45);
//		System.out.println(service.registerEmployee(dto));
		
		
		service.fetchEmployeesByAddr("CSK","MI").forEach(System.out::println);
		
	}

}
