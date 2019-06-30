package com.example.contacts.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.contacts.manager.entity.IdEntity;

/**
 * 用户
 * 
 * @author 李海涛 2016年7月11日
 */
@Entity
@Table(name = "user_record")
public class User extends IdEntity {
	private static final long serialVersionUID = -6703062019235634026L;

	private String name; // 姓名
	private String password; // 密码
	private String introduce; // 介绍
	private Date date; // 注册时间
	private String sex; // 性别
	private String email; // 邮箱
	private Date birthday; // 生日
	private String company; // 公司
	private String job; // 职位
	private String address; // 地址
	private String photoUrl; // 头像
	private String phone; // 手机号
	
	private String password2; // 确认密码

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Transient
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	@Transient
	public Integer getAge() {
		Calendar birthCal = Calendar.getInstance();
		birthCal.setTime(this.getBirthday());
		int birthYear = birthCal.get(Calendar.YEAR);
		int birthMonth = birthCal.get(Calendar.MONTH);
		int birthDay = birthCal.get(Calendar.DAY_OF_MONTH);
		Calendar nowCal = Calendar.getInstance();
		int nowYear = nowCal.get(Calendar.YEAR);
		int nowMonth = nowCal.get(Calendar.MONTH);
		int nowDay = nowCal.get(Calendar.DAY_OF_MONTH);
		if (nowMonth < birthMonth || (nowMonth == birthMonth && nowDay < birthDay)) {
			// 未过生日
			return nowYear - birthYear - 1;
		} else {
			// 已过生日
			return nowYear - birthYear;
		}
	}
	
}
