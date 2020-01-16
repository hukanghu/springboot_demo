package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/huk")
public class IndexController {

	    @RequestMapping("/index")
	    public String index()  {
	    	 ///ModelAndView mv =  new ModelAndView("huk");
	         return "DataGrid/DataGridPageSelect";
	    }
	    
	    @RequestMapping("/index_test")
	    public String index_test() {
	    	
	    	return "tablejoin/FatherAndSon";
	    }
	    
	    
}
