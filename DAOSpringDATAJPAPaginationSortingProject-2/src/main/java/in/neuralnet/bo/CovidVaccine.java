package in.neuralnet.bo;

import java.io.Serializable;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "covid_registration")
public class CovidVaccine implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regno;
	
	private String name;
	
	private String company;
	
	private String location;
	
	private double price;
	
	private Integer dosage;

	
	
	
//	public CovidVaccine() {
//		super();
//	}
//
//	public CovidVaccine(Long regno, String name, String company, String location, double price, Integer dosage) {
//		super();
//		this.regno = regno;
//		this.name = name;
//		this.company = company;
//		this.location = location;
//		this.price = price;
//		this.dosage = dosage;
//	}
//
//	@Override
//	public String toString() {
//		return "CovidVaccine [regno=" + regno + ", name=" + name + ", company=" + company + ", location=" + location
//				+ ", price=" + price + ", dosage=" + dosage + "]";
//	}
//
//	public Long getRegno() {
//		return regno;
//	}
//
//	public void setRegno(Long regno) {
//		this.regno = regno;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCompany() {
//		return company;
//	}
//
//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public Integer getDosage() {
//		return dosage;
//	}
//
//	public void setDosage(Integer dosage) {
//		this.dosage = dosage;
//	}



	
	

}
