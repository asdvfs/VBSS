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
import javax.persistence.Transient;

import org.springframework.hateoas.Identifiable;

/**
 *  domain class or model class
 * 
 * @author sunqx
 *
 */
@Entity(name="mediaInfo")
@Table(name="media")
public class MediaInfo implements Serializable,Identifiable<Long> {
	
	@Id
	@GeneratedValue
	@Column(nullable=false)
	public Long id;
	
	@Column(length=100,nullable=false)
	public String mediaName ;
	
	//·��
	@Column(length=200,nullable=false)
	public String mediaPath ;
	
	
	//��ý��Ĵ�С
	@Column(nullable=false)
	public Integer size ;
	
	//ý������
	@Column(nullable=false)
	public Integer kind ;
	
	//public Long id;�ϴ�ʱ��
	@Column(nullable=false)
	public Date createDate ;
	
	
	//ý�����
	@Column(length=255)
	public String desc ;
	
	
	//ý������ʱ��
	@Transient
	public Date constructDate;
	
	public MediaInfo() {
	}

	/**
	 * @param id
	 * @param mediaName
	 * @param kind
	 * @param createDate
	 */
	public MediaInfo(Long id, String mediaName, Integer kind, Date createDate) {
		super();
		this.id = id;
		this.mediaName = mediaName;
		this.kind = kind;
		this.createDate = createDate;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//hateoas�õ���
	public Long getId() {
		return this.id;
	}
	
}
