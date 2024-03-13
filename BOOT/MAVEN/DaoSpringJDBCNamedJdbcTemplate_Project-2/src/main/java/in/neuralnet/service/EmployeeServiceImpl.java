package in.neuralnet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.neuralnet.bo.EmployeeBO;
import in.neuralnet.dao.IEmployeeDao;
import in.neuralnet.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public List<EmployeeDTO> fetchEmployeesByDesg(String desg1, String desg2, String desg3) {

		List<EmployeeBO> employeeBO = dao.fetchEmployeesByDesg(desg1, desg2, desg3);

		List<EmployeeDTO> empDTO = new ArrayList<EmployeeDTO>();
		employeeBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			empDTO.add(dto);
		});
		return empDTO;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		
		return dao.registerEmployee(bo)==1 ? " row inserted succesfully" :"record insertion failed";
	}

}
