package in.neuralnet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.neuralnet.service.IEmployeeService;

public class JdbcTemplateDirectMethodTest {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("in/neuralnet/cfg/applicationContext.xml");
	


	 
	IEmployeeService service = context.getBean(IEmployeeService.class);
	
	try {
//		int count = service.fetchEmpscount();
//		System.out.println("No. of records present are : "+count+"\n");
//		
//		System.out.println(service.getEmployeeNameByNo(4));
//		
//		System.out.println(service.getEmployeeDetailsByNo(9));
//		
//		System.out.println(service.getEmployeeDeatilsByDesignation("CSK", "MI"));
//		int c = service.insertEmp("PVSindhu", "IND", 2222.30);
//		System.out.println("No. of rows affected are : "+c);
//		
//		int cnt = service.addBonusToEmpByDesg("CSK", 2004.53);
//		System.out.println("No. of rows affected are : "+cnt);
		
		System.out.println(service.getEmployeeByAddress("CSK", "MI"));
		
		
	} catch (Exception e) {
		
	
		e.printStackTrace();
	}
	finally
	{
	context.close();
	}

	}

}
