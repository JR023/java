package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	private UserService userService;

	//***GET MAPPINGS***
	
	@GetMapping("/dashboard/{bookId}")
	public String showBook(Model model, 
			@PathVariable("bookId") Long bookId,
			HttpSession session) {
		
		if(session.getAttribute("id")==null) {
			return "redirect:/";
		}
		
		Book book = bookService.findBook(bookId);
	
		model.addAttribute("book", book);
		
		Long id = (Long)session.getAttribute("id");
		User user = userService.findById(id);
		model.addAttribute("user", user);
		
		return "view.jsp";
	}
	
	@GetMapping("/dashboard/new")
	public String newBook(@ModelAttribute("book") Book book,
			Model model,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("id");
		User user = userService.findById(id);
		model.addAttribute("user", user);
		
		return "new.jsp";
	}
	
	
	@GetMapping("/dashboard/edit/{id}")
	public String editBook(@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
		
		Book book = this.bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PutMapping("/dashboard/edit/{id}")
	public String updateBook(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result,
			HttpSession session) {
		
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			bookService.updateBook(book);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/dashboard/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long bookId,
			HttpSession session) {
		if (session.getAttribute("id")==null) {
			return "redirect:/logout";
		}
		
		bookService.deleteBook(bookService.findBook(bookId));
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard/borrow/{bookId}")
	public String borrowBook(@PathVariable("bookId") Long bookId,
			HttpSession session)
	{
		Long id = (Long) session.getAttribute("id");
		if(id == null) {
			return "redirect:/logout";
		}
		
		bookService.addBorrower(bookService.findBook(bookId), userService.findById(id));
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard/return/{bookId}")
	public String returnBook(@PathVariable("bookId") Long bookId,
			HttpSession session)
	{
		if(session.getAttribute("id") == null) {
			return "redirect:/logout";
		}
		
		bookService.removeBorrower(bookService.findBook(bookId));
		return "redirect:/dashboard";
	}
	
	//***POST MAPPINGS***
	
	@PostMapping("/createBook")
	public String create(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "new.jsp";
		}
		
		bookService.createBook(book);
		return "redirect:/dashboard";
		
	}
	
}
