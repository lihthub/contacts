package pers.contacts.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sourceforge.pinyin4j.PinyinHelper;

import pers.contacts.common.Relationship;
import pers.contacts.core.entity.IdEntity;

/**
 * 联系人
 * 
 * @author 李海涛 2016年7月11日
 */
@Entity
@Table(name = "linkman_record")
public class Linkman extends IdEntity {
	private static final long serialVersionUID = -9196055236844194785L;

	private String name; // 姓名
	private String sex; // 性别
	private String email; // 邮箱
	private Date birthday; // 生日
	private String company; // 公司
	private String job; // 职位
	private String address; // 地址
	private String photoUrl; // 头像
	private Relationship relation; // 关系
	private User user; // 用户
	private Date date; // 日期
	private String phone; // 电话

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Enumerated(value = EnumType.ORDINAL)
	public Relationship getRelation() {
		return relation;
	}

	public void setRelation(Relationship relation) {
		this.relation = relation;
	}

	@ManyToOne(targetEntity = User.class, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Transient
	public String getInitial() {
		String name = this.getName() == null ? "" : this.getName();
		String[] array = PinyinHelper.toHanyuPinyinStringArray(name.charAt(0));
		return String.valueOf(array[0].charAt(0)).toUpperCase();
	}
	
	@Transient
	public Integer getAge() {
		if (this.getBirthday() != null) {
			
		}
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
