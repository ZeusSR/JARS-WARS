package in.ineuron.Test;



import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.WishMessgeGenerator;
@SuppressWarnings("deprecation")
public class TestApp {
    public static void main(String[] args) {

    	
    	

    		//using the FileSystemResource to locate the configuration file
    		FileSystemResource resource = new FileSystemResource("./src/applicationContext.xml");

    		// Creating an IOC container
    		XmlBeanFactory factory = new XmlBeanFactory(resource);

    		//Requesting IOC container to give the objectsearching 
//    		will happen in cache and if it is not found then 
    		WishMessgeGenerator generator1 = factory.getBean("wmg", WishMessgeGenerator.class);


        //    		To Show Caching Property of IOC Container
//    		factory.destroySingletons();
    		System.out.println();
    		
    		//Searching will happen in cache, it is found so get it from cache only.
    		WishMessgeGenerator generator2= factory.getBean("wmg", WishMessgeGenerator.class);
    		
    		
    		System.out.println("Generator1 class object reference :: "+generator1.hashCode());
    		System.out.println("Generator2 class object reference :: "+generator2.hashCode());
    		
    		System.out.println();
    		
    		//using the target object performing the operation and printing the result
    		String result = generator1.generateWishMessage("Indra");
    		System.out.println(result);
    }
}
