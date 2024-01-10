package in.neuralnet;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import in.neuralnet.component.WishMessageGenerator;

@SpringBootApplication
@Scope("singleton")
public class BootProjectDependencyInjection1Application {
	
	static {
		
		System.out.println("BootProjectDependencyInjection1Application.class Loading");
	}
	
	

	public BootProjectDependencyInjection1Application() {
		
		System.out.println("Zero param constructor::BootProjectDependencyInjection1Application.class instantiated...");
	}

	@Bean
	public LocalDateTime createLocalDateTimeObj() {
		System.out.println("BootProj01DependancyInjectionApplication.createLocalDateTimeObj()");
		LocalDateTime ldt = LocalDateTime.now();
		return ldt;
	}


	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(BootProjectDependencyInjection1Application.class, args);
		
		System.out.println("****Container stared******\n");
		System.out.println("Implementation class is :: ::"+context.getClass().getName());
		
		WishMessageGenerator obj = context.getBean(WishMessageGenerator.class);	
		System.out.println(obj.generateWishMessage("Zeus"));
		
		System.out.println("Bean id are :: "+Arrays.toString(context.getBeanDefinitionNames())+"\n");
		context.close();
		System.out.println("\n*****Container stopped*******");
	
	}

}
