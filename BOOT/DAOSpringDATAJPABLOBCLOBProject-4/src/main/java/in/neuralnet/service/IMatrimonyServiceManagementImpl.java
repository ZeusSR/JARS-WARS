package in.neuralnet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.neuralnet.bo.MarraigeSeeker;
import in.neuralnet.dao.IMarraigeSeekerManagementDao;

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

}
