package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	// retrieves book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	// updates book
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
	
	// deletes book
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
	
	// user books
	public List<Book> usersBooks(User user){
		return bookRepository.findByUserId(user.getId());
	}
	
	// unborrowed books
	public List<Book> unborrowedBooks(User user){
		return bookRepository.findByBorrowerOrUserId(null, user.getId());
	}
	
	// borrowed books
	public List<Book> borrowedBooks(User user){
		return bookRepository.findByBorrowerId(user.getId());
	}
	
	// add borrower
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepository.save(book);
	}
	
	// remove borrower
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepository.save(book);
	}
}
