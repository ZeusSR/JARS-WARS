package in.neuralnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.neuralnet.bo.CovidVaccine;
import in.neuralnet.dao.ICovidRepository;
import type.DynamicView;
import type.ResultView;
@Service
@Transactional
public class CovidServiceImpl implements ICovidService {

	@Autowired
	ICovidRepository repository;

	@Override
	public List<CovidVaccine> fetchVaccineByCompany(String company) {
		
		List<CovidVaccine> listentities = repository.findByCompany(company);
		
		return listentities;
	}

	@Override
	public List<CovidVaccine> fetchVaccineByDosageAndLocation(Integer dose, String loc) {
		
		return repository.findByDosageAndLocation(dose, loc);
	}

	@Override
	public List<CovidVaccine> fetchVaccineByLocationNotIn(List<String> company) {
		// TODO Auto-generated method stub
		return repository.findByLocationNotIn(company);
	}

	@Override
	public List<ResultView> fetchVaccineByLocationOrderByName(String location) {
		System.out.println("Proxy class is : "+repository.getClass().getName());
		return repository.findByLocationOrderByName(location);
	}

	@Override
	public <T extends DynamicView> List<T> fetchVaccineByLocation(String location, Class<T> claz) {
		
		System.out.println("Proxy class: "+repository.getClass().getName());
		return repository.findByLocationOrderByRegnoDesc(location, claz);
	}

	 
	
	
}
