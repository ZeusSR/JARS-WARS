package in.neuralnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.neuralnet.BO.CustomerBO;
import in.neuralnet.dao.ICustomerDAO;
import in.neuralnet.dto.CustomerDTO;

@Service("service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	static
	{
		System.out.println("CustomerMgmtServiceImpl.class Loading");
	}
	@Autowired
	private ICustomerDAO dao;
	
	@Override
	public String calculateSimpleInterest(CustomerDTO dto) {
		
		String result = null;
		Float interest_floatamnt = 0.0f;
		
		interest_floatamnt = (dto.getPamt()*dto.getRate()*dto.getTime())/100;
		
		CustomerBO bo = new CustomerBO();
		
		bo.setCustomerName(dto.getCustomerName());
		bo.setCustomerAddress(dto.getCustomerAddress());
		bo.setInterestAmt(interest_floatamnt);
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setPamt(dto.getPamt());
		
		int count = dao.insert(bo);
		
		if(count == 0)
		{
			result = "Not inserted succesfully";
			
		}else if(count == 1)
		{
			result = "Inserted succesfully";
			
		}
		
		
		return result;
	}

	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		
		super();
		System.out.println("CustomerMgmtServiceImpl:: One param constructor..");
		
		this.dao = dao;
	}
	
	

}
