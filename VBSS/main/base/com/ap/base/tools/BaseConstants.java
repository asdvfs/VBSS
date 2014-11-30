package com.ap.base.tools;

import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * 常量类
 * @author sunqx
 *
 */
public final class BaseConstants {
	
	
    /**
     * Spring会创建一个WebApplicationContext上下文，称为父上下文（父容器） ，
     * 保存在 ServletContext中，
     * key是WebApplicationContext.
     * ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE的值。
     * 
     * 
     * 可以使用Spring提供的工具类取出上下文对象：WebApplicationContextUtils.
     * getWebApplicationContext(ServletContext);
     * 
     * 
     */
	public final static String webAppContextKey = WebApplicationContext.class.getName() + ".ROOT";
	
	
	
	
}
