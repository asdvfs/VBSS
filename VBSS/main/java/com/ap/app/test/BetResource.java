package com.ap.app.test;

import org.springframework.hateoas.ResourceSupport;

/**
 * 资源类
 * DTO
 * 需要有getter方法
 * @author Administrator
 *
 */
public class BetResource extends ResourceSupport {
	
	public Bet bet;
	
	public BetResource() {
		//无参构造器
	}
	
	
	
	
	/**
	 * @return the bet
	 */
	public Bet getBet() {
		return bet;
	}
	

}
