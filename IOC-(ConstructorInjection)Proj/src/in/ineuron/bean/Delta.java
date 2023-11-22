package in.ineuron.bean;

public class Delta {
	
	String str = "Hey Buddy...!!!!!";
	
	
	

	@Override
	public String toString() {
		return "Delta [str=" + str + "]";
	}

	static {
		System.out.println("Delta.class file is loading...");
	}

	public Delta() {
		System.out.println("Delta object is instantiated...");
	}

}
