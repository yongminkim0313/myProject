package com.my.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.main.service.MainService;
import com.my.security.SecurityUserDetail;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping("/")
	public String index(Authentication authentication) {
		SecurityUserDetail user = (SecurityUserDetail) authentication.getPrincipal();
		System.out.println(user);
		return "index";
	}

//	@RequestMapping("/")
//	public String index(@AuthenticationPrincipal SecurityUserDetail user) {
//		System.out.println(user);
//		return "index";
//	}

	@RequestMapping("/login/loginPage")
	public String login() {
		return "login/loginPage";
	}

	@RequestMapping("/aaaa")
	@ResponseBody
	public Map<String, Object> aaaa(@RequestParam Map<String, Object> reqMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", mainService.selectStudentAttend(reqMap));
		return map;
	}
}
