package in.neuralnet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.neuralnet.bo.MarraigeSeeker;

public interface IMarraigeSeekerManagementDao extends JpaRepository<MarraigeSeeker, Long> {

}
