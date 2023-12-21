package in.neuralnet.service;

import in.neuralnet.dto.CustomerDTO;

public interface ICustomerMgmtService {

	public abstract String calculateSimpleInterest(CustomerDTO dto);
}
