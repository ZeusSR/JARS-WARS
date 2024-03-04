package in.neuralnet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import ch.qos.logback.classic.Logger;
import in.neuralnet.bo.EmployeeBO;
import in.neuralnet.dao.IEmployeeDao;
import in.neuralnet.dto.EmployeeDTO;

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



	@Override
	public List<EmployeeDTO> getEmployeeByAddress(String addr1, String addr2) {
		
		
		List<EmployeeBO> bo = empdao.getEmployeeByAddress(addr1, addr2);
		 List<EmployeeDTO> dto = new ArrayList<EmployeeDTO>();
	
//		 bo.forEach(b->{
//			 EmployeeDTO dt = new EmployeeDTO();
//			 BeanUtils.copyProperties(b, dt);
//			 dto.add(dt);
//		 });
//		
		 System.out.println(bo);
		 
		 while(bo.isEmpty())
		 {EmployeeDTO dt = new EmployeeDTO();
		 BeanUtils.copyProperties(bo, dt);
		 dto.add(dt);
		 }
		 
		return dto;
	}

}
