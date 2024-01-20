package in.neuralnet.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("feature")
public class Features {
	
	private String Type;
	private String colour;
	private int speed_milesph;
	private String[] Places;
	public Map<String, Object> getRiders() {
		return riders;
	}
	public void setRiders(Map<String, Object> riders) {
		this.riders = riders;
	}
	public Set<Integer> getNumbers() {
		return Numbers;
	}
	public void setNumbers(Set<Integer> numbers) {
		Numbers = numbers;
	}
	private List<String> BestPlaces;
	private Map<String,Object> riders;
	private Set<Integer> Numbers;
	@Override
	public String toString() {
		return "Features [Type=" + Type + ", colour=" + colour + ", speed_milesph=" + speed_milesph + ", Places="
				+ Arrays.toString(Places) + ", BestPlaces=" + BestPlaces + ", riders=" + riders + ", Numbers=" + Numbers
				+ "]";
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getSpeed_milesph() {
		return speed_milesph;
	}
	public void setSpeed_milesph(int speed_milesph) {
		this.speed_milesph = speed_milesph;
	}
	public String[] getPlaces() {
		return Places;
	}
	public void setPlaces(String[] places) {
		Places = places;
	}
	public List<String> getBestPlaces() {
		return BestPlaces;
	}
	public void setBestPlaces(List<String> bestPlaces) {
		BestPlaces = bestPlaces;
	}
	
	

	
	

}
