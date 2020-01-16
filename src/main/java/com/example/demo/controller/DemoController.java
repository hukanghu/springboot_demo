package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/huk")
public class DemoController {
	
	@RequestMapping("/demo")
	public String demo() {
		return "111";
	}
	
	@RequestMapping("/demo1")
	public String demo1() {
		return "222";
	}
}
