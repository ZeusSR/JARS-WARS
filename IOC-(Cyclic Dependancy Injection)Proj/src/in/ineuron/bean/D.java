package in.ineuron.bean;

public class D {
	
	private C c;
	
	
	static
	{
		System.out.println("D.class Loading.......");
	}
	
	public D()
	{
		System.out.println("D instantiated..");
	}

	public D(C c) {
		super();
		System.out.println("Constructror injection");
		this.c = c;
	}

	@Override
	public String toString() {
		return "D [c=" + c + "]";
	}






}
