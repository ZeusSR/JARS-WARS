package in.neuralnet.dao;

import java.util.List;

import in.neuralnet.bo.StudentBO;

public interface IStudentdao {

	
	 String saveStudent(StudentBO student);
	
	 List<StudentBO> findall();
	 
	 StudentBO findById(Integer reg_id);

	String updateById(StudentBO student);

	String deleteById(Integer reg_id);
}
