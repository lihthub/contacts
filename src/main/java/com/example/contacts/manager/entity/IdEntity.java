package com.example.contacts.manager.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 统一定义id的entity基类<p>
 * 
 * 标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射
 * 到数据库表，但是他的属性都将映射到其子类的数据库字段中。
 * 
 * @author 李海涛 2016年7月11日
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class IdEntity implements Serializable {
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
