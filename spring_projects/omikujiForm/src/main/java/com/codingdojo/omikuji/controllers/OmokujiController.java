package com.codingdojo.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmokujiController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	} 
	
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public String process(
		@RequestParam(value="number") String numberParam,
		@RequestParam(value="city") String cityParam,
		@RequestParam(value="name") String nameParam,
		@RequestParam(value="job") String jobParam,
		@RequestParam(value="thing") String thingParam,
		@RequestParam(value="something") String somethingParam,
		HttpSession session
		
	) {
		session.setAttribute("number", numberParam);
		session.setAttribute("city", cityParam);
		session.setAttribute("name", nameParam);
		session.setAttribute("job", jobParam);
		session.setAttribute("thing", thingParam);
		session.setAttribute("something", somethingParam);
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
}
