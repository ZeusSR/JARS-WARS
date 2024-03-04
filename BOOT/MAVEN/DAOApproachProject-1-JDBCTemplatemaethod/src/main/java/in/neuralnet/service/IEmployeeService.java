package in.neuralnet.service;

import java.util.List;
import java.util.Map;

import in.neuralnet.dto.EmployeeDTO;

public interface IEmployeeService {

	public int fetchEmpscount();
	public String getEmployeeNameByNo(int eno);
	public Map<String,Object> getEmployeeDetailsByNo(int eno);
	public List<Map<String,Object>> getEmployeeDeatilsByDesignation(String desg1,String desg2);
	public int insertEmp(String ename, String eaddress, double salary);
	public int addBonusToEmpByDesg(String desg,double bonus);
	public List<EmployeeDTO> getEmployeeByAddress(String addr1,String addr2);
}
