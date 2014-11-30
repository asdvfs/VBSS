package com.ap.app.test;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BetResourceAssembler extends ResourceAssemblerSupport<Bet, BetResource> {

	
	public BetResourceAssembler() {
		super(BetController.class, BetResource.class);
	}

	public BetResource toResource(Bet entity) {
		BetResource etResource= instantiateResource(entity);
		etResource.add(ControllerLinkBuilder.linkTo(BetController.class).slash(entity.getId()).withSelfRel());
		etResource.bet=entity;
		
		return etResource;
	}

}
