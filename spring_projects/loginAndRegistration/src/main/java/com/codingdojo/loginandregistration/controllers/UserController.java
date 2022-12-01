package com.codingdojo.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginandregistration.models.LoginUser;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
	 
	    // Bind empty User and LoginUser objects to the JSP to capture the form input
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "index.jsp";
	    
	}
	 
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	     
		User user = userServ.register(newUser, result);
		
	    if(result.hasErrors()) {
	        // Be sure to send in the empty LoginUser before re-rendering the page.
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/dashboard";
	}
	 
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
	     
		User user = userServ.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
	     
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String welcome(HttpSession session, Model model) {
	 
		// If no userId is found, redirect to logout
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		
	    return "dashboard.jsp";
	    
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);
	     
	    return "redirect:/";
	}
}
