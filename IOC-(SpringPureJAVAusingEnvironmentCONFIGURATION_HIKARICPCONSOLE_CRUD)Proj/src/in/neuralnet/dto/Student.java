package in.neuralnet.dto;

public class Student {
	
	private Integer reg_id;
	private String name;
	private String Sports;
	private String address;
	
	@Override
	public String toString() {
		return "Student [reg_id=" + reg_id + ", name=" + name + ", Sports=" + Sports + ", address=" + address + "]";
	}

	public Integer getReg_id() {
		return reg_id;
	}

	public void setReg_id(Integer reg_id) {
		this.reg_id = reg_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSports() {
		return Sports;
	}

	public void setSports(String sports) {
		Sports = sports;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
