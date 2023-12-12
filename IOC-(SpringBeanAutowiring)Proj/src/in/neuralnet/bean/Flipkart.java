package in.neuralnet.bean;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {

	
	static
	{
		System.out.println("Flipkart.class Loading...");
	}
	
	private Courier courier;
	
	
	
	
	
	public Courier getCourier() {
		return courier;
	}





	public void setCourier(Courier courier) {
		
		System.out.println("Setter injection by: "+courier.getClass().getName());
		this.courier = courier;
	}





	public Flipkart() {
		super();
		
		System.out.println("Flipkart.class instantiated...");
	}





	public Flipkart(Courier courier) {
		super();
		
		System.out.println("Parameterised Constructor injection by: "+courier.getClass().getName());
		this.courier = courier;
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
