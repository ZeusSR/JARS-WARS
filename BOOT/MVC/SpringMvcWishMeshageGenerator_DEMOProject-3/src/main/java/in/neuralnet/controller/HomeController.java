package in.neuralnet.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.neuralnet.service.IWishMessageService;

@Controller
public class HomeController {
	
	@Autowired
	IWishMessageService service;
	
//	@GetMapping("/welcome")
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String ShowHomePage()
	{
		return "welcome";
		
	}
	
	@GetMapping(value = "/wish")
	public ModelAndView showWishMessage()
	{
		String msg = service.generateMessage();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("home");
		
		return mav;
	}
	
/*Invasive
 * 	@GetMapping(value = "/hour")
	public String showHour(Model model)
	{
		Integer msg = service.generateHour();
		model.addAttribute("msg",msg);
		
		
		return "hour";
	}
*/	
	
//	Non-Invasive
	@GetMapping(value = "/hour")
	public String showHour(Map<String, Object> model)
	{
		Integer msg = service.generateHour();
		model.put("msg",msg);
		
		
		return "hour";
	}
	@GetMapping(value = "/minute")
	public void showMinute(Map<String, Object> model)
	{
		Integer msg = service.generateMinute();
		model.put("msg",msg);
		
		
		
	}
}
