package com.Book_Store.Book_Store_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book_Store.Book_Store_Management.Entity.Book;
import com.Book_Store.Book_Store_Management.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repo;

	public void add(Book b) {
         repo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
	    return repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
	}
	
	public void deletebyId(int id) {
		repo.deleteById(id);
	}

}
