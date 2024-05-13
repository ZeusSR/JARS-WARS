package in.neuralnet.service;

import in.neuralnet.bo.CovidVaccine;

public interface ICovidService {
	
	public Iterable<CovidVaccine> fetchDetails(boolean asc, String... properties);
	
	public Iterable<CovidVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties);
	
	public void fetchDetailsByPagination(int pageSize);
	
}
