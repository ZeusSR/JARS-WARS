package in.ineuron.Test;




import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.Alpha;

public class TestApp {
    public static void main(String[] args) {

    	 
    	   DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    	
    	   
    	  XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    	  
    	  
    	  reader.loadBeanDefinitions("in/neuralnet/config/applicationContext.xml");

    		Alpha generator1 = factory.getBean("ap", Alpha.class);
    		
    		
  
    		
    		System.out.println();
    		
    		Alpha result = generator1.generateWishMessage();
    		System.out.println(result);
    }
}
