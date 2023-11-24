package in.ineuron.Test;



import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.A;
@SuppressWarnings("deprecation")
public class TestApp2 {
    public static void main(String[] args) {

    	
    	

    		//using the FileSystemResource to locate the configuration file
    		FileSystemResource resource = new FileSystemResource("./src/applicationContext.xml");

    		// Creating an IOC container
    		XmlBeanFactory factory = new XmlBeanFactory(resource);

    		//Requesting IOC container to give the objectsearching 
//    		will happen in cache and if it is not found then 
    		A generator1 = factory.getBean("c1", A.class);
    		
//    		To Show Caching Property of IOC Container
//    		factory.destroySingletons();
    		
    		System.out.println();
    		

    		
    		
    		System.out.println("Generator1 class object reference :: "+generator1.hashCode());

    		
    		System.out.println();
    		
    		//using the target object performing the operation and printing the result
    		
    		System.out.println(generator1);
    }
}
