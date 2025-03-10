package com.Book_Store.Book_Store_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Book_Store.Book_Store_Management.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
