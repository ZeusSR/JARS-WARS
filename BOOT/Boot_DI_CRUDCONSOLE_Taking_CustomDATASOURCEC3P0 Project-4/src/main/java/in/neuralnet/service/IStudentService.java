package in.neuralnet.service;

import java.util.List;

import in.neuralnet.dto.Student;
import in.neuralnet.vo.StudentVO;

public interface IStudentService {

	
	 String saveStudent(StudentVO student);
	
	 List<Student> findall();
	 
	 Student findById(Integer reg_id);

	String updateById(Student student);

	String deleteById(Integer reg_id);
}
