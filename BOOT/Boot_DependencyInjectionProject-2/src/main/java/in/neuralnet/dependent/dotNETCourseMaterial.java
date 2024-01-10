package in.neuralnet.dependent;

import org.springframework.stereotype.Component;

@Component("dot")
public class dotNETCourseMaterial implements ICourseMaterial {

	static {
		System.out.println("dotNETCourseMaterial.class file is loading...");
	}

	public dotNETCourseMaterial() {
		System.out.println("dotNETCourseMaterial:: Zero param constructor...");
	}
	
	@Override
	public String courseContent() {
		System.out.println("dotNETCourseMaterial CourseContent");
		return "1. ASP.NET 2. ExceptionHandling 3.ODBC";
	}

	@Override
	public double price() {
		System.out.println("dotNETCourseMaterial.price()");
		return 500;
	}

}
