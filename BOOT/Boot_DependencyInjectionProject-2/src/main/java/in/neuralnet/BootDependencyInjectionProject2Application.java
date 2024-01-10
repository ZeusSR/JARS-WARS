package in.neuralnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.neuralnet.target.Student;

@SpringBootApplication
public class BootDependencyInjectionProject2Application {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(BootDependencyInjectionProject2Application.class, args);
		
		Student obj = context.getBean(Student.class);
		obj.preparation("ORACLE SpringBOOT");
		
		((ConfigurableApplicationContext)context).close();
	}

}
