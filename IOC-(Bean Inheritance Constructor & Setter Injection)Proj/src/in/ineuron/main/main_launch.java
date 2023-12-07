package in.ineuron.main;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.Car;



public class main_launch {

	public static void main(String[] args) {



		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("cfg/applicationContext.xml");


	    System.out.println(factory.getBean("car1",Car.class));
	    
	    System.out.println(factory.getBean("car2",Car.class));
		
	    System.out.println(factory.getBean("car3",Car.class));


	}
	

}
