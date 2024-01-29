package in.neuralnet.bo;

public class StudentBO {

	
	private Integer reg_id;
	private String name;
	private String Sports;
	private String address;
	private Float Amount;
	@Override
	public String toString() {
		return "StudentBO [reg_id=" + reg_id + ", name=" + name + ", Sports=" + Sports + ", address=" + address
				+ ", Amount=" + Amount + "]";
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
	public Float getAmount() {
		return Amount;
	}
	public void setAmount(Float amount) {
		Amount = amount;
	}
	
	
}
