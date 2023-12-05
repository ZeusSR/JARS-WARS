package in.ineuron.bean;

public class A {

	private B b;

	static
	{
		System.out.println("A.class Loading.......");
	}
	
	public A()
	{
		System.out.println("A instantiated..");
	}


	@Override
	public String toString() {
		return "A [b=" + b + "]";
	}



	public void setB(B b) {
		this.b = b;
	}
}
