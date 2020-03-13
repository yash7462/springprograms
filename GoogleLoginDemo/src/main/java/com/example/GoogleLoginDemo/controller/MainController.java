package com.example.GoogleLoginDemo.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("name", principal.getAttribute("name"));
	}

	@GetMapping("/error")
	public String error(HttpServletRequest request) {
		String message = (String) request.getSession().getAttribute("error.message");
		request.getSession().removeAttribute("error.message");
		return message;
	}
	
	@GetMapping("/showuserinfo")
	public OAuth2User showuserinfo(@AuthenticationPrincipal OAuth2User principal) {
		return principal;
	}


	/*
	 * @Autowired UserService userservice;
	 * 
	 * @GetMapping("/hello") public String showdata() { return "hello world"; }
	 * 
	 * @GetMapping("/showinfo") public String showdata1() { return
	 * "you are logged in"; }
	 * 
	 * @RequestMapping("/showdata") public String showform() {
	 * 
	 * return "getdata"; }
	 * 
	 * @RequestMapping("/adddata") public String user(@AuthenticationPrincipal
	 * OAuth2User principal, Model m) { m.addAttribute("command",
	 * userservice.save(principal)); return "success";
	 * 
	 * }
	 * 
	 * @RequestMapping("/showall")
	 * 
	 * @ResponseBody public Principal user(Principal principal) { return principal;
	 * }
	 * 
	 * 
	 * @GetMapping("/user") public Map<String, Object> user(@AuthenticationPrincipal
	 * OAuth2User principal) { return Collections.singletonMap("name",
	 * principal.getAttribute("name")); }
	 */

}
