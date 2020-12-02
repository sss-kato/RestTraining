package jp.go.rest.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.go.rest.request.service.RestTestService;



@Controller
public class RestTestController {
	
	@Autowired
	public RestTestService restService;
	
	@RequestMapping(value = "/test")
	public String doTest(Model model) {
		
		System.out.println("test");
		
		return "index.html";
		
	}
	
	@GetMapping(value = "doRest")
	public String doRest() {
		
		ResponseEntity<String>  res =  restService.requestRest();
		
		System.out.println(res);
		return "index.html";
		
	}
	

}
