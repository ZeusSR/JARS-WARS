package in.neuralnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
