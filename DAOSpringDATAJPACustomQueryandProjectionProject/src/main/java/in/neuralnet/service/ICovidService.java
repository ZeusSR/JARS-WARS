package in.neuralnet.service;

import java.util.List;

import in.neuralnet.bo.CovidVaccine;
import type.DynamicView;
import type.ResultView;

public interface ICovidService {
	
 public List<CovidVaccine> fetchVaccineByCompany(String company);
 
 public List<CovidVaccine> fetchVaccineByDosageAndLocation(Integer dose,String loc);
 
 public List<CovidVaccine> fetchVaccineByLocationNotIn(List<String> loc);
 
 public List<ResultView> fetchVaccineByLocationOrderByName(String location);
	
 public <T extends DynamicView> List<T> fetchVaccineByLocation(String location, Class<T> claz);
}
