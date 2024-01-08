package in.neuralnet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.neuralnet.bo.StudentBO;
import in.neuralnet.dao.IStudentdao;
import in.neuralnet.dto.Student;
import in.neuralnet.vo.StudentVO;


@Service("service")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentdao studentdao;
	
	@Override
	public String saveStudent(StudentVO student) {

		
		
		StudentBO bo = new StudentBO();
		Random random = new Random();
		bo.setName(student.getName());
		bo.setSports(student.getSports());
		bo.setAddress(student.getAddress());
		bo.setAmount((float) random.nextInt(100000000 - 12345 + 1));
		
		return studentdao.saveStudent(bo);
	}

	@Override
	public List<Student> findall() {
      
		 List<Student> dto = new ArrayList<Student>();
		 List<StudentBO> bo = studentdao.findall();
		 
		 for(StudentBO boo : bo)
		 {
			 Student st = new Student();
			 st.setReg_id(boo.getReg_id());
			 st.setName(boo.getName());
			 st.setSports(boo.getSports());
			 st.setAddress(boo.getAddress());
			 
			 dto.add(st);
			 
		 }
		
		return dto;
	}

	@Override
	public Student findById(Integer reg_id) {
		
		Student dto = new Student();
		StudentBO bo = studentdao.findById(reg_id);
		dto.setReg_id(bo.getReg_id());
		dto.setName(bo.getName());
		dto.setSports(bo.getSports());
	    dto.setAddress(bo.getAddress());
		
		
		return dto;
	}

	@Override
	public String updateById(Student student) {

		StudentBO bo = new StudentBO();
		bo.setReg_id(student.getReg_id());
		bo.setName(student.getName());
		bo.setSports(student.getSports());
		bo.setAddress(student.getAddress());
		
		
		return studentdao.updateById(bo);
	}

	@Override
	public String deleteById(Integer reg_id) {
		// TODO Auto-generated method stub
		return studentdao.deleteById(reg_id);
	}

}
