package in.neuralnet.service;

import in.neuralnet.bo.CovidVaccine;

public interface ICovidService {
	
	public String registerVaccine(CovidVaccine vaccine);
	
	public Iterable<CovidVaccine> registerInBatch(Iterable<CovidVaccine> vaccines);

	public Long getVaccineCount();
	
	public Iterable<CovidVaccine> getAllVaccinesDetails();
	
}
