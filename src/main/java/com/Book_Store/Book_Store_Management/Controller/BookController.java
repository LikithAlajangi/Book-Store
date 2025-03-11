package com.Book_Store.Book_Store_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Book_Store.Book_Store_Management.Entity.Book;
import com.Book_Store.Book_Store_Management.Service.BookService;



@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String home() {
			return "home"; 
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister"; 
}
	
	@GetMapping("/myBooks")
	public String cartBooks() {
		return "myBooks";
	}
	
	@GetMapping("/Book_List")
	public ModelAndView Book_List() {
		List<Book> list = service.getAllBooks();
		return new ModelAndView("Book_List","book",list);
	}public BookController() {
		// TODO Auto-generated constructor stub
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		//TODO: process POST request
		service.add(b);
		return "redirect:/Book_List";
	}
	
}
 
