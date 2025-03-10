package com.Book_Store.Book_Store_Management.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

	@GetMapping("/")
	public String home() {
			return "home"; 
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister"; 
}
	
	@GetMapping("/Book_List")
	public String Book_List() {
		return "Book_List";
	}
}
 