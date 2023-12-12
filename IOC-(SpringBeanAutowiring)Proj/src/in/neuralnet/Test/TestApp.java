package in.neuralnet.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.neuralnet.bean.Flipkart;


public class TestApp {
    public static void main(String[] args) {

    	 
    	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    	reader.loadBeanDefinitions("/applicationContext.xml");
    	

		Flipkart flipkart = factory.getBean("fpkt", Flipkart.class);
		System.out.println(flipkart.Shopping(new String[] { "fossil", "puma", "iphone" },
				new float[] { 35000.5f, 56000.0f, 75000.35f }));
    	

    }
}
