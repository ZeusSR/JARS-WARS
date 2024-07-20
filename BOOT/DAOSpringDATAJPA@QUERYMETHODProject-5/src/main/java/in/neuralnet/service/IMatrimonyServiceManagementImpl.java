package in.neuralnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.neuralnet.bo.MarraigeSeeker;
import in.neuralnet.dao.IMarraigeSeekerManagementDao;
import jakarta.transaction.Transactional;

@Service
public class IMatrimonyServiceManagementImpl implements IMatrimonyServiceManagement {

	@Autowired
	private IMarraigeSeekerManagementDao repo;
	
	@Override
	public String registerMarriageSeeker(MarraigeSeeker seeker) {
		// TODO Auto-generated method stub
		return "Marraigeseeker saved with id is : "+repo.save(seeker).getId();
	}

	@Override
	public Optional<MarraigeSeeker> searchSeekerById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<String> searchByAddress(String address) {
		return repo.searchByAddress(address);
	}

	@Transactional
	@Override
	public void updateByAddress(String name, String address) {
		// TODO Auto-generated method stub
		repo.updateByAddress(name, address);
	}

}
