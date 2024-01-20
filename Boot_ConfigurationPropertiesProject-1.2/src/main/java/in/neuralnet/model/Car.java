package in.neuralnet.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix= "org.car")
public class Car {

	private Integer engineno;
	
	private String Name;
    
	public Features getFeature() {
		return feature;
	}

	public void setFeature(Features feature) {
		this.feature = feature;
	}

	private Features feature;


	@Override
	public String toString() {
		return "Car [engineno=" + engineno + ", Name=" + Name + ", feature=" + feature + "]";
	}

	public Integer getEngineno() {
		System.out.println("Car.getEngineno()");
		return engineno;
	}

	public void setEngineno(Integer engineno) {
		System.out.println("Car.setEngineno()");
		this.engineno = engineno;
	}

	public String getName() {
		
		System.out.println("Car.getName()");
		return Name;
	}

	public void setName(String name) {
		
		System.out.println("Car.setName()");
		Name = name;
	}
	
	
	
}
