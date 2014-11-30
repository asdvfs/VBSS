package com.ap.app.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/bet")
public class BetController {
	 private BetService betService;
	 private BetResourceAssembler betResourceAssembler;
	 
	 public BetController(BetService betService,
			   BetResourceAssembler betResourceAssembler) {
			  this.betService = betService;
			  this.betResourceAssembler = betResourceAssembler;
			 }
			 
			 @RequestMapping(method = RequestMethod.POST)
			 ResponseEntity<BetResource> createBet(@RequestBody Bet body) {
			  Bet bet = betService.createBet(body.getMarketId(),
			    body.getSelectionId(), body.getPrice(), body.getStake(),
			    body.getType());
			  BetResource resource = betResourceAssembler.toResource(bet);
			  return new ResponseEntity<BetResource>(resource, HttpStatus.CREATED);
			 }
			 
			 
			 @RequestMapping(method = RequestMethod.PUT, value = "/{betId}")
			 ResponseEntity<BetResource> updateBet(@PathVariable Long betId,
			   @RequestBody Bet body) throws BetNotFoundException, BetNotUnmatchedException {
			  Bet bet = betService.updateBet(betId, body);
			  BetResource resource = betResourceAssembler.toResource(bet);
			  return new ResponseEntity<BetResource>(resource, HttpStatus.OK);
			 }
			 
			 @RequestMapping(method = RequestMethod.GET, value = "/{betId}")
			  ResponseEntity<BetResource> getBet(@PathVariable Long betId) throws BetNotFoundException {
			  Bet bet = betService.getBet(betId);
			  BetResource resource = betResourceAssembler.toResource(bet);
			  if (bet.getStatus() == BetStatus.UNMATCHED) {
			   resource.add(linkTo(BetController.class).slash(bet.getId()).withRel("cancel"));
			  }
			  return new ResponseEntity<BetResource>(resource, HttpStatus.OK);
			 }
			 
			 @RequestMapping(method = RequestMethod.GET)
			 ResponseEntity<List<BetResource>> getBets() {
			  List<Bet> betList = betService.getAllBets();
			  List<BetResource> resourceList = betResourceAssembler.toResources(betList);
			  return new ResponseEntity<List<BetResource>>(resourceList, HttpStatus.OK);
			 }
			 
			 @RequestMapping(method = RequestMethod.DELETE, value = "/{betId}")
			 ResponseEntity<BetResource> cancelBet(@PathVariable Long betId) {
			  Bet bet = betService.cancelBet(betId);
			  BetResource resource = betResourceAssembler.toResource(bet);
			  return new ResponseEntity<BetResource>(resource, HttpStatus.OK);
			 }
			 
			 @ExceptionHandler
			 ResponseEntity handleExceptions(Exception ex) {
			  ResponseEntity responseEntity = null;
			  if (ex instanceof BetNotFoundException) {
			   responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
			  } else if (ex instanceof BetNotUnmatchedException) {
			   responseEntity = new ResponseEntity(HttpStatus.CONFLICT);
			  } else {
			   responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
			  return responseEntity;
			 }

}
