package in.neuralnet.Test;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.neuralnet.bean.Flipkart;


public class TestApp {
    public static void main(String[] args) {

    	 
    	ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
    	

		Flipkart flipkart = factory.getBean("fpkt", Flipkart.class);
		System.out.println(flipkart.Shopping(new String[] { "fossil", "puma", "iphone" },
				new float[] { 35000.5f, 56000.0f, 75000.35f }));
    	
		factory.close();

    }
}
