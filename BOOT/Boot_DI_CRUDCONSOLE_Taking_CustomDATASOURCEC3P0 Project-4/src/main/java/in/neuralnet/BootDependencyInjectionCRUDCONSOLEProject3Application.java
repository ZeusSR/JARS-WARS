package in.neuralnet;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import java.io.BufferedReader;
import in.neuralnet.controller.IStudentController;
import in.neuralnet.vo.StudentVO;



@SpringBootApplication
public class BootDependencyInjectionCRUDCONSOLEProject3Application {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(BootDependencyInjectionCRUDCONSOLEProject3Application.class, args);
		
        IStudentController studentcontroller = null;
		
		
      	studentcontroller = context.getBean( IStudentController.class);
		
		StudentVO student = null;
		List<StudentVO> students = null;
		String name = null;
		String Sports = null;
		String Address = null;
		
		
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Bean id are :: "+Arrays.toString(context.getBeanDefinitionNames())+"\n");
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. READ_ALL");
				System.out.println("6. EXIT");
				System.out.print("Your Option :: [1,2,3,4,5,6]:: ");
				Integer option = Integer.parseInt(br.readLine());

				

				String status;
				int id;
				StudentVO studentRecord;
				switch (option) {
				case 1:
					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the sports:: ");
					Sports = br.readLine();

					System.out.print("Enter the address:: ");
					Address = br.readLine();
					
					student = new StudentVO();
					
					student.setName(name);
					student.setSports(Sports);
					student.setAddress(Address);
					

					status = studentcontroller.saveStudent(student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record inserted succesfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record insertion failed...");
					} else {
						System.out.println("Some problem occured...");
					}
					break;
				case 2:
					System.out.print("Enter the id:: ");
					id = Integer.parseInt(br.readLine());
					studentRecord = studentcontroller.findById(id);
					if (studentRecord != null)
						System.out.println(studentRecord);
					else
						System.out.println("Record not available for the given id ::" + id);
					break;
				case 3:
					System.out.print("Enter the id of the record to be updated:: ");
					id = Integer.parseInt(br.readLine());
					studentRecord = studentcontroller.findById(id);
					if (studentRecord != null) {
						System.out.print("Enter the name:: ");
						name = br.readLine();

						System.out.print("Enter the sports:: ");
						Sports = br.readLine();

						System.out.print("Enter the address:: ");
						Address = br.readLine();
						
						
						
						studentRecord.setName(name);
						studentRecord.setSports(Sports);
						studentRecord.setAddress(Address);
						
                         System.out.println(studentRecord);
                         
						status = studentcontroller.updateById(studentRecord);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Record updated succesfully...");
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed...");
						} else {
							System.out.println("Some problem occured...");
						}
					
					}else
						System.out.println("Record not available for the given id ::" + id);
					break;
				case 4:
					System.out.print("Enter the id to be deleted :: ");
					id = Integer.parseInt(br.readLine());
					studentRecord = studentcontroller.findById(id);
					if (studentRecord != null) {
					status = studentcontroller.deleteById(id);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted succesfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record deletion failed...");
					}	

					}else
						System.out.println("Record not available for the given id ::" + id);
					break;
					
				case 5:	
					
					students = studentcontroller.findall();
					students.forEach(System.out::println);
					
					break;
			
				case 6:
					System.out.println("Thanks for using the application");
					System.exit(0);

				default: 
					System.out.println("Plz enter the option like 1,2,3,4,5 for operation");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		((ConfigurableApplicationContext)context).close();
	}

}
