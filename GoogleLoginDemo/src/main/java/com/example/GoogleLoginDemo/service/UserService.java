package com.example.GoogleLoginDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.GoogleLoginDemo.bean.UserDetail;
import com.example.GoogleLoginDemo.dao.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	@Autowired
	UserDetail user;
	/**
	 * 
	 * @param principal
	 * @return
	 */
	public int save(OAuth2User principal) {
		/*if(dao.getUserByEmail(principal.getAttribute("email")) != null) {
            return 0;
		}
		else {*/
			return dao.save(principal);		
		}	
	
	
	

}
