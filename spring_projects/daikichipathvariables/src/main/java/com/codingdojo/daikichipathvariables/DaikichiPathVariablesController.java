package com.codingdojo.daikichipathvariables;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/daikichi")
public class DaikichiPathVariablesController {
		@RequestMapping("")
		public String hello() {
			return "Welcome!";
		}
		
		@RequestMapping("/today")
		public String today() {
			return "Today you will find luck in all your endeavors!";
		}
		
		@RequestMapping("/tomorrow")
		public String tomorrow() {
			return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
		}
		//add two new routes
		//destination routing
		@RequestMapping("/travel/{destination}")
		public String travel(@PathVariable("destination") String destination) {
			return String.format("Congratulations! You will soon travel to %s!", destination);
		}
		//lotto routing
		//if else statement - even grand journey else spend with friends
		@RequestMapping("/lotto/{num}")
		public String lotto(@PathVariable("num") Integer num) {
			if (num % 2 == 0) {
				return "You will take a grand journey in the near future, but be wary of tempting offers.";
			}
			else {
				return "You have enjoyed the fruits of your labor but now is a great time to spend with family and friends.";
			}
		}
}
