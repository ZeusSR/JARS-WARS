package in.neuralnet.dao;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.CrudRepository;


import in.neuralnet.bo.CovidVaccine;
//public interface ICovidRepository extends PagingAndSortingRepository<CovidVaccine, Long> {

public interface ICovidRepository extends CrudRepository<CovidVaccine, Long> {

}
