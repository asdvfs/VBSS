package com.ap.app.component.handler;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class MyServletContext implements ServletContextAware {

	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
       System.out.println(servletContext.getContextPath()+"app------------");
	}

}
