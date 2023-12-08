package in.ineuron.bean;

import java.util.Set;

public class CSSubjects {

	static
	{
		System.out.println("CSSubjects.class loded\n");
	}
	
	public CSSubjects()
	{
		System.out.println("CSSubjects.class Instantiation....");
	}
	
	
	private Set<String> subjects;
	private Integer semester;

	public Set<String> getSubjects() {
		return subjects;
	}


	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}


	public Integer getSemester() {
		return semester;
	}


	public void setSemester(Integer semester) {
		this.semester = semester;
	}


	@Override
	public String toString() {
		return "CSSubjects [subjects=" + subjects + ", semester=" + semester + "]";
	}



	
	
	
	
}
