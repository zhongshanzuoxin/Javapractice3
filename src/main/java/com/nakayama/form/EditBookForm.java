package com.nakayama.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EditBookForm {
	
	/**
	 * 本のIDを保持する
	 * チェック内容：Nullでないこと
	 */
	@NotNull(message="IDがNullになっています")
	private Integer id;
	
	/**
	 * 本のタイトルを保持
	 * チェック内容：未入力
	 */
	@NotBlank(message="タイトルを入力してください")
	private String title;
	
	/**
	 * 本の値段を保持
	 * チェック内容：Nullでないこと、プラスであること
	 */
	@NotNull(message="値段を入力してください")
	@Positive(message="値段はプラスで入力してください")
	private Integer price;

}
