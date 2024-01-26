package com.nakayama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nakayama.form.BookForm;
import com.nakayama.form.EditBookForm;
import com.nakayama.model.Book;
import com.nakayama.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/book-list")
	public String bookList(Model model) {
		
		//serviceを使って、本の一覧をDBから取得する
		List<Book> bookList = service.findAll();
		//modelに本の一覧を設定して、画面に渡す
		model.addAttribute("bookList", bookList);
		//bookList.htmlの表示
		return "bookList";
	}
	
	/**
	 * 新規登録画面を表示
	 * @param model
	 * @return 新規登録画面
	 */
	@GetMapping("/book-create")
	public String createBook(Model model) {
		model.addAttribute("bookForm", new BookForm());
		
		return "add";
	}
	
	/**
	 * データベースに本を登録する
	 * @param bookForm
	 * @param model
	 * @return 
	 */
	@PostMapping("/book-create")
	public String saveBook(@ModelAttribute @Validated BookForm bookForm, BindingResult result, Model model) {
		
		//バリデーションエラーの場合
		if(result.hasErrors()) {
			// エラーメッセージを追加
			model.addAttribute("bookForm", bookForm);
			//新規登録画面に遷移
			return "add";
		}
		
		//本を登録する
		service.insert(bookForm);
		
		//本の一覧表示画面にリダイレクト
		return "redirect:/book-list";
	}
	
	//編集画面を表示
	@GetMapping("/book-edit")
	public String editBook(Model model, EditBookForm editBook) {
		
		editBook = service.getOneBook(editBook.getId());
		model.addAttribute(editBook);
		
		return "edit";
	}
	
	//本の情報を更新
	@PostMapping("/book-edit")
	public String update(@ModelAttribute @Validated EditBookForm editBook, BindingResult result,Model model) {
		
		//バリデーションエラーの場合
		if(result.hasErrors()) {
			//編集画面に遷移
			return "edit";
		}
		
		//本を更新
		service.update(editBook);
		
		//本の一覧画面にリダイレクト
		return "redirect:/book-list";
	}
	
	//本の削除
	@GetMapping("/book-delete")
	public String deleteBook(Model model, Book Book) {
		//データーベースのデータ削除
		service.delete(Book.getId());
		//本の一覧画面にリダイレクト
		return "redirect:/book-list";
	}

}
