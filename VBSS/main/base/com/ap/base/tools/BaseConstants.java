package com.ap.base.tools;

import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * ������
 * @author sunqx
 *
 */
public final class BaseConstants {
	
	
    /**
     * Spring�ᴴ��һ��WebApplicationContext�����ģ���Ϊ�������ģ��������� ��
     * ������ ServletContext�У�
     * key��WebApplicationContext.
     * ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE��ֵ��
     * 
     * 
     * ����ʹ��Spring�ṩ�Ĺ�����ȡ�������Ķ���WebApplicationContextUtils.
     * getWebApplicationContext(ServletContext);
     * 
     * 
     */
	public final static String webAppContextKey = WebApplicationContext.class.getName() + ".ROOT";
	
	
	
	
}
