package in.ineuron.bean;



//Target class-----> UserDefined
public class Alpha {

	// Dependent class ---> Predefined
	private Delta del;
	private Integer i = 24;







	public Alpha(Delta del, Integer i) {
		
		System.out.println("Constuctor Injection happening");
		
		this.del = del;
		this.i = i;
	}




	@Override
	public String toString() {
		return "Alpha [del=" + del + ", i=" + i + "]";
	}



	static {
		System.out.println("Alpha.class file is loading...");
	}

	public Alpha() {
		System.out.println("Alpha object is instantiated...");
	}

	

	// BUISNESS logic to use Injected DATE in the Target class Object
	public Alpha generateWishMessage() {
		
		return this;
		
	}
}
