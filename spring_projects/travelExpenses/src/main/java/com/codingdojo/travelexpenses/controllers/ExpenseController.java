package com.codingdojo.travelexpenses.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codingdojo.travelexpenses.models.Expense;
import com.codingdojo.travelexpenses.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String dashboard(Model model, @ModelAttribute("expense") Expense expense) {
		ArrayList<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, Model model) 
	{
		if(result.hasErrors()) {
			ArrayList<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			
			return "index.jsp";
		}
		
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String getExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = this.expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String updateExpense(
			@PathVariable("id") Long id,
			Model model,
			@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}")
	public String viewExpense(
			@PathVariable("id") Long id,
			Model model)
	{
		Expense expense = this.expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "view.jsp";
	}
	
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		this.expenseService.delete(id);
		return "redirect:/expenses";
	}
}
