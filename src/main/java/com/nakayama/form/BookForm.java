package com.nakayama.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookForm {
	
    /**
     * 本のタイトルを保持
     * チェック：空でないこと
     */
    @NotBlank(message = "タイトルを入力してください。")
    private String title;

    /**
     * 本の値段を保持
     * チェック：正の値であること
     */
    @NotNull(message = "値段を入力してください。")
    @Positive(message = "値段は正の値にしてください。")
    private Integer price;
}
