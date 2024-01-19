package com.nakayama.form;

import lombok.Data;


@Data
public class BookForm {
	
	/**
	 * 本のタイトルを保持
	 */
	private String title;
		
	/**
	 * 本の値段を保持
	 */
	private Integer price;

}
