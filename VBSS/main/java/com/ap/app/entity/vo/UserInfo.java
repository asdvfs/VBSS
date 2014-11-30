package com.ap.app.entity.vo;

/**
 * 
 * @author sunqx
 *
 */
public class UserInfo {
	
    public  long id;
	
	public String name;
	
	public String sfz;
	
	public String telNo;
	
	public UserInfo() {
		//无参构造器
	}

	/**
	 * @param id
	 * @param name
	 * @param sfz
	 * @param telNo
	 */
	public UserInfo(long id, String name, String sfz, String telNo) {
		super();
		this.id = id;
		this.name = name;
		this.sfz = sfz;
		this.telNo = telNo;
	}


	/**
	 * @param name
	 * @param sfz
	 * @param telNo
	 */
	public UserInfo(String name, String sfz, String telNo) {
		super();
		this.name = name;
		this.sfz = sfz;
		this.telNo = telNo;
	}
	
	
	
	
}
