package com.ap.app.component.handler;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 
 * 
 * ����������
 * �Ծ�̬��������Spring ApplicationContext, �����κδ����κεط��κ�ʱ����ȡ��ApplicaitonContext. 
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
	* ȡ�ô洢�ھ�̬�����е�ApplicationContext.
	*/
	public static ApplicationContext getApplicationContext() {
	checkApplicationContext();
	return applicationContext;
	}

	/**
	* �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
	checkApplicationContext();
	return (T) applicationContext.getBean(name);
	}

	/**
	* �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
	checkApplicationContext();
	return (T) applicationContext.getBeansOfType(clazz);
	}

	/**
	* ���applicationContext��̬����.
	*/
	public static void cleanApplicationContext() {
	applicationContext = null;
	}

	private static void checkApplicationContext() {
	if (applicationContext == null) {
	throw new IllegalStateException("applicaitonContextδע��,����applicationContext.xml�ж���SpringContextHolder");
	}
	}
	

}
