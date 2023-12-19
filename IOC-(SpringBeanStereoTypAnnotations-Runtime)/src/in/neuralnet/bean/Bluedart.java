package in.neuralnet.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value="bDart")
@Lazy
public class Bluedart implements Courier {

	static {
		System.out.println("BlueDart.class file is loading...");
	}

	public Bluedart() {
		System.out.println("BlueDart object is instantiated...");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");

		return "BlueDart courier will deliver with the order id ::" + oid + " order products";
	}

}
