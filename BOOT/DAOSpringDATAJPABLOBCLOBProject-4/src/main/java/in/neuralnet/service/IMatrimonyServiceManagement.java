package in.neuralnet.service;

import java.util.Optional;

import in.neuralnet.bo.MarraigeSeeker;

public interface IMatrimonyServiceManagement {

	public String registerMarriageSeeker(MarraigeSeeker seeker);
	public Optional<MarraigeSeeker> searchSeekerById(Long id);
}
