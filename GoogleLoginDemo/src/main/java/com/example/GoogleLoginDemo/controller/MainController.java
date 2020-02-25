package com.example.GoogleLoginDemo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.GoogleLoginDemo.service.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userservice;

	@RequestMapping("/")
	public String showform() {

		return "getdata";
	}

	@RequestMapping("/user")
	@ResponseBody
	public String loginwithgoogle() {

		return "hello world";
	}

	@RequestMapping("/showinformation")
	
	public String user(@AuthenticationPrincipal OAuth2User principal, Model m) {
		m.addAttribute("command", userservice.save(principal));
		return "success";

	}
	
	@RequestMapping("/email")
    public String login(Model m, @RequestParam(value = "email", required = false) String email) {
		m.addAttribute("command", userservice.getUserByEmail(email));
			
        return "success";
    }

	@RequestMapping("/showall")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}

}
