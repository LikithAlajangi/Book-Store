package com.Book_Store.Book_Store_Management.Controller;

import java.util.List;

import org.slf4j.helpers.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Book_Store.Book_Store_Management.Entity.Book;
import com.Book_Store.Book_Store_Management.Entity.BookList;
import com.Book_Store.Book_Store_Management.Service.BookService;
import com.Book_Store.Book_Store_Management.Service.MyBookService;



@Controller
public class BookController {

	@Autowired
	private BookService service;
	@Autowired
	private MyBookService CartService;
	
	@GetMapping("/")
	public String home() {
			return "home"; 
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister"; 
}
	
	@GetMapping("/myBooks")
	public String cartBooks(Model m) {
		List<BookList> list = CartService.getAllCartBooks();
	       m.addAttribute("book",list);
		return "myBooks";
	}
	
	
	@GetMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		 Book book = service.getBookById(id);
		 BookList b = new BookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
		 CartService.saveBook(b);
		return "redirect:/myBooks";
		 
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
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model m) {
		//TODO: process PUT request
		Book b = service.getBookById(id);
		m.addAttribute("book", b);
		
		return "bookEdit";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		service.deletebyId(id);
		return "redirect:/Book_List";
	}
	
}
 
