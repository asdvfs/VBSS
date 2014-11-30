package com.ap.app.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ap.app.component.Greeting;
import com.ap.app.entity.User;
import com.ap.app.entity.vo.UserInfo;

@Controller
@RequestMapping(value="/order")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
    	 
    	System.out.println("你好-------------11;"+name);
        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        System.out.println("-----------------------------");
        /*Link link = linkTo(GreetingController.class).withRel("order");
        System.out.println(link+"----------");*/
        
        ResponseEntity<Greeting> resEntity = new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
        //ResponseEntity<Greeting> resEntity= ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(greeting);
        
        return resEntity;
    }
    
    @RequestMapping(value="/handle")
    public HttpEntity<String> test(){
    	System.out.println("-----------------------------");
    	 /*HttpMethod method = (request).getMethod();
    	 URI url = request.getUrl();
    	 String body = request.getBody();
    	 System.out.println(method.name());
    	  System.out.println(url);
    	  System.out.println(body);*/
    	  
    	 return new ResponseEntity<String>("--------------aass", HttpStatus.OK);
    }
    
    @RequestMapping(value="/handle2")
    public void test2(RequestEntity<String> request){
    	System.out.println("-----------------------------");
    	 HttpMethod method = (request).getMethod();
    	 URI url = request.getUrl();
    	 String body = request.getBody();
    	 System.out.println(method.name());
    	  System.out.println(url);
    	  System.out.println(body);
    	  
    }
    
    
    @RequestMapping(value="/handle3", headers={"multipart/form-data"})
    public void test3(RequestEntity<String> request){
    	System.out.println("-----------------------------");
    	
    	 HttpMethod method = (request).getMethod();
    	 URI url = request.getUrl();
    	 String body = request.getBody();
    	 System.out.println(method.name());
    	  System.out.println(url);
    	  System.out.println(body);
    	  
    }
    
    @RequestMapping(value="/greeting2", method=RequestMethod.GET)
    @ResponseBody
    public User greeting2(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name
            ,UserInfo userInfo) {
    	
    	System.out.println("你好-------------11;"+name+"--------session中的User："+userInfo);
        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        System.out.println("-----------------------------");
        /*Link link = linkTo(GreetingController.class).withRel("order");
        System.out.println(link+"----------");*/
        
        //org.springframework.web.context.request.ServletRequestAttributes
        
        //ResponseEntity<Greeting> resEntity = new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
        //ResponseEntity<Greeting> resEntity= ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(greeting);
        User user=new User();
        user.setName("asda");
        return user;
    }
    
    
    @RequestMapping(value="/greeting3", method=RequestMethod.GET)
    @ResponseBody
    public User greeting3(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name
            ,UserInfo userInfo, @RequestBody User user1) {
    	
    	System.out.println("你好-------------11;"+name+"--------session中的User："+userInfo+"----requestBody:"+user1);
        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        System.out.println("-----------------------------");
        /*Link link = linkTo(GreetingController.class).withRel("order");
        System.out.println(link+"----------");*/
        
        //org.springframework.web.context.request.ServletRequestAttributes
        
        //ResponseEntity<Greeting> resEntity = new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
        //ResponseEntity<Greeting> resEntity= ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(greeting);
        User user = new User();
        user.setName("asda");
        return user;
    }
    
}
