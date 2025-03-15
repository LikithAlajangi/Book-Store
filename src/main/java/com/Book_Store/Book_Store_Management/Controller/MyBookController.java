package com.Book_Store.Book_Store_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Book_Store.Book_Store_Management.Service.MyBookService;

@Controller
public class MyBookController {

	@Autowired
	private MyBookService service;
	@GetMapping("/deleteMyList/{id}")
	public String deleteCart(@PathVariable("id") int id) {
		service.deleteId(id);
		return "redirect:/myBooks";
	}
}
