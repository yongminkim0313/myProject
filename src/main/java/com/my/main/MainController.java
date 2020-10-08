package com.my.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("/")
	public String main(){
		System.out.println("123123");

		return "index";
	}
	@RequestMapping("/test")
	@ResponseBody public Map<String, Object> test(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zzzz", "Cccc");
		return map;
	}
}
