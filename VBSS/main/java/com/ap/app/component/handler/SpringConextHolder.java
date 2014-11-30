package com.ap.app.component.handler;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 
 * 
 * 来自于网络
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext. 
 *  
 */  
public class SpringConextHolder implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;  
	//ResourceHttpRequestHandler
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		SpringConextHolder.applicationContext = arg0; // NOSONAR  
	}
	/**
	* 取得存储在静态变量中的ApplicationContext.
	*/
	public static ApplicationContext getApplicationContext() {
	checkApplicationContext();
	return applicationContext;
	}

	/**
	* 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
	checkApplicationContext();
	return (T) applicationContext.getBean(name);
	}

	/**
	* 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
	checkApplicationContext();
	return (T) applicationContext.getBeansOfType(clazz);
	}

	/**
	* 清除applicationContext静态变量.
	*/
	public static void cleanApplicationContext() {
	applicationContext = null;
	}

	private static void checkApplicationContext() {
	if (applicationContext == null) {
	throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
	}
	}
	

}
