package com.example.GoogleLoginDemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import com.example.GoogleLoginDemo.bean.UserDetail;
@Component
public class UserDao {
	
	
	
	 JdbcTemplate template;

	    public JdbcTemplate getJdbcTemplate() {
	        return template;
	    }
	    @Autowired
	    public void setJdbcTemplate(JdbcTemplate template) {
	        this.template = template;
	    }
	

	public int save(OAuth2User principal) {
		
		String sql = "insert into userlogin(name,emailid) values('" + principal.getAttribute("name") + "','" + principal.getAttribute("email") + "')";
		return template.update(sql);
	
	}
	
	public UserDetail getUserByEmail(String email) {
	    String sql = "SELECT* FROM userlogin WHERE emailid=?";
	    return template.queryForObject(sql, new Object[] { email }, new BeanPropertyRowMapper<UserDetail>(UserDetail.class));
	  }

}
