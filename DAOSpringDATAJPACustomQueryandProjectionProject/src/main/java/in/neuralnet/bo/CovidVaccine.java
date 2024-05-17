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

	
	
	




	
	

}
