package com.ap.app.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.ap.app.entity.User;
import com.ap.app.entity.vo.UserInfo;
import com.ap.app.service.UserService;
import com.ap.base.dao.BaseDao;

/**
 * 
 * 
 * @author sunqx
 *
 */
@Controller
@RequestMapping("/user")
public class HelloWorldController {
	
	private  static Logger log =LoggerFactory.getLogger(BaseDao.class);
	
	@Resource
	private UserService<User>  userService;
	
	
	@RequestMapping(value="/login/{id}", method=RequestMethod.GET)
	public ModelAndView login(@PathVariable Long id, @RequestParam(value="name", required = false, defaultValue = "World") String name
			,UserInfo userInfo) throws Exception {
		//org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter
		//RequestMappingHandlerMapping
		//WebArgumentResolver
		System.out.println("hello---------------------------"+name+"--session�еĲ���"+userInfo);
		//1���ռ���������֤����  
	       //2���󶨲������������  
	       //3�������������ҵ��������ҵ����  
	       //4��ѡ����һ��ҳ��  
	       ModelAndView mv = new ModelAndView();  
	       //���ģ������ �����������POJO����  
	       mv.addObject("message", "Hello World!----------------��ȡ��ֵ"+id);  
	       //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
	       mv.setViewName("hello");  
	       
	      // TransactionManager
	       //com.arjuna.ats.jta.TransactionManager
	       //ClassLoaderService
	       //org.hibernate.engine.transaction.jta.platform.spi.JtaPlatformException
	       //org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform
	       //org.hibernate.service.jta.platform.spi.JtaPlatform
	       userService.addUser(new User(1l, "sunqx", "3434", "2222222222"));
	       log.info("-------------------ִ����ϣ�-----");
	       return mv;  
	}

}
