package in.neuralnet.controller;

import java.util.List;

import in.neuralnet.vo.StudentVO;

public interface IStudentController {

	
	 String saveStudent(StudentVO student);
	
	 List<StudentVO> findall();
	 
	 StudentVO findById(Integer reg_id);

	String updateById(StudentVO student);

	String deleteById(Integer reg_id);
}
