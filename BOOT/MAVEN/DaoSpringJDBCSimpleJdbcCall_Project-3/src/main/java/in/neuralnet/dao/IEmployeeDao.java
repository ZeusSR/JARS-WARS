package in.neuralnet.dao;
import java.util.List;

import in.neuralnet.bo.EmployeeBO;
import in.neuralnet.dto.EmployeeDTO;


public interface IEmployeeDao {

	public List<EmployeeBO> fetchEmployeesByDesg(String desg1, String desg2, String desg3);

	public int registerEmployee(EmployeeBO bo);
	
	public List<EmployeeBO> fetchEmployeesByAddr(String addr1, String addr2);
}
