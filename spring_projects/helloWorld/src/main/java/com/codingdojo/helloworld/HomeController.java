package com.codingdojo.helloworld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/hello")
public class HomeController {
	 // 1. Annotation
    // 3. Method that maps to the request route above
	@RequestMapping("")
    public String hello() { // 3
            return "Hello World!";
}
    @RequestMapping ("/world")
    public String world () {
    	return "demo.jsp";
    	
}
    }
