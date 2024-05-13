package in.neuralnet.service;

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
@Service
@Transactional
public class CovidServiceImpl implements ICovidService {

	@Autowired
	ICovidRepository repository;

	@Override
	public Iterable<CovidVaccine> fetchDetails(boolean asc, String... properties) {

		System.out.println("Proxy class implementation name is :: "+repository.getClass().getName());
		
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<CovidVaccine> listEntities = repository.findAll(sort);
		return listEntities;
	}

	@Override
	public Iterable<CovidVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC : Direction.DESC, properties);
     	Page<CovidVaccine> page = repository.findAll(pageable);
		return page.getContent();
		
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {

		// total record count
				long count = repository.count();// total = 7

				// deciding pagesCount
				long pagesCount = count / pageSize;// pagesCount = 7/3 = 2
				pagesCount = count % pageSize == 0 ? pagesCount : ++pagesCount; // pagesCount = 3

				for (int i = 0; i < pagesCount; i++) {
					// loop running from 0,1,2
					Pageable pageable = PageRequest.of(i, pageSize);
					Page<CovidVaccine> page = repository.findAll(pageable);
					page.getContent().forEach(System.out::println);
					System.out.println("-------------------" + (i + 1) + " of :: " + page.getTotalPages());
				}
	 
	}
	
}
