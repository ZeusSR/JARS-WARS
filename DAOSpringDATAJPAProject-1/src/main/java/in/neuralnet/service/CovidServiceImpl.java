package in.neuralnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.neuralnet.bo.CovidVaccine;
import in.neuralnet.dao.ICovidRepository;
@Service
@Transactional
public class CovidServiceImpl implements ICovidService {

	@Autowired
	ICovidRepository repository;
	
	@Override
	public String registerVaccine(CovidVaccine vaccine) {
		
		System.out.println("Proxy class name: "+repository.getClass().getName());
		
		CovidVaccine a = null;
		if(vaccine !=null)
		{
			a  = repository.save(vaccine);
		}
		
		return a!=null?"Vaccine registered successfully":"not registered for regno. : "+vaccine.getRegno();

	}

	@Override
	public Iterable<CovidVaccine> registerInBatch(Iterable<CovidVaccine> vaccines) {
		if (vaccines != null)
			return repository.saveAll(vaccines); 
		else
			throw new IllegalArgumentException("batch insertion not done...");
	}

	@Override
	public Long getVaccineCount() {
		
		return repository.count(); 
	}

	@Override
	public Iterable<CovidVaccine> getAllVaccinesDetails() {
		
		return repository.findAll();
	}
}
