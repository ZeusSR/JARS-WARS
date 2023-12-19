package in.neuralnet.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "fpkt")
@Scope("prototype")
@PropertySource(value = "in/neuralnet/properties")
public class Flipkart {

	
	static
	{
		System.out.println("Flipkart.class Loading...");
	}
	@Autowired
	@Qualifier("b")
	private Courier courier;
	
	@Autowired
	private Date date; //For Autowiring we have to define the bean in xml as it is a pre-defined class.
	
	@Value(value = "${fpkt.info.discount}")
	private int discount;
	
	@Value(value = "${fpkt.info.url}")
	private String url;
	
	@Value(value = "${Path}")
	private String PathValue;
	
	@Value(value = "${os}")
	private String OS;
	
	public Flipkart() {
		super();
		
		System.out.println("Flipkart.class instantiated...");
	}


	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + "]";
	}





	public String Shopping(String[] items, float[] prices)
	{
		System.out.println("\nFlipkart.shopping()");
		System.out.println(courier.getClass().getName());
		System.out.println("Date is : "+date);
		System.out.println("Discount is :"+discount);
		System.out.println("From URL :"+url+"\n");
		
		
		System.out.println(PathValue);
		System.out.println(OS);
		Random random = null;
		float billAmt = 0.0f;
		int oid = 0;
		for (float price : prices) {
			billAmt += price;
		}
		random = new Random();
		oid = random.nextInt(1000);
		String msg = courier.deliver(oid);

		return Arrays.toString(items) + "are purchase having prices " + Arrays.toString(prices)
				+ " with the bill amount :: " + billAmt + "---> " + msg;
	}
}
