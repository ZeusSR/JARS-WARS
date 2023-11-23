package in.ineuron.bean;



//Target class-----> UserDefined
public class Alpha {

	// Dependent class ---> Predefined
	private Delta del;
	







	public Alpha(Delta del) {
		
		System.out.println("Constuctor Injection happening");
		
		this.del = del;
		
	}




	@Override
	public String toString() {
		return "Alpha [del=" + del +"]";
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
