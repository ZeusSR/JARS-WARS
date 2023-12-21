package in.neuralnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.neuralnet.dto.CustomerDTO;
import in.neuralnet.service.ICustomerMgmtService;
import in.neuralnet.vo.CustomerVo;

@Component("controller")
public class CustomerController {

	@Autowired
	ICustomerMgmtService service;

	static {
		System.out.println("Controller.class file is loading...");
	}

	public CustomerController(ICustomerMgmtService service) {
		System.out.println("MainController:: one param constructor...");
		this.service = service;
	}

	public String processResult(CustomerVo vo) {
		CustomerDTO dto = new CustomerDTO();
		
		dto.setCustomerName(vo.getCustomerName());
		dto.setCustomerAddress(vo.getCustomerAddress());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		
		String result = service.calculateSimpleInterest(dto);
		return result;
	}
}
