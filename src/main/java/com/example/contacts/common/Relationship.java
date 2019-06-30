package com.example.contacts.common;

import com.example.contacts.util.I18nUtils;

/**
 * 关系
 * 
 * @author 李海涛 2016年7月12日
 */
public enum Relationship {
	ASSISTANT(I18nUtils.getString("relationship.assistant")),
	BROTHER(I18nUtils.getString("relationship.brother")),
	CHILD(I18nUtils.getString("relationship.child")),
	DOMESTICPARTNER(I18nUtils.getString("relationship.domesticpartner")),
	FATHER(I18nUtils.getString("relationship.father")),
	FRIEND(I18nUtils.getString("relationship.friend")),
	MANAGER(I18nUtils.getString("relationship.manager")),
	MOTHER(I18nUtils.getString("relationship.mother")),
	PARENT(I18nUtils.getString("relationship.parent")),
	PARTNER(I18nUtils.getString("relationship.partner")),
	REFERREDBY(I18nUtils.getString("relationship.referredby")),
	RELATIVE(I18nUtils.getString("relationship.relative")),
	SISTER(I18nUtils.getString("relationship.sister")),
	SPOUSE(I18nUtils.getString("relationship.spouse")),
	OTHER(I18nUtils.getString("relationship.other"));

	private String value;

	private Relationship(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
