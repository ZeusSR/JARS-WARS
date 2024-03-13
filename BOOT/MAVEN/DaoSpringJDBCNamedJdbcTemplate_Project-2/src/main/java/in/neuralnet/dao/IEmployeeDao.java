package in.neuralnet.dao;
import java.util.List;

import in.neuralnet.bo.EmployeeBO;


public interface IEmployeeDao {

	public List<EmployeeBO> fetchEmployeesByDesg(String desg1, String desg2, String desg3);

	public int registerEmployee(EmployeeBO bo);
}
