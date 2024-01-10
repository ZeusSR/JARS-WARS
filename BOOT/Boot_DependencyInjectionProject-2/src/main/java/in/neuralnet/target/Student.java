package in.neuralnet.target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import in.neuralnet.dependent.ICourseMaterial;

@Component("student")
public class Student {

	static {
		System.out.println("Student.class file is loading...");
	}

	public Student() {
		System.out.println("Student Object is instantiated...");
	}

	@Autowired
	@Qualifier("java")
	private ICourseMaterial material;
	
	public void preparation(String examName) {
		System.out.println("Preparation started for :: " + examName);
		String courseContent = material.courseContent();
		double price = material.price();
		System.out.println("Prepartion is going on using :: " + courseContent + " material with price :: " + price);
		System.out.println("Preparation completed for :: " + examName);
	}
}
