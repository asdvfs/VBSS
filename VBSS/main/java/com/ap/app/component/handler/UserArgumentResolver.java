package com.ap.app.component.handler;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ap.app.entity.vo.UserInfo;
import com.ap.app.tools.MVCConstants;

/**
 * 
 * 在利用spring的mvc开发过程中，需要将User对象从session中取出来使用。
 * 
 * @author Administrator
 * 
 */
@Component("userArgumentResolver")
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		System.out.println("1-------"+parameter.getParameterName());
		if(parameter.getParameterType().equals(UserInfo.class)){
			
			System.out.println("2----"+webRequest.getAttribute(MVCConstants.USER_INFO_IN_SCOPE, RequestAttributes.SCOPE_SESSION));
			
			return webRequest.getAttribute(MVCConstants.USER_INFO_IN_SCOPE, RequestAttributes.SCOPE_SESSION);
		}
		
		return null;
	}

	public boolean supportsParameter(MethodParameter parameter) {
		System.out.println("-------test"+parameter.getParameterName());

		return false;
	}

}
