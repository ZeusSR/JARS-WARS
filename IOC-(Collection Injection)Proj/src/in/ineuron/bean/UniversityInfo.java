package in.ineuron.bean;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UniversityInfo {

	private Map<Integer, String> facultyDetails;
	private Map<String, Date> dateInfo;

	private Properties technologies;

	@Override
	public String toString() {
		return "UniversityInfo [facultyDetails=" + facultyDetails + ", dateInfo=" + dateInfo + ", technologies="
				+ technologies + "]";
	}

	public Map<Integer, String> getFacultyDetails() {
		return facultyDetails;
	}

	public void setFacultyDetails(Map<Integer, String> facultyDetails) {
		this.facultyDetails = facultyDetails;
	}

	public Map<String, Date> getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(Map<String, Date> dateInfo) {
		this.dateInfo = dateInfo;
	}

	public Properties getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Properties technologies) {
		this.technologies = technologies;
	}

	
	
}
