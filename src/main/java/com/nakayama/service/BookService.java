package com.nakayama.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nakayama.form.BookForm;
import com.nakayama.form.EditBookForm;
import com.nakayama.model.Book;
import com.nakayama.repository.BookRepository;

@Service
@Transactional

public class BookService {
	
	@Autowired
	BookRepository repository;
	
	/**
	 * データベースから本の一覧を取得する
	 * @return
	 */
	public List<Book> findAll() {
		return repository.findAll();
	}
	
	/**
	 * データベースにデータを登録する
	 * @return
	 */
	public void insert(BookForm bookForm) {
		//データベースに登録する値を保持するインスタンス
		Book book = new Book();
		
		//画面から受け取った値をデータベースに保存するインスタンスに渡す
		book.setTitle(bookForm.getTitle());
		book.setPrice(bookForm.getPrice());
		
		//データベースに登録する
		repository.save(book);
	}
	
	//受け取ったidからデータを取得、Formを返す
	public EditBookForm getOneBook(Integer id) {
		//idを指定して本の情報を取得する
		Book book = repository.findById(id).orElseThrow();
		
		//画面返却用のFormに値を設定
		EditBookForm editBook = new EditBookForm();
		editBook.setId(book.getId());
		editBook.setTitle(book.getTitle());
		editBook.setPrice(book.getPrice());
		
		return editBook;
	}
	
	//本を更新する
	public void update(EditBookForm editBook) {
		//データベースに登録する値を保持するインスタンス
		Book book = new Book();
		
		//画面から受け取った値を設定する
		book.setId(editBook.getId());
		book.setTitle(editBook.getTitle());
		book.setPrice(editBook.getPrice());
		
		//データベース更新
		repository.save(book);
	}

}
