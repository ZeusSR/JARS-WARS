package in.neuralnet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.neuralnet.bo.MarraigeSeeker;

public interface IMarraigeSeekerManagementDao extends JpaRepository<MarraigeSeeker, Long> {
	
	@Query("SELECT name FROM MarraigeSeeker where address=:address")
	public List<String> searchByAddress(@Param("address") String address);
	
	@Modifying
	@Query("UPDATE MarraigeSeeker SET name=:name where address=:address")
	public void updateByAddress(String name,String address);

}
