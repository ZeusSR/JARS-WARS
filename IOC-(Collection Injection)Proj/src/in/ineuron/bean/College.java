package in.ineuron.bean;


import java.util.Date;
import java.util.List;

public class College {
	
	private List<String> nameList;
	
	private List<Date> dateList;

	@Override
	public String toString() {
		return "College [nameList=" + nameList + ", dateList=" + dateList + "]";
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<Date> getDateList() {
		return dateList;
	}

	public void setDateList(List<Date> dateList) {
		this.dateList = dateList;
	}
	
	

}
