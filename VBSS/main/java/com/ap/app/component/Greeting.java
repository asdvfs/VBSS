package com.ap.app.component;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting extends ResourceSupport {

    private  String content;

    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
        System.out.println("获取到的类容;"+this.content+";;"+this.getId());
        System.out.println(this.getLinks());
        System.out.println(this.getLink("order"));
    }
    

    public String getContent() {
        return content;
    }


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
    
    
    
}
