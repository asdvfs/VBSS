package com.ap.app.test;

import org.springframework.hateoas.ResourceSupport;

/**
 * ��Դ��
 * DTO
 * ��Ҫ��getter����
 * @author Administrator
 *
 */
public class BetResource extends ResourceSupport {
	
	public Bet bet;
	
	public BetResource() {
		//�޲ι�����
	}
	
	
	
	
	/**
	 * @return the bet
	 */
	public Bet getBet() {
		return bet;
	}
	

}
