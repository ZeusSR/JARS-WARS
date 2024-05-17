package in.neuralnet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import in.neuralnet.bo.CovidVaccine;
import type.DynamicView;
import type.ResultView;

public interface ICovidRepository extends JpaRepository<CovidVaccine, Long> {

	public List<CovidVaccine> findByCompany(String company);
	
	public List<CovidVaccine> findByDosageAndLocation(Integer dosage,String location);
	
	public List<CovidVaccine> findByLocationNotIn(List<String> location);
	
	public List<ResultView> findByLocationOrderByName(String location);
	
	public <T extends DynamicView> List<T> findByLocationOrderByRegnoDesc(String location, Class<T> claz);
}
