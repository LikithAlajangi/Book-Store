package com.Book_Store.Book_Store_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book_Store.Book_Store_Management.Entity.BookList;
import com.Book_Store.Book_Store_Management.repository.myBookRepo;
@Service
public class MyBookService {
	@Autowired
	private myBookRepo bookRepo;
public void saveBook(BookList b) {
	bookRepo.save(b);
}

public List<BookList> getAllCartBooks(){
	
	return bookRepo.findAll();
	
}

public void deleteId(int id) {
	bookRepo.deleteById(id);
}
}
