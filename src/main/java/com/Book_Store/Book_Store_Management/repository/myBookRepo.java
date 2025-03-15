package com.Book_Store.Book_Store_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Book_Store.Book_Store_Management.Entity.BookList;

@Repository
public interface myBookRepo extends JpaRepository<BookList, Integer>{

}
