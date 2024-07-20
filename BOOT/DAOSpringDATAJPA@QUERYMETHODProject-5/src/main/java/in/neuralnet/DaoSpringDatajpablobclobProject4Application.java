package in.neuralnet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.neuralnet.bo.MarraigeSeeker;
import in.neuralnet.service.IMatrimonyServiceManagement;

@SpringBootApplication
public class DaoSpringDatajpablobclobProject4Application {

	public static void main(String[] args) throws IOException {
		ApplicationContext factory = SpringApplication.run(DaoSpringDatajpablobclobProject4Application.class, args);
		
		IMatrimonyServiceManagement service = factory.getBean(IMatrimonyServiceManagement.class);
		
		
//		InputStream inputstream = new FileInputStream("img.jpeg");
//		 byte[] photoData = new byte[inputstream.available()];
//		inputstream.read(photoData);
//		
//		File file = new File("Implementation_of_MACP.docx");
//		Reader reader = new FileReader(file); 
//		char[] bioDataContent = new char[(int) file.length()]; 
//		reader.read(bioDataContent);
//		
//		MarraigeSeeker seeker = new MarraigeSeeker();
//
//		seeker.setName("Arkene");
//		seeker.setAddress("Mars");
//		seeker.setPhoto(photoData);
//		seeker.setDob(LocalDateTime.of(1993, 1, 3, 20, 15));
//		seeker.setBio(bioDataContent);
//		seeker.setIndian(true);
//		
//		System.out.println(service.registerMarriageSeeker(seeker));
		
		
	/*	Optional<MarraigeSeeker> optional = service.searchSeekerById(1L);
		if (optional.isPresent()) {
			MarraigeSeeker seeker = optional.get();
			System.out.println(
					seeker.getId() + " " + seeker.getName() + " " + seeker.getAddress() + " " + seeker.isIndian());

			OutputStream os = new FileOutputStream("retrieve_image.jpg");
			os.write(seeker.getPhoto());
			os.flush();

			Writer writer = new FileWriter("retrive_biodata.txt");
			writer.write(seeker.getBio());
			writer.flush();

			os.close();
			writer.close();

			System.out.println("LOBS are retrieved...");

		} else {
			System.out.println("Record not available");
		}
		
		
		
		
//		inputstream.close(); 
//		reader.close(); */
		
		
		System.out.println("Custom @Query method outbut is ");
		service.searchByAddress("Mars").forEach(System.out::println);;
		
//		service.updateByAddress("Ratatoulie", "Mars");
		
		
		((ConfigurableApplicationContext) factory).close();
		
		
		
	} 

}
