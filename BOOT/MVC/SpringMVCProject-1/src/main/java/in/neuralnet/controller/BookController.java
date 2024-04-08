package in.neuralnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.classic.Logger;
import in.neuralnet.bindings.Book;
import in.neuralnet.service.IBookService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {

	@Autowired
	IBookService service;
	
	@GetMapping("/loadingform")
	public String LoadingForm()
	{
		log.debug("Conrtrol inside Get request....");
		return "index";
	}
	
	@PostMapping("/save")
	public String afterSubmissionDisplay(Book bo,Model model)
	{
		
		log.info("Conrtrol inside Post request....");
		
		model.addAttribute("books", bo);
		Book co = service.addGST(bo);
		
		log.info(co.toString());
		
		return "books";
	}

}

