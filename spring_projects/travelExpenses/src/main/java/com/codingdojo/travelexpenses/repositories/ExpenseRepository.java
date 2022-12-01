package com.codingdojo.travelexpenses.repositories;
//import
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.travelexpenses.models.Expense;
//extend to name and id
@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	ArrayList<Expense> findAll();
}