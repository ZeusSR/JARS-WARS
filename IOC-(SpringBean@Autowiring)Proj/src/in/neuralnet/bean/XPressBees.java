package in.neuralnet.bean;

public class XPressBees implements Courier {

	static {
		System.out.println("XPressBees.class file is loading...");
	}

	public XPressBees() {
		System.out.println("XPressBees object is instantiated...");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("XPressBees.deliver()");

		return "XPressBees courier will deliver with the order id ::" + oid + " order products";
	}
}
