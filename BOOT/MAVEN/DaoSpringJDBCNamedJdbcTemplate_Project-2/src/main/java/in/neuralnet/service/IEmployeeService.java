package in.neuralnet.service;

import java.util.List;


import in.neuralnet.dto.EmployeeDTO;

public interface IEmployeeService {
	
	public List<EmployeeDTO> fetchEmployeesByDesg(String desg1, String desg2, String desg3);

	public String registerEmployee(EmployeeDTO dto);
}
