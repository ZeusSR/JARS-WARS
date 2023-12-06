package in.ineuron.bean;

import java.util.Date;
import java.util.Set;

public class ContactsInfo {
	
	private Set<Integer> phonenumbers;
	private Set<Date> dateSet;
	@Override
	public String toString() {
		return "ContactsInfo [phonenumbers=" + phonenumbers + ", dateSet=" + dateSet + "]";
	}
	public ContactsInfo(Set<Integer> phonenumbers, Set<Date> dateSet) {
		super();
		this.phonenumbers = phonenumbers;
		this.dateSet = dateSet;
	}
	
	
	

}
