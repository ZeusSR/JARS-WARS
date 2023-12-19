package in.neuralnet.bean;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "fpkt")
@Scope("prototype")
public class Flipkart {

	
	static
	{
		System.out.println("Flipkart.class Loading...");
	}
	@Autowired
	@Qualifier("xprs")
	private Courier courier;
	
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
		System.out.println("Flipkart.shopping()");
		System.out.println(courier.getClass().getName());
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
