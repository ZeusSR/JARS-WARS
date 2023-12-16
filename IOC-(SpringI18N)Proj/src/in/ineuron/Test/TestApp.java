package in.ineuron.Test;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {

    	try (ClassPathXmlApplicationContext applicationcontext = new ClassPathXmlApplicationContext("cfg/applicationContext.xml")) {
			
    		Locale locle = new Locale("hi", "IN");
			
			String cap1 = applicationcontext.getMessage("btn1.cap", new String[] {"Zeus"}, "msg1", locle);
			
			System.out.println(cap1);
			
			System.out.println(applicationcontext.getMessage("btn1.cap",null,new Locale("en","US")));
			System.out.println(applicationcontext.getMessage("btn2.cap",null,new Locale("hi","IN")));
			System.out.println(applicationcontext.getMessage("btn2.cap",null,new Locale("fr","FR")));
		}
    	

    }
}
