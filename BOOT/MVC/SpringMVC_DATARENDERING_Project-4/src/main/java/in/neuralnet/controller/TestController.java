package in.neuralnet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.neuralnet.model.PlayerDetails;

@Controller
public class TestController {

	@GetMapping
	public String ShowHome()
	{
		return "home";
	}
	
	@GetMapping(value = "/report")
	public String ShowReport(Map<String, Object> model)
	{
		
		model.put("Name", "Ronaldo");
		model.put("Team", "Real Madrid");
		model.put("Age", 39);
		model.put("Sport", "Soccer");
		
		String teams[] = {"Real madrid","FC Barcelona","Atletico Madrid","Manchester united"};
		model.put("teams", teams);
		
		  List<String> list = new ArrayList<String>();
		  list.add("Luka Modric");
		  list.add("Xavi Alonso");
		  list.add("Sunil Chettri");
		  list.add("Lionel Messi");
		  
		model.put("list", list);
		  
		 Map<String, Object> maps = new HashMap<String, Object>();
		 maps.put("ID", 899);
		 maps.put("Name", "K9-Hunter");
		 maps.put("Team", "Furios-5");
		 maps.put("Speed", "133mph");
		 maps.put("Weapon", "911 Pistol");
		 
		 model.put("maps", maps);
		 
		 List<PlayerDetails> plist = List.of(new PlayerDetails(007,"MSD","CSK",120000.2),
				 							 new PlayerDetails(10,"Sachin","MI",18000.3),
				 							new PlayerDetails(007,"Ronaldo","Real Madrid",190000.99),
				 							new PlayerDetails(10,"Messi","FC Barcelona",19000200.12));
		 model.put("plist", plist);
		 
		
		return "report";
	}
}
