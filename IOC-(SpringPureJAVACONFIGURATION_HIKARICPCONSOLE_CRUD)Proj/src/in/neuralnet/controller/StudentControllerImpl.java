package in.neuralnet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.neuralnet.dto.Student;
import in.neuralnet.service.IStudentService;
import in.neuralnet.vo.StudentVO;

@Component("controller")
public class StudentControllerImpl implements IStudentController {

	@Autowired
	private IStudentService studentservice;
	
	@Override
	public String saveStudent(StudentVO student) {
		
		StudentVO vo = new StudentVO();
		
		vo.setName(student.getName());
		vo.setSports(student.getSports());
		vo.setAddress(student.getAddress());
		
		
		return studentservice.saveStudent(vo);
		
		
		
	}

	@Override
	public List<StudentVO> findall() {
		
		List<StudentVO> vo = new ArrayList<StudentVO>();
		
		List<Student> dto = studentservice.findall();
		
		for(Student dtoo : dto)
		{
			StudentVO vo2 = new StudentVO();
			vo2.setReg_id(String.valueOf(dtoo.getReg_id()));
			vo2.setName(dtoo.getName());
			vo2.setSports(dtoo.getSports());
			vo2.setAddress(dtoo.getAddress());
			
			vo.add(vo2);
		}
		
		return vo;
	}

	@Override
	public StudentVO findById(Integer reg_id) {
		
		StudentVO vo = new StudentVO();
	   Student obj = studentservice.findById(reg_id);
	   
	   vo.setReg_id(String.valueOf(obj.getReg_id()));
	   vo.setName(obj.getName());
	   vo.setSports(obj.getSports());
	   vo.setAddress(obj.getAddress());
		
		return vo;
	}

	@Override
	public String updateById(StudentVO student) {
		
		Student dto = new Student();
		dto.setReg_id(Integer.parseInt(student.getReg_id()));
		dto.setName(student.getName());
		dto.setSports(student.getSports());
		dto.setAddress(student.getAddress());
		
		
		return studentservice.updateById(dto);
	}

	@Override
	public String deleteById(Integer reg_id) {
		
		return studentservice.deleteById(reg_id);
	}

}
