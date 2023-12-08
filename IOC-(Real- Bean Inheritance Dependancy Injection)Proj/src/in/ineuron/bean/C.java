package in.ineuron.bean;

public class C {

	private D d;

	static
	{
		System.out.println("C.class Loading.......");
	}
	
	public C()
	{
		System.out.println("C instantiated..");
	}

	@Override
	public String toString() {
		return "C [d=" + d + "]";
	}

	public C(D d) {
		super();
		System.out.println("Constructror injection");
		this.d = d;
	}









}
