package in.neuralnet.dao;

import org.springframework.data.repository.CrudRepository;

import in.neuralnet.bo.CovidVaccine;
public interface ICovidRepository extends CrudRepository<CovidVaccine, Long> {

}
