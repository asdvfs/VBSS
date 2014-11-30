/**
 * 
 */
package com.ap.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ap.app.component.UserResource;
import com.ap.app.entity.User;
import com.ap.app.service.UserService;

/**
 * 登陆 ，注册， 登出请求处理
 * 
 * @author sunqx
 *
 */
@Controller
@ExposesResourceFor(User.class)
@RequestMapping("/aopa")
public class UserInfoController extends ResourceSupport {
   
	private final static Logger log = LoggerFactory.getLogger(UserInfoController.class);
	
	
	@SuppressWarnings("unchecked")
	@Autowired
	private UserService userService; 
	
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserResource> login(@PathVariable("id") Long pid){
		//org.springframework.plugin.core.Plugin
		try{
			System.out.println("-----------: "+pid);
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	
	
	
}
