package com.ap.app.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ap.app.component.VideoResource;
import com.ap.app.entity.MediaInfo;

/**
 *  HATEOAS全称:超媒体即状态应用引擎 (Hypermedia As The Engine Of Application State)
 * 
 * @author sunqx
 * 
 *
 */

@Controller
@ExposesResourceFor(value=MediaInfo.class)
@RequestMapping(value="/video")
public class MediaFindController {

	//领域对象的Link
	//private @Resource(type=EntityLinks.class)@Qualifier(value="entityLinks") EntityLinks entityLinks;
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public  ResponseEntity<?> query(@PathVariable(value="id") Long id){
		
		
		/*Link testmediaLink = entityLinks.linkToSingleResource(MediaInfo.class, id);
		
		//mediaLink.getVariableNames();
		Link testmediaLink2 = linkTo(MediaFindController.class).withRel("video");
		//assertThat(mediaLink2.getRel(), is("people"));
		//assertThat(mediaLink2.getHref(), endsWith("/people"));
		MediaInfo media = new MediaInfo(1L, "长沙游玩", 1, new Date());
		Link testmediaLink3 = linkTo(MediaFindController.class).slash(media).withSelfRel();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(linkTo(MediaFindController.class).slash(media).toUri());
		return new ResponseEntity<VideoResource>(headers, HttpStatus.CREATED);*/
		return null;
	} 
	
	
}
