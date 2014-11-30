/**
 * 
 */
package com.ap.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author sunqx
 *
 */
@Entity(name="user")
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String name;
	
	private String sfz;
	
	private String telNo;
	
	private Date createDate= new Date();
	
	public User() {
	}

	/**
	 * @param id
	 * @param name
	 * @param sfz
	 * @param telNo
	 */
	public User(long id, String name, String sfz, String telNo) {
		super();
		this.id = id;
		this.name = name;
		this.sfz = sfz;
		this.telNo = telNo;
	}
	

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(nullable=false,name="id")
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@Column(name="name",length=100)
	
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sfz
	 */
	@Column(name="sfhm",length=20)
	public String getSfz() {
		return sfz;
	}

	/**
	 * @param sfz the sfz to set
	 */
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	/**
	 * @return the telNo
	 */
	@Column(name="telNo",length=30)
	public String getTelNo() {
		return telNo;
	}

	/**
	 * @param telNo the telNo to set
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * @return the createDate
	 */
	@Column(name="createTime")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
