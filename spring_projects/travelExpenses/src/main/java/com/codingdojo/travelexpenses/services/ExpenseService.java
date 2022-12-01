package com.codingdojo.travelexpenses.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.travelexpenses.models.Expense;
import com.codingdojo.travelexpenses.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// returns all expenses
	public ArrayList<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	// creates a new expense
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	// retrieves expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
	// updates expense
	public Expense updateExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	// delete expense
	public void delete(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		}
	}
}
