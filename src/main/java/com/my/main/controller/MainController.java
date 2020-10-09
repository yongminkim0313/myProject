package com.my.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.main.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping("/")
	public String main() {
		System.out.println("123123");

		return "index";
	}

	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> test(@RequestParam Map<String, Object> reqMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", mainService.selectStudentAttend(reqMap));
		return map;
	}
}
