package com.nakayama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nakayama.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {

}
