package in.ineuron.main;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.College;
import in.ineuron.bean.ContactsInfo;
import in.ineuron.bean.MarksInfo;
import in.ineuron.bean.UniversityInfo;


public class main_launch {

	public static void main(String[] args) {



		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("cfg/applicationContext.xml");


		// Array object is injected
		MarksInfo marksInfo = factory.getBean("marksInfo", MarksInfo.class);
		System.out.println(marksInfo);
		
		System.out.println("-------------------------\n");
		
		College college = factory.getBean("college",College.class);
		System.out.println(college);
		
		System.out.println("-------------------------\n");
		
		ContactsInfo contact = factory.getBean("contact",ContactsInfo.class);
		System.out.println(contact);
		

		System.out.println("-------------------------\n");
		
		UniversityInfo university_info = factory.getBean("university",UniversityInfo.class);
		System.out.println(university_info);
		


	}
	

}
