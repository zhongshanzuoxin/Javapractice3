package com.nakayama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //Controllerクラスであることを宣言
public class HelloController {
	
	@RequestMapping(value="/index") //「/index」にリクエストが来た時に呼び出されるメゾット
	public String index() {
		return "index";
	}

}
