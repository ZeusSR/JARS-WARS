package in.neuralnet.service;

import java.util.List;
import java.util.Map;

import in.neuralnet.dao.IEmployeeDao;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao empdao;
	
	
	
	public EmployeeServiceImpl(IEmployeeDao empdao) {
		super();
		this.empdao = empdao;
	}



	@Override
	public String toString() {
		return "EmployeeServiceImpl [empdao=" + empdao + "]";
	}



	@Override
	public int fetchEmpscount() {
		
		
	
		return empdao.fetchEmpscount();
		
	}



	@Override
	public String getEmployeeNameByNo(int eno) {
		
		return empdao.getEmployeeNameByNo(eno);
	}



	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		return empdao.getEmployeeDetailsByNo(eno);
	}



	@Override
	public List<Map<String, Object>> getEmployeeDeatilsByDesignation(String desg1, String desg2) {
		
		return empdao.getEmployeeDeatilsByDesignation(desg1, desg2);
	}



	@Override
	public int insertEmp(String ename, String eaddress, double salary) {
		
		return empdao.insertEmp(ename, eaddress, salary);
	}



	@Override
	public int addBonusToEmpByDesg(String desg, double bonus) {
		// TODO Auto-generated method stub
		return empdao.addBonusToEmpByDesg(desg, bonus);
	}

}
