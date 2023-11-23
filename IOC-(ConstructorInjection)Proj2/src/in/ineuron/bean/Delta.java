package in.ineuron.bean;

public class Delta {
	
	String str ;
	Integer int_num;
	
	
	
	
	


	

	public Delta(String str, Integer int_num) {
		super();
		this.str = str;
		this.int_num = int_num;
	}

	@Override
	public String toString() {
		return "Delta [str=" + str + ", int_num=" + int_num + "]";
	}

	static {
		System.out.println("Delta.class file is loading...");
	}

	public Delta() {
		System.out.println("Delta object is instantiated...");
	}

}
