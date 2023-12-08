package in.ineuron.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.bean.CSSubjects;

public class TestApp {
    public static void main(String[] args) {

    	 
    	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    	reader.loadBeanDefinitions("/applicationContext.xml");
    	
    	System.out.println(factory.getBean("in.ineuron.bean.CSSubjects#0",CSSubjects.class)+"\n");
    	
    	System.out.println(factory.getBean("in.ineuron.bean.CSSubjects#1",CSSubjects.class)+"\n");
    	
//    	System.out.println(factory.getBean("in.ineuron.bean.CSSubjects#2",CSSubjects.class)+"\n");

    }
}
