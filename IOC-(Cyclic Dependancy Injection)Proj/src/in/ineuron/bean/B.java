package in.ineuron.bean;

public class B {
	
	private A a;
	
	
	static
	{
		System.out.println("B.class Loading.......");
	}
	
	public B()
	{
		System.out.println("B instantiated..");
	}


	@Override
	public String toString() {
		return "B [a=" + a + "]";
	}



	public void setA(A a) {
		this.a = a;
	}

}
